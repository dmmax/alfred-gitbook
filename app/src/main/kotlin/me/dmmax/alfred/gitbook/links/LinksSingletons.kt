package me.dmmax.alfred.gitbook.links

import me.dmmax.alfred.gitbook.links.common.service.LinkService
import me.dmmax.alfred.gitbook.links.finder.LinksFinder
import me.dmmax.alfred.gitbook.links.updater.LinksUpdater
import me.dmmax.alfred.gitbook.links.updater.SummaryParser
import me.dmmax.alfred.gitbook.links.updater.SummaryReader
import me.dmmax.alfred.gitbook.links.updater.reader.GitSummaryReader

object LinksSingletons {
    val gitSummaryReader: SummaryReader by lazy { GitSummaryReader() }
    val summaryParser: SummaryParser by lazy { SummaryParser() }
    val linkService: LinkService by lazy { LinkService() }
    val linksUpdater: LinksUpdater by lazy { LinksUpdater(gitSummaryReader, summaryParser, linkService) }
    val linksFinder: LinksFinder by lazy { LinksFinder(linkService) }
}