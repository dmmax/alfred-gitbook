package me.dmmax.alfred.gitbook.links

enum class EnvVars(private val envName: String) {
    GIT_BOOK_REPOSITORY("git_book_repository"),
    GIT_BOOK_BRANCH("git_book_branch"),
    ALFRED_WORKFLOW_DATA("alfred_workflow_data");

    fun getEnvValue(): String {
        val value = System.getenv()[envName]
        if (value == null || value.isBlank()) {
            throw RuntimeException("Env variable $envName is not defined")
        }
        return value
    }
}