# CryptoApp 📈💸

![Coin List Screen](docs/img1.jfif)
![Coin Details Screen](docs/img2.jfif)

CryptoApp is a streamlined mobile application that provides real-time data and details on various cryptocurrencies. The app delivers an easy-to-navigate list of popular coins and allows users to click on a coin to view detailed information. Built with Jetpack Compose.

## Features

- View a list of popular cryptocurrencies with ranks, names, and symbols.
- Tap on a cryptocurrency to view detailed information such as tags and activity status.
- Loading and error handling for a smooth user experience.

## Tech Stack

- **Kotlin**
- **Jetpack Compose** - Declarative UI framework for modern Android development.
- **Dagger-Hilt** - Dependency injection to simplify the setup and management of dependencies.
- **Coroutines & Flow** - For asynchronous programming and data flow management.
- **Retrofit** - Networking library for API calls.
- **Compose Navigation** - Navigation component to manage app screens and navigation flows.

## Architecture

CryptoApp uses **MVVM (Model-View-ViewModel)** architecture combined with **Clean Architecture** principles for scalability and maintainability. The project is divided into three main layers:

1. **Presentation Layer**: Implements the UI using Jetpack Compose, handling user interactions and displaying the app's state.
2. **Domain Layer**: Contains use cases and the business logic to manage coin data retrieval and processing.
3. **Data Layer**: Responsible for managing data sources, including remote API calls via Retrofit and repository classes.

This architecture ensures that each layer is independent, making the codebase modular and easy to test.

---
