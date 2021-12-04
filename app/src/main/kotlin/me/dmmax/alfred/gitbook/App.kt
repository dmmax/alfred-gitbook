package me.dmmax.alfred.gitbook

import me.dmmax.alfred.gitbook.database.DatabaseInitialization
import me.dmmax.alfred.gitbook.links.finder.LinksFinder
import me.dmmax.alfred.gitbook.links.finder.linksFinderModule
import me.dmmax.alfred.gitbook.links.updater.linksUpdaterModule
import me.dmmax.alfred.gitbook.links.updater.LinksUpdater
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    initDb()
    val command = args[0]
    if (command == "update") {
        updateLinks()
    } else if (command == "find") {
        findLinks(args[1])
    }
}

private fun initDb() {
    val databaseInitialization = DatabaseInitialization()
    databaseInitialization.init()
}

private fun updateLinks() {
    val app = startKoin {
        modules(linksUpdaterModule)
    }
    app.koin.get<LinksUpdater>().updateLinks()
}

private fun findLinks(name: String) {
    val app = startKoin {
        modules(linksFinderModule)
    }
    val findNameAndUrlByName = app.koin.get<LinksFinder>().findNameAndUrlByName(name)
    println(findNameAndUrlByName)
}