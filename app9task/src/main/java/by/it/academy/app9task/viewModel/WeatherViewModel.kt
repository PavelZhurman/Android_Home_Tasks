package by.it.academy.app9task.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.it.academy.app9task.data.WeatherFromAPI
import by.it.academy.app9task.data.WeatherRepository
import by.it.academy.app9task.database.CityItem
import by.it.academy.app9task.database.CityItemRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherRepository = WeatherRepository()
    private lateinit var citiesRepository: CityItemRepository

    private val mutableWeatherLiveData = MutableLiveData<WeatherFromAPI>()
    val newsWeatherLaveData: LiveData<WeatherFromAPI> = mutableWeatherLiveData

    private var mutableCitiesLiveData = MutableLiveData<List<CityItem>>()
    var citiesLaveData: LiveData<List<CityItem>> = mutableCitiesLiveData

    private val errorMutableWeatherLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = errorMutableWeatherLiveData

    private val tooMachDegreesMutableWeatherLiveData = MutableLiveData<String>()
    val tooMachDegreesLiveData: LiveData<String> = tooMachDegreesMutableWeatherLiveData

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun fetchWeather(country: String) {
        weatherRepository.getWeather(country)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            if (WeatherUsesCase().filterTemp(weather)) {
                                mutableWeatherLiveData.value = weather
                            } else {
                                tooMachDegreesMutableWeatherLiveData.value = "This country is TOO HAT!!"
                            }
                        },
                        { error -> errorMutableWeatherLiveData.value = "Error: " + error.message }
                ).also {
                    compositeDisposable.add(it)
                }
    }

    fun addCityIntoDb(context: Context, city: String) {
        citiesRepository = CityItemRepository(context)
        citiesRepository.mainScope().launch {
            mutableCitiesLiveData.value = citiesRepository.addCityGetList(CityItem(city))
        }
    }

    fun loadCityList(context: Context) {
        citiesRepository = CityItemRepository(context)
        citiesRepository.mainScope().launch {
            mutableCitiesLiveData.value = citiesRepository.getCitiesList()
        }
    }

    fun deleteCityUpdateList(context: Context, city: CityItem) {
        citiesRepository = CityItemRepository(context)
        citiesRepository.mainScope().launch {
            mutableCitiesLiveData.value = citiesRepository.removeCityGetList(city)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
