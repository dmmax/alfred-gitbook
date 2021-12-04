package me.dmmax.alfred.gitbook.links.common.service

import me.dmmax.alfred.gitbook.links.data.Link
import me.dmmax.alfred.gitbook.links.data.LinkEntity
import me.dmmax.alfred.gitbook.links.data.Links
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class LinkService {

    fun installLinksTable() {
        transaction {
            // print sql to std-out
            addLogger(StdOutSqlLogger)

            SchemaUtils.drop(Links)
            SchemaUtils.create(Links)
        }
    }

    fun addLink(link: Link) {
        transaction {
            // print sql to std-out
            addLogger(StdOutSqlLogger)
            LinkEntity.new {
                name = link.name
                url = link.url
            }
        }
    }
}