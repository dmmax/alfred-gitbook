package me.dmmax.alfred.gitbook.links

import me.dmmax.alfred.gitbook.links.parser.SummaryParser
import me.dmmax.alfred.gitbook.links.reader.git.GitSummaryReader
import me.dmmax.alfred.gitbook.links.service.LinkService
import me.dmmax.alfred.gitbook.links.service.LinkUpdateService
import org.koin.dsl.module

val linkModule = module {
    single { LinkUpdateService(get(), get(), get()) }
    single { LinkService() }
    single { GitSummaryReader() }
    single { SummaryParser() }
}