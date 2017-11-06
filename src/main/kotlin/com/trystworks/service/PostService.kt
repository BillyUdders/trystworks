package com.trystworks.service

import com.trystworks.model.Post
import com.trystworks.repository.PostRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class PostService(private val postRepo: PostRepository) {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(PostRepository::class.java)
    }

    fun getAll(): Flux<Post> {
        return postRepo.findAll().also { logger.info("Returning all posts.") }
    }

    fun get(uuid: UUID): Mono<Post> {
        return postRepo.findById(uuid).also { logger.info("Found post.") }
    }

    fun create(post: Post): Mono<Post> {
        return postRepo.save(post).also { logger.info("Saving.") }
    }

}
