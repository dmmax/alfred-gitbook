package me.dmmax.alfred.gitbook.links.updater

import me.dmmax.alfred.gitbook.links.data.Link

const val MD_EXTENSION = ".md"

class SummaryParser {

    private val pageRegex by lazy { "\\[(.+)]\\(([^ ]+?)(\"(.+)\")?\\)".toRegex() }

    fun parseTreeLinks(summaryContent: String): List<Link> {
        val parsedPages = mutableListOf<Link>()
        for (matchResult in pageRegex.findAll(summaryContent)) {
            val pageName = matchResult.groups[1]!!.value
            val pageUrl = matchResult.groups[2]!!.value
            val pageUrlWithoutMdExtension = pageUrl.removeSuffix(MD_EXTENSION)
            parsedPages.add(Link(pageName, pageUrlWithoutMdExtension))
        }
        return parsedPages
    }
}