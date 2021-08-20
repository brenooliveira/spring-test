package coderszoom.springtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiTestApplication

fun main(args: Array<String>) {
	runApplication<ApiTestApplication>(*args)
}
