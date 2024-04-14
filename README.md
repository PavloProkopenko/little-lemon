Little Lemon
Little lemon is the Capstone project for Meta's Android Developer Course on Coursera made in Kotlin.
Screenshot

Built With
Kotlin: As the programming language.
ktor: For fetching data asynchronously from the server.
Jetpack Compose: To make the UI.
Room: To cache the network data locally.
Glide Compose: To load images asynchronously.
Jetpack Navigation: For navigation between screens.

Installation
Simply clone this repository and open LittleLemon folder (android project folder) in android studio. To clone:


Architecture
This app made using Android recommended MVVM Architecture. Packages and their roles:

data - It is the data layer which contains class realated to database.
local - local data base(Room)
network - REST Client
model - data classes
ui - It is UI layer which contains composable, view-models and navigation.
