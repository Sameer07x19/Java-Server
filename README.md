# Web Server Implementation (Single-threaded & Multi-threaded)

This repository contains implementations of both **single-threaded** and **multi-threaded** web servers in Java. Each implementation has separate folders containing `Server.java` and `Client.java` files. The servers are tested using Apache JMeter for performance evaluation.

## Features
- **Single-threaded server**: Handles one client at a time.
- **Multi-threaded server**: Uses a thread pool to handle multiple clients concurrently.
- **Timeout handling**: Configurable timeout for client connections.
- **Performance Testing**: JMeter scripts for benchmarking.

## Folder Structure
```
/
├── single-threaded/
│   ├── Server.java
│   ├── Client.java
├── multi-threaded/
│   ├── Server.java
│   ├── Client.java
├── Thread Group.jmx
```

## Installation & Usage
### Prerequisites
- Java (JDK 8+)
- Apache JMeter (for testing)
- making your own jmeter test plan is recommended

### Running the Single-threaded Server
```sh
cd single-threaded
javac Server.java Client.java
java Server
```

### Running the Multi-threaded Server
```sh
cd multi-threaded
javac Server.java Client.java
java Server
```

### Running the Client
```sh
java Client
```

## Performance Testing with JMeter
1. Open **Apache JMeter**.
2. Load the JMeter test plan (`Thread Group.jmx`).
3. Configure the number of threads (users) and loop count.
4. Start the test and analyze the results.

## Results & Observations
- The **single-threaded server** efficiently handles requests but can become slow under high loads.
- The **multi-threaded server** can handle multiple requests simultaneously, improving response time under heavy load.

## Future Enhancements
- Implement **asynchronous (NIO-based) server**.
- Add support for **HTTPS**.
- Extend logging and monitoring.

## License
This project is licensed under the MIT License.

