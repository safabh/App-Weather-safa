# Weather Application
Android weather application implemented using the MVVM pattern, Dagger Hilt, Retrofit , LiveData, ViewModel, Coroutines, Room. WeatherApp fetches data from the [OpenWeatherMap API](https://openweathermap.org/api) to provide real time weather information. 


# Features

- [x] Landing City list
- [x] Landing search city weather
- [x] View weather details
- [x] Add cities

## Architecture
The architecture of this application relies and complies with the following points below:
* Pattern [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)(MVVM) which facilitates a separation of development of the graphical user interface.
* [Android architecture components](https://developer.android.com/topic/libraries/architecture/) which help to keep the application robust, testable, and maintainable.

## Technologies used:

* [Retrofit](https://square.github.io/retrofit/) a REST Client for Android which makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice.
* [Hilt](https://www.geeksforgeeks.org/dagger-hilt-in-android-with-example/) for dependency injection.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to store and manage UI-related data in a lifecycle conscious way.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) to handle data in a lifecycle-aware fashion.
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)Coroutines help in managing background threads and reduces the need for callbacks.
* [Room](https://developer.android.com/topic/libraries/architecture/room) persistence library which provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
* [Glide](https://www.axopen.com/blog/2020/08/glide-kotlin-librairie-chargement-images-android/) is an Image Loader Library for Android developed.

