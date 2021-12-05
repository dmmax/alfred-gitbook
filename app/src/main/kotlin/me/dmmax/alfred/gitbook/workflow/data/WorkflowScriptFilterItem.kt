package me.dmmax.alfred.gitbook.workflow.data

import kotlinx.serialization.Serializable

@Serializable
data class WorkflowScriptFilterItem(
    private val uid: String,
    private val title: String,
    private val subtitle: String,
    private val arg: String,
    private val autocomplete: String,
    private val valid: Boolean,
    private val type: String
)
