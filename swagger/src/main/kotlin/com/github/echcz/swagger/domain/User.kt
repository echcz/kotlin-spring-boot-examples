package com.github.echcz.swagger.domain

val USER_STORE: MutableMap<String, User> = HashMap()

data class User(var username: String, var password: String, var age: Int)