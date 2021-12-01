package me.dmmax.alfred.gitbook.links.service

import me.dmmax.alfred.gitbook.links.parser.SummaryParser
import me.dmmax.alfred.gitbook.links.reader.SummaryReader

class LinkUpdateService(val summaryReader: SummaryReader, val summaryParser: SummaryParser, val linkService: LinkService) {

    fun updateLinks() {
        val summaryContent = summaryReader.readContent()
        val treeLinks = summaryParser.parseTreeLinks(summaryContent)
        for (link in treeLinks) {
            linkService.addLink(link)
        }
    }
}