package com.trystworks.repository

import com.trystworks.model.Post
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostRepository : ReactiveCrudRepository<Post, UUID>