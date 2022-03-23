# MovieHero

This is a showcase project in which I have tried to use both the domain-driven architecture and the Jetpack compose. It basically has 3 screens.
+ The location screen will allow user to search a location using text, GPS point,... then give the user a direction to it.
+ The home screen will show 2 movie lists: now playing and top-rated.
+ The movie detail screen will show some movie detail when the user clicks on it the home screen.

I also use the component-driven for this project. All UI components will be in 2 packages `components` and `modules`.
+ All the stateless components will go into `components`.
+ Each module will have a module stateful component, a module content component that should be stateless, a state data class for the content component, and a ViewModel.

Supported Android version: 21+
Supported devices: Phone & tablet

## How to build:
+ Register a Google API key with enable 3 APIs: Google Map APIs, Places APIs, and DirectionAPI.
+ Register an API key from themoviedb.org
+ Store both of these API keys into `local.properties` like below.
```
....
GOOGLE_API_KEY=AIzaSyDYfto13GBPZ4SD51Fks0EZwWXQctgLvHI
THE_MOVIE_DB_API_KEY=21881da497e187aed3f7e56e5d492b4c
```
+ You will need to use kotlin version `1.6.10` to build this project.

## Improvement
+ Implement database cache for movie list.
+ Refactor the LocationRepositoryImpl. It's kinda a mess.
+ Implement Unit testing.
+ Maybe snapshot testing for all preview composable.

