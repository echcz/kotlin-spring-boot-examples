package com.github.echcz.configuration.controller

import com.github.echcz.configuration.domain.My
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("my")
class MyController @Autowired constructor(val my: My) {
    @GetMapping("name")
    fun getName(): String {
        return my.name
    }

    @GetMapping("msg")
    fun getMsg(): String {
        return my.msg
    }
}