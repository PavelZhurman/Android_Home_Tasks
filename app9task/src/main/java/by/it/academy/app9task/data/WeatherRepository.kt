package by.it.academy.app9task.data

import by.it.academy.app9task.data.networkCalls.APIController
import io.reactivex.Single

class WeatherRepository {
    private val newsDataSource: WeatherDataFromAPIImpl = APIController()

    fun getWeather(country: String): Single<WeatherFromAPI> =
            newsDataSource.getWeather(country, "metric", "da96f53f6c5b3fbff1dfb3f5334eda9d")
}