# Little Lemon
Little lemon is the Capstone project for Meta's Android Developer Course on Coursera made in Kotlin.
# Screenshot
![picture alt](https://github.com/PavloProkopenko/little-lemon/blob/main/Screenshots/Onboarding%20screen.png "Onboarding Screen")
![picture alt](https://github.com/PavloProkopenko/little-lemon/blob/main/Screenshots/Home%20screen.png "Home Screen")
![picture alt](https://github.com/PavloProkopenko/little-lemon/blob/main/Screenshots/Profile%20screen.png "Home Screen")
# Built With
* [Kotlin](https://kotlinlang.org/): As the programming language.
* [ktor](https://ktor.io/): For fetching data asynchronously from the server.
* [Jetpack Compose](https://developer.android.com/develop/ui/compose/documentation): To make the UI.
* [Room](https://developer.android.com/training/data-storage/room): To cache the network data locally.
* [Glide Compose](https://bumptech.github.io/glide/int/compose.html): To load images asynchronously.
* [Jetpack Navigation](https://developer.android.com/develop/ui/compose/navigation): For navigation between screens.

# Installation
Simply clone this repository and open LittleLemon folder (android project folder) in android studio. To clone:
```
https://github.com/PavloProkopenko/little-lemon.git
```

# Architecture
This app made using Android recommended MVVM Architecture. Packages and their roles:

* data - It is the data layer which contains class realated to database.
  * local - local data base(Room)
  * network - REST Client
  * model - data classes
* ui - It is UI layer which contains composable, view-models and navigation.
