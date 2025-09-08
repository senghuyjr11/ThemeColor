# ThemeColor

Android application for dynamically switching theme colors, using SharedPreferences to store and retrieve color codes.

## Overview

**ThemeColor** lets users personalize their Android app experience by choosing different theme colors. The selected color is saved using Android's SharedPreferences, so it persists between sessions.

## Features

- Select and switch between multiple theme colors
- Color preference saved locally for persistent app appearance
- Simple, intuitive UI
- Built primarily with Java, with some Kotlin components

## Technologies Used

- Java (95.4%)
- Kotlin (4.6%)
- Android SDK
- SharedPreferences

## Getting Started

### Prerequisites

- Android Studio
- Android device or emulator (API level 21+ recommended)
- Java 8+

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/senghuyjr11/ThemeColor.git
   ```
2. **Open in Android Studio:**
   - File > Open > Select the cloned `ThemeColor` directory

3. **Build and Run:**
   - Use the “Run” button or `Shift + F10` to install on your device/emulator

### Usage

1. Launch the app.
2. Access the theme color switcher from the main screen.
3. Select your desired color.
4. The app’s theme updates instantly, and your selection is saved for next time!

## Project Structure

- `MainActivity.java` / `MainActivity.kt` — Main screen and color logic
- `SharedPreferences` — Handles saving and loading color codes
- `res/values/colors.xml` — Color definitions
- `res/layout/` — UI layouts

## Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository
2. Create your branch (`git checkout -b feature/my-feature`)
3. Commit changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

---

**Author:** [senghuyjr11](https://github.com/senghuyjr11)

> _Feel free to update this README with screenshots, more features, or advanced setup instructions!_
