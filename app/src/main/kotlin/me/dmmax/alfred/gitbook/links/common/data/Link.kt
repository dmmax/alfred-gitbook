package me.dmmax.alfred.gitbook.links.data

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.*

data class Link(
    val name: String,
    val url: String
)

class LinkEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<LinkEntity>(Links)

    var name by Links.name
    var url by Links.url

    override fun toString(): String = "Link($name, $url)"

    fun toLink(): Link {
        return Link(name, url)
    }
}

object Links : UUIDTable() {
    val name = varchar("name", 255).index()
    val url = varchar("url", 255).index()
}