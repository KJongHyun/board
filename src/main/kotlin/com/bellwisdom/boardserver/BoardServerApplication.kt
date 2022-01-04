package com.bellwisdom.boardserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class BoardServerApplication

fun main(args: Array<String>) {
    runApplication<BoardServerApplication>(*args)
}
