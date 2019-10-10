# CoolMovies

The application is created using Clean Architecture and Single Activity flow (Fragments). The application is written on Kotlin.

# Core Libraries

1) AndroidX [AppCompat, Material, Core, ConstrainLayout] - are used for native widgets and styles.
2) Glide - image loading.
3) Moxy - MVP libary (It is library include ViewState, which keeps commands to apply it after destroy and recreate view).
4) Toothpick - Dependency Injection library (With hierarchical scope logic).
5) Cicerone - Fragment-orientated navigation library (With command queue feature).
6) RxJava - Data-flow library to work with asyncronius tasks.
7) Retrofit + OkHttp - libary.
8) Room - local database to keep favorite movies.

# Pagination

Pagination is implemented with custom statefull decision. it contains several states, which are determined. It keeps the information about current data, page, empty state and etc.

# Other

The icon and logo were generated from image taken on website. The color scheme was selected material.io/colors. Debug keystore was generated for the application.
