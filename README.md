# Spring AI Workshop Demo

A Spring Boot application demonstrating Spring AI capabilities with Google Gemini.

## 🛠 Project Versions

- **Java**: 25
- **Spring Boot**: 3.5.8
- **Spring AI**: 1.1.0
- **Model**: gemini-2.0-flash-001

## 🚀 Prerequisites

- Java 25 installed
- Google Gemini API Key
- [HTTPie](https://httpie.io/) (optional, for testing)

## ⚙️ Setup

1.  **Set your API Key**:
    You can set the API key as an environment variable:
    ```bash
    export GEMINI_API_KEY=your_api_key_here
    ```

2.  **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## 🧪 Testing Endpoints

Here are the HTTPie commands to test the available endpoints:

### 1. Static Chat (Blocking)
Sends a prompt and waits for the full response.

```bash
http POST :8080/chat/chat-static message="Tell me a joke about the sun"
```

### 2. Streaming Chat (SSE)
Streams the response in real-time using Server-Sent Events.

```bash
http --stream POST :8080/chat/chat-stream message="Tell me a story about a brave knight"
```

### 3. Chat Response Object
Returns the full `ChatResponse` object containing metadata (usage, model info, etc.).

```bash
http POST :8080/chat/chat-response message="What is the capital of France?"
```

## 📝 Configuration

The model is configured in `src/main/resources/application.properties`:

```properties
spring.ai.google.genai.api-key=${GEMINI_API_KEY}
# Explicitly set the chat model
spring.ai.google.genai.chat.options.model=gemini-2.0-flash-001
```
