package com.trystworks.controller

import com.trystworks.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/post"])
class UserController(private val userService: UserService) {


}