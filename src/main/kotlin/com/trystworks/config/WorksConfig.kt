package com.trystworks.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
class WorksConfig : AbstractReactiveCassandraConfiguration() {

    @Value("\${cassandra.contactpoints}")
    private val contactPoints: String? = null
    @Value("\${cassandra.port}")
    private val port: Int = 0
    @Value("\${cassandra.keyspace}")
    private val keyspace: String? = null
    @Value("\${cassandra.basepackages}")
    private val basePackages: String? = null

    override fun getKeyspaceName(): String {
        return checkNotNull(keyspace, { "Need keyspace to connect." })
    }

    override fun getContactPoints(): String {
        return checkNotNull(contactPoints, { "Can't start without contact points." })
    }

    override fun getPort(): Int {
        check(port != 0, { "Can't start on null port." })

        return port
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }

    override fun getEntityBasePackages(): Array<String> {
        return arrayOf(checkNotNull(basePackages))
    }
}
