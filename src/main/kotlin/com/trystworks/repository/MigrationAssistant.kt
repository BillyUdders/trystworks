package com.trystworks.repository

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.stereotype.Component
import java.io.File
import java.nio.charset.Charset

@Component
class MigrationAssistant(private val db: CassandraTemplate,
                         @Value("migration.path") private val location: String) : InitializingBean {

    override fun afterPropertiesSet() {
        migrate(location)
    }

    fun migrate(resourceLocation: String): String {
        return File(resourceLocation).walk()
                .map { it.name to db.cqlOperations.execute(it.readText(Charset.defaultCharset())) }
                .joinToString(separator = "\n, ", postfix = "migrations applied to Cassandra.")
    }
}
