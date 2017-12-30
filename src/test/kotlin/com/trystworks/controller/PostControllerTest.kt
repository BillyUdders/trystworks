package com.trystworks.controller

import com.trystworks.model.Post
import com.trystworks.model.PostDto
import com.trystworks.model.Reply
import com.trystworks.model.ReplyDto
import com.trystworks.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.util.*

internal class PostControllerTest {

    private val id = UUID.randomUUID()
    private val rep1 = UUID.randomUUID()
    private val rep2 = UUID.randomUUID()
    private val rep3 = UUID.randomUUID()

    @Mock
    private lateinit var service: UserService

    private lateinit var postController: PostController

    @BeforeEach
    internal fun setUp() {
        MockitoAnnotations.initMocks(this)

        postController = PostController(service)

        `when`(service.getAll()).thenReturn(
                Flux.just(
                        Post(id, "blah", Flux.just(Reply(rep1, "foo"))),
                        Post(id, "blah", Flux.just(Reply(rep2, "foo"))),
                        Post(id, "blah", Flux.just(Reply(rep3, "foo")))
                )
        )
    }

    @Test
    internal fun shouldReturnAllPostOnRequest() {
        StepVerifier.create(postController.getAll())
                .expectNext(PostDto(id, "blah", Flux.just(ReplyDto(rep1, "foo"))))
                .expectNext(PostDto(id, "blah", Flux.just(ReplyDto(rep2, "foo"))))
                .expectNext(PostDto(id, "blah", Flux.just(ReplyDto(rep3, "foo"))))
                .verifyComplete()
    }
}