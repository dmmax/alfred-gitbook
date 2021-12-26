package me.dmmax.alfred.gitbook

import me.dmmax.alfred.gitbook.database.DatabaseInitialization
import me.dmmax.alfred.gitbook.links.LinksSingletons

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
    LinksSingletons.linksUpdater.updateLinks()
}

private fun findLinks(name: String) {
    val workflowResult = LinksSingletons.linksFinder.findNameAndUrlByName(name)
    workflowResult.sendFeedback()
}