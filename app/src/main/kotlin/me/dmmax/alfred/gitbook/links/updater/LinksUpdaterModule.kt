package me.dmmax.alfred.gitbook.links.updater

import me.dmmax.alfred.gitbook.links.common.service.LinkService
import me.dmmax.alfred.gitbook.links.updater.reader.GitSummaryReader
import org.koin.dsl.module

val linksUpdaterModule = module {
    single { LinksUpdater(get(), get(), get()) }
    single { LinkService() }
    single { GitSummaryReader() }
    single { SummaryParser() }
}