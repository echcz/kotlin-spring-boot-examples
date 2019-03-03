package com.github.echcz.start.controller

import com.github.echcz.start.domain.My
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("my")
class MyController @Autowired constructor(var my: My) {
    @GetMapping("name")
    fun getName(): String {
        return my.name
    }

    @GetMapping("msg")
    fun getMsg(): String {
        return my.msg
    }
}