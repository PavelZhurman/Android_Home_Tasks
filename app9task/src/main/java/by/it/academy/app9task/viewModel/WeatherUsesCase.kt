package by.it.academy.app9task.viewModel

import by.it.academy.app9task.data.WeatherFromAPI

class WeatherUsesCase {
    fun filterTemp(weatherData: WeatherFromAPI): Boolean = weatherData.list[0].main.temp < 50.0
}