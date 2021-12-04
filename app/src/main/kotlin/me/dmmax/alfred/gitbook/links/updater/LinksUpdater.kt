package me.dmmax.alfred.gitbook.links.updater

import me.dmmax.alfred.gitbook.links.common.service.LinkService

class LinksUpdater(
    private val summaryReader: SummaryReader,
    private val summaryParser: SummaryParser,
    private val linkService: LinkService
) {

    fun updateLinks() {
        linkService.installLinksTable()
        val summaryContent = summaryReader.readContent()
        val treeLinks = summaryParser.parseTreeLinks(summaryContent)
        for (link in treeLinks) {
            linkService.addLink(link)
        }
    }
}