package com.trystworks.repository

import com.trystworks.model.User
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : ReactiveCassandraRepository<User, UUID>{



}
