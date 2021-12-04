package me.dmmax.alfred.gitbook.links.finder

import me.dmmax.alfred.gitbook.links.common.service.LinkService

class LinksFinder(
    private val linkService: LinkService) {

    fun findNameAndUrlByName(name: String) : String {
        val links = linkService.findLinks(name)
        for (link in links) {
            println(link)
        }
        return ""
    }
}