package com.github.echcz.swagger

import com.github.echcz.swagger.controller.UserController
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
@SpringBootTest
class TestApplicationTests {
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var userController: UserController

    @Before
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(userController).build()
    }
    @Test
    fun testUserController() {
        var request: RequestBuilder
        // 测试 POST /user
        request = post("/user")
                .content("""{"username": "jack", "password": "123456", "age": 12}""")
                .contentType(MediaType.APPLICATION_JSON)
        mvc.perform(request)
                .andExpect(status().isOk)
        request = post("/user")
                .content("""{"username": "tom", "password": "abc123", "age": 23}""")
                .contentType(MediaType.APPLICATION_JSON)
        mvc.perform(request)
                .andExpect(status().isOk)
        // 测试 GET /user
        request = get("/user")
        mvc.perform(request)
                .andExpect(status().isOk)
                .andDo { println(it.response.contentAsString) }

    }

}
