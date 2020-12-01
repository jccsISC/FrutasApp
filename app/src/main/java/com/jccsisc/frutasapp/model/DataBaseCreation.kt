package com.jccsisc.frutasapp.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataBaseCreation(context: Context?)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val fruit_table = "CREATE TABLE ${DataBaseColumns.TABLE_NAME} (${DataBaseColumns.NAME_FRUIT} TEXT," +
            "${DataBaseColumns.COLOR_FRUIT} TEXT, ${DataBaseColumns.PESO_FRUIT} TEXT," +
            " ${DataBaseColumns.PRECION_FRUI} TEXT, ${DataBaseColumns.IMAGE_FRUIT} TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    companion object {
        const val DB_NAME = "fruits.fb"
        const val DB_VERSION = 1
    }

}