package com.github.echcz.swagger.controller

import com.github.echcz.swagger.domain.User
import com.github.echcz.swagger.service.UserService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController @Autowired constructor(val userService: UserService) {
    @ApiOperation("获取所有用户")
    @GetMapping
    fun getAll(): List<User> {
        return userService.findAll()
    }

    @ApiOperation(value = "获取某个用户", notes = "根据url的{username}来获取某个用户")
    @ApiImplicitParams(
            ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    )
    @GetMapping("{username}")
    fun getOne(@PathVariable("username") username: String): User? {
        return userService.findOne(username)
    }

    @ApiOperation(value = "添加/修改用户", notes = "根据{user}的username添加/修改用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping
    fun post(@RequestBody user: User) {
        userService.save(user)
    }

    @ApiOperation(value = "删除某个用户", notes = "根据url的{username}来删除某个用户")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @DeleteMapping("{username}")
    fun delete(@PathVariable("username") username: String) {
        userService.delete(username)
    }
}