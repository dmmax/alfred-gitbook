package me.dmmax.alfred.gitbook.links

import me.dmmax.alfred.gitbook.links.common.service.LinkService
import me.dmmax.alfred.gitbook.links.finder.LinksFinder
import me.dmmax.alfred.gitbook.links.updater.LinksUpdater
import me.dmmax.alfred.gitbook.links.updater.SummaryParser
import me.dmmax.alfred.gitbook.links.updater.reader.GitSummaryReader

object LinksSingletons {
    val linksUpdater: LinksUpdater by lazy { LinksUpdater(GitSummaryReader(), SummaryParser(), LinkService()) }
    val linksFinder: LinksFinder by lazy { LinksFinder(LinkService()) }
}