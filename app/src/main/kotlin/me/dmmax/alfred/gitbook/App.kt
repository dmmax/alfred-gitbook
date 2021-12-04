package me.dmmax.alfred.gitbook

import me.dmmax.alfred.gitbook.database.DatabaseInitialization
import me.dmmax.alfred.gitbook.links.updater.linksUpdaterModule
import me.dmmax.alfred.gitbook.links.updater.LinksUpdater
import org.koin.core.context.startKoin

fun main() {
    initDb()
    val app = startKoin {
        modules(linksUpdaterModule)
    }
    app.koin.get<LinksUpdater>().updateLinks()
}

fun initDb() {
    val databaseInitialization = DatabaseInitialization()
    databaseInitialization.init()
}