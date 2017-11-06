package com.trystworks.controller

import com.trystworks.model.Post
import com.trystworks.model.PostDto
import com.trystworks.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping(path = arrayOf("/post"))
class PostController(private val postService: PostService) {

    @GetMapping(path = arrayOf("/{id}"))
    fun get(@PathVariable("id") uuid: UUID): Mono<PostDto> {
        return postService.get(uuid).map { PostDto(it.id, it.text) }
    }

    @GetMapping
    fun getAll(): Flux<PostDto> {
        return postService.getAll().map { PostDto(it.id, it.text) }
    }

    @PostMapping
    fun create(@RequestBody dto: PostDto): Mono<Post> {
        return postService.create(dto.let { Post(it.id, it.text) })
    }
}