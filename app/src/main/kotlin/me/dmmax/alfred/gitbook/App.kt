package me.dmmax.alfred.gitbook

import me.dmmax.alfred.gitbook.common.database.DatabaseInitialization
import me.dmmax.alfred.gitbook.links.linkModule
import me.dmmax.alfred.gitbook.links.service.LinkUpdateService
import org.koin.core.context.startKoin

fun main() {
    initDb()
    val app = startKoin {
        modules(linkModule)
    }
    app.koin.get<LinkUpdateService>().updateLinks()
}

fun initDb() {
    val databaseInitialization = DatabaseInitialization()
    databaseInitialization.init()
}