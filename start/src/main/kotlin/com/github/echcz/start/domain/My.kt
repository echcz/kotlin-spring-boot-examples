package com.github.echcz.start.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class My(@Value("\${my.name}") var name: String, @Value("\${my.msg}") var msg: String)