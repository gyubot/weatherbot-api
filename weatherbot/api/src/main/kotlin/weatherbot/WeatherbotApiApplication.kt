package weatherbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherbotApiApplication

fun main(args: Array<String>) {
    runApplication<WeatherbotApiApplication>(*args)
}
