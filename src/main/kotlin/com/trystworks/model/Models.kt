package com.trystworks.model

import java.util.*

data class UserDto(private val id: UUID, private val text: String) {
    fun toDomain(): User {
        return User(id, text)
    }
}

data class User(private val id: UUID, private val text: String) {
    fun toDto(): UserDto {
        return UserDto(id, text)
    }
}

