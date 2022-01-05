package me.dmmax.alfred.gitbook.links

enum class EnvVars(private val envName: String) {
    GIT_REPOSITORY("gb_repository"),
    GIT_BRANCH("gb_branch");

    fun getEnvValue(): String {
        val value = System.getenv()[envName]
        if (value == null || value.isBlank()) {
            throw RuntimeException("Env variable $envName is not defined")
        }
        return value
    }
}