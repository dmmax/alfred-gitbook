package me.dmmax.alfred.gitbook.database

import org.jetbrains.exposed.sql.Database

const val DB_URL_PATH = "jdbc:sqlite:/Users/maximdimukhametov/workspace/automationhero/dmmax/alfred-gitbook/data.db"
const val JDBC_DRIVER = "org.sqlite.JDBC"

class DatabaseInitialization {

    fun init() {
        initConnection()
    }

    private fun initConnection() {
        Database.connect(DB_URL_PATH, JDBC_DRIVER)
    }
}