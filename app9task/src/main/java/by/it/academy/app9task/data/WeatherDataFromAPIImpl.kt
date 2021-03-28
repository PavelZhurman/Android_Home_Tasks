package by.it.academy.app9task.data

import io.reactivex.Single

interface WeatherDataFromAPIImpl {
    fun getWeather(country: String, units: String, appKey: String): Single<WeatherFromAPI>
}