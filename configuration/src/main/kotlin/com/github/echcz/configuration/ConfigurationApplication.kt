package com.github.echcz.configuration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConfigurationApplication

fun main(args: Array<String>) {
    runApplication<ConfigurationApplication>(*args)
}
