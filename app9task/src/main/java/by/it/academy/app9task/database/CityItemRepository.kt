package by.it.academy.app9task.database

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class CityItemRepository (context: Context) {
    private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private val database = WeatherDB.getDatabase(context)
    private val threadIO = Dispatchers.IO

    fun mainScope() = mainScope

    suspend fun getCitiesList(): List<CityItem> {
        return withContext(threadIO) {
            database.getCitiesDAO().getCitiesList()
        }
    }

    suspend fun addCityGetList(city: CityItem): List<CityItem> {
        return withContext(threadIO) {
            database.getCitiesDAO().addCityToDB(city)
            return@withContext database.getCitiesDAO().getCitiesList()
        }
    }

    suspend fun removeCityGetList(city: CityItem): List<CityItem> {
        return withContext(threadIO) {
            database.getCitiesDAO().delete(city)
            return@withContext database.getCitiesDAO().getCitiesList()
        }
    }
}