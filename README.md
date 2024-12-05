
# Translation Service API

This project provides an API for transliterating Marathi text to English using the **IBM ICU library** and **Spring Boot**. The service exposes an endpoint to convert Marathi text written in Devanagari script to English and removes diacritics from the output.

## Features

- Transliterates Marathi text (Devanagari script) to English.
- Removes diacritics from the transliterated text for cleaner output.

## Project Structure

- **com.Translation_poc.app.service.TranslationService**: Logic for transliterating Marathi text and removing diacritics.
- **com.Translation_poc.app.Controller.TranslationController**: REST API controller to handle requests and responses.

## Prerequisites

Make sure you have the following installed:

- **Java 11 or higher**
- **Maven**
- **Spring Boot**
- **IBM ICU Library (icu4j)**

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-repo/translation-poc.git
cd translation-poc
```

### 2. Build the project

Use Maven to build the project:

```bash
mvn clean install
```

### 3. Run the application

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will start on **http://localhost:8080** by default.

## API Endpoints

### Transliterate Marathi Text to English

- **URL**: `/api/translation/transliterate`
- **Method**: `POST`
- **Request Body**: 
  - A JSON string containing Marathi text in Devanagari script.

    Example Request:
    ```json
    "पिपळगाव तर्फं घोडा"
    ```

- **Response**: 
  - The response will be a **transliterated string** in English with diacritics removed.

    Example Response:
    ```json
    "Pipalgav tarph Ghoda"
    ```

#### Example `curl` Command

```bash
curl -X POST "http://localhost:8080/api/translation/transliterate"   -H "Content-Type: application/json"   -d ""पिपळगाव तर्फं घोडा""
```

## Logging

The application uses **SLF4J** and **Logback** for logging. You will see logs for:

- Transliteration start.
- Transliteration result.
- Diacritic removal process.

### Example Output in Console

```plaintext
INFO  TranslationService - Transliteration started for Marathi text: पिपळगाव तर्फं घोडा
INFO  TranslationService - Transliteration result: Pipalgav tarph Ghoda
INFO  TranslationService - Removing diacritics from input: Pipalgav tarph Ghoda
INFO  TranslationService - Result after removing diacritics: Pipalgav tarph Ghoda
INFO  TranslationService - Final transliterated output: Pipalgav tarph Ghoda
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
