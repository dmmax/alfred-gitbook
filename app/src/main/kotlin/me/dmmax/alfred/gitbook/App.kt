package me.dmmax.alfred.gitbook

import me.dmmax.alfred.gitbook.database.DatabaseInitialization
import me.dmmax.alfred.gitbook.links.LinksSingletons

fun main(args: Array<String>) {
    initDb()
    when (val command = args[0]) {
        "update" -> {
            updateLinks()
        }
        "find" -> {
            findLinks(args[1])
        }
        else -> {
            throw UnsupportedOperationException("Command '$command' doesn't support for alfred-gitbook app")
        }
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