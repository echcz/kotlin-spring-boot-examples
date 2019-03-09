package com.github.echcz.swagger.service

import com.github.echcz.swagger.domain.USER_STORE
import com.github.echcz.swagger.domain.User
import org.springframework.stereotype.Service

@Service
class UserService {
    fun findOne(username: String): User? {
        return USER_STORE[username]
    }

    fun findAll(): List<User> {
        return USER_STORE.values.toList()
    }

    fun save(user: User) {
        USER_STORE[user.username] = user
    }

    fun delete(username: String) {
        USER_STORE.remove(username)
    }

    fun deleteAll() {
        USER_STORE.clear()
    }
}