package me.dmmax.alfred.gitbook.workflow.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class WorkflowScriptFilterResult(
    val items: List<WorkflowScriptFilterItem>
) {
    fun sendFeedback() {
        println(Json.encodeToString(this))
    }
}
