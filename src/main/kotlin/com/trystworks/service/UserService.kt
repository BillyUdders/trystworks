package com.trystworks.service

import com.trystworks.model.User
import com.trystworks.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class UserService(private val userRepo: UserRepository) {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(UserService::class.java)
    }

    fun getAll(): Flux<User> {
        return userRepo.findAll().also { logger.info("Returning all posts.") }
    }

    fun get(uuid: UUID): Mono<User> {
        return userRepo.findById(uuid).also { logger.info("Found post.") }
    }

    fun create(post: User): Mono<User> {
        return userRepo.save(post).also { logger.info("Saving.") }
    }

}
