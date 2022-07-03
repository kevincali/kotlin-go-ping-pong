build-kotlin:
	@echo === Building the Kotlin part into a .jar ===
	./kotlin/gradlew shadowJar -p kotlin
	mv ./kotlin/build/libs/kotlin-0.0.1-all.jar kotlin-ping-pong.jar

run-kotlin: build-kotlin
	@echo === Running Kotlin ===
	java -jar kotlin-ping-pong.jar

build-go: go/go.mod
	@echo === Building the Go part into a binary ===
	go build -o go-ping-pong ./go/main.go

run-go: build-go
	@echo === Running Go ===
	./go-ping-pong

clean: go-ping-pong kotlin-ping-pong.jar
	rm go-ping-pong kotlin-ping-pong.jar
