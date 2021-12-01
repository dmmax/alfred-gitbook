package me.dmmax.alfred.gitbook.common.database

import me.dmmax.alfred.gitbook.links.data.Links
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

const val DB_URL_PATH = "jdbc:sqlite:/Users/maximdimukhametov/workspace/automationhero/dmmax/alfred-gitbook/data.db"
const val JDBC_DRIVER = "org.sqlite.JDBC"

class DatabaseInitialization {

    fun init() {
        initConnection()
        installTables()
    }

    private fun initConnection() {
        Database.connect(DB_URL_PATH, JDBC_DRIVER)
    }

    private fun installTables() {
        transaction {
            // print sql to std-out
            addLogger(StdOutSqlLogger)

            SchemaUtils.drop(Links)
            SchemaUtils.create(Links)
        }
    }
}