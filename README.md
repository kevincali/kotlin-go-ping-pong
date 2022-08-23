# Kotlin & Go Ping Pong

This small project implements two endpoints that call each other endlessly.

The endpoint `localhost:8888/ping` is implemented in Kotlin using the [Ktor](https://ktor.io/) Framework.

`localhost:9999/ping` is the endpoint implemented in Go which uses the standard lib.

## Usage
> :warning: **Your CPU might not be too happy about this ツ**

Requirements: `make`, `java`, `golang`

1. Clone/download the repository
2. Open a terminal and run `make run-kotlin`
3. Open another terminal and run `make run-go`
4. To start the endless ping pong, you need to call one of the endpoints:
    1. go to to an endpoint using your browser
    2. OR open another terminal and run `curl localhost:8888/ping`
