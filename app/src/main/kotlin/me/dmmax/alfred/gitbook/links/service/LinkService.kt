package me.dmmax.alfred.gitbook.links.service

import me.dmmax.alfred.gitbook.links.data.Link
import me.dmmax.alfred.gitbook.links.data.LinkEntity
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class LinkService {

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