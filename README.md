# MemoryCardsGame
A simple Memory card game

Choose the mode, play and Flip the cards to find the match! 

![Application](https://raw.githubusercontent.com/ingjuanocampo/MemoryCardsGame/master/gif_test.gif)




## Clean Architecture with MVVM 

The choosen archicture is Clean Architecture which help us to keep the amount of boilerplate code to a minimum and also demonstrates how clean the code and testeable will be. This sample follows SOLID principles, keeping the code as a cleaner as possible. 

Patterns: 
- Repository Pattern 
- Dependecy Injection Pattern 
- Delegate Pattern 
- MVVM Preseentation Pattern 

## Modules

To fulfill the clean architecture, and keep all the layers un-couple there is a module per layer. Please review the description of every module.

#### App 
App module integrates all modules, it is the main Android Project and it only contains all files related to Activities, Fragments, and Adapters. It also is in charge to resolve the dependencies of the project by creating the Main Dagger component.

#### Domain 
The Domain is a Kotlin Module and it is designed to hold all the CORE-features of the app. This is only a logic module and should always be a Kotlin Module. This module has no dependency on other modules, it is 100% uncoupled. Also, Domain creates contracts (Repository contracts) that should be implemented in the Data layer to full fill the requirement of the features. 
Dependency: Nothing 

#### Data 
Data is an Android Module that implements the contracts specified in the domain layer (Repositories). With the contract, Data should coordinate all the data sources and uncouple the domain from the data layer. This module creates contracts for RemoteDataSource and LocalDataSources. 
Dependency: Domain 

## Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* [AndroidX](https://developer.android.com/jetpack/androidx)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Dagger 2](https://github.com/google/dagger)
* [JetPack](https://developer.android.com/topic/libraries/architecture)
* [Gson](https://github.com/google/gson)
