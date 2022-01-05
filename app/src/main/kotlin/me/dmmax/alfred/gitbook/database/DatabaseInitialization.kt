package me.dmmax.alfred.gitbook.database

import me.dmmax.alfred.gitbook.links.EnvVars
import org.jetbrains.exposed.sql.Database
import java.nio.file.Files
import java.nio.file.Paths

const val DB_RELATIVE_PATH = "db/data.db"
const val JDBC_DRIVER = "org.sqlite.JDBC"

class DatabaseInitialization {

    private val dbUrlPath = Paths.get(EnvVars.ALFRED_WORKFLOW_DATA.getEnvValue()).resolve(DB_RELATIVE_PATH)

    fun init() {
        initConnection()
    }

    private fun initConnection() {
        val dbFolder = dbUrlPath.parent
        if (Files.notExists(dbFolder)) {
            println("Creating folder: $dbFolder")
            dbFolder.toFile().mkdirs()
        }
        Database.connect("jdbc:sqlite:$dbUrlPath", JDBC_DRIVER)
    }
}