package me.dmmax.alfred.gitbook.links.finder

import me.dmmax.alfred.gitbook.links.common.service.LinkService
import org.koin.dsl.module

val linksFinderModule = module {
    single { LinksFinder(get()) }
    single { LinkService() }
}