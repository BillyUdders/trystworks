package com.trystworks.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

data class PostDto(val id: UUID, val text: String)

data class Post(@Id @Field("id") val id: UUID, @Field("text") val text: String)
