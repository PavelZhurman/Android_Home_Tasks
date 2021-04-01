package by.it.academy.app9task.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface WeatherDAO {
    @Query("SELECT * FROM Cities")
    fun getCitiesList(): List<CityItem>

    @Query("SELECT * FROM Cities WHERE cityId = :cityId")
    fun getCity(cityId: Int): CityItem

    @Delete
    fun delete(city: CityItem)

    @Update
    fun update(city: CityItem)

    @Insert
    fun addCityToDB(city: CityItem)
}