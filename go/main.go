package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/ping", pong)
	log.Fatal(http.ListenAndServe(":9999", nil))
}

var counter = 0

func pong(w http.ResponseWriter, _ *http.Request) {
	counter++
	log.Printf("Go got called %d times!", counter)

	_, err := fmt.Fprint(w, "Hi Kotlin!")
	checkError(err)

	_, err = http.Get("http://localhost:8888/ping")
	checkError(err)
}

func checkError(err error) {
	if err != nil {
		log.Printf("Error: %v\n", err)
	}
}
