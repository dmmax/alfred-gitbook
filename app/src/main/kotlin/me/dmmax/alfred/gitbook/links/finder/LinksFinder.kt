package me.dmmax.alfred.gitbook.links.finder

import me.dmmax.alfred.gitbook.links.common.service.LinkService
import me.dmmax.alfred.gitbook.workflow.data.WorkflowScriptFilterItem
import me.dmmax.alfred.gitbook.workflow.data.WorkflowScriptFilterResult
import java.util.*

class LinksFinder(
    private val linkService: LinkService
) {

    fun findNameAndUrlByName(arg: String): WorkflowScriptFilterResult {
        val uuid = UUID.randomUUID().toString()
        val scriptFilterItems = linkService.findLinks(arg)
            .map {
                WorkflowScriptFilterItem(
                    uuid,
                    it.name,
                    it.url,
                    it.url,
                    it.name,
                    true,
                    "default"
                )
            }
        return WorkflowScriptFilterResult(scriptFilterItems)
    }
}