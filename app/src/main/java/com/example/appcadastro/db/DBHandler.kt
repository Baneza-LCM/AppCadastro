package com.example.appcadastro.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appcadastro.model.CourseModel

class DBHandler
    (context: Context?) :
        SQLiteOpenHelper(context, DB_NAME, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_C + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_C + " TEXT, "
                + ENDERECO_C + " TEXT, "
                + BAIRRO_C + " TEXT, "
                + CEP_C + " TEXT, "
                + CIDADE_C + " TEXT, "
                + ESTADO_C + " TEXT, "
                + TELEFONE_C + " TEXT, "
                + CELULAR_C + " TEXT)")

        db.execSQL(query)
    }

    fun addNewData(
        Tnome: String?,
        Tende: String?,
        Tbairro: String?,
        Tcep: String?,
        Tcidad: String?,
        Testad: String?,
        Ttel: String?,
        Tcell: String?
    ) {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put(NOME_C, Tnome)
        values.put(ENDERECO_C, Tende)
        values.put(BAIRRO_C, Tbairro)
        values.put(CEP_C, Tcep)
        values.put(CIDADE_C, Tcidad)
        values.put(ESTADO_C, Testad)
        values.put(TELEFONE_C, Ttel)
        values.put(CELULAR_C, Tcell)

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "pessoadb"

        private const val DB_VERSION = 1

        private const val TABLE_NAME = "pessoa"

        private const val ID_C = "id"

        private const val NOME_C = "nome"

        private const val ENDERECO_C = "endereço"

        private const val BAIRRO_C = "bairro"

        private const val CEP_C = "cep"

        private const val CIDADE_C = "cidade"

        private const val ESTADO_C = "estado"

        private const val TELEFONE_C = "telefone"

        private const val CELULAR_C = "celular"
    }

    fun readDatas(): ArrayList<CourseModel>? {
        val db = this.readableDatabase

        val cursorPessoa: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        val pessoaModelArrayList: ArrayList<CourseModel> = ArrayList()

        if(cursorPessoa.moveToFirst()) {
            do {
                pessoaModelArrayList.add(
                    CourseModel(
                        cursorPessoa.getString(1),
                        cursorPessoa.getString(2),
                        cursorPessoa.getString(3),
                        cursorPessoa.getString(4),
                        cursorPessoa.getString(5),
                        cursorPessoa.getString(6),
                        cursorPessoa.getString(7),
                        cursorPessoa.getString(8)
                    )
                )
            }
                while (cursorPessoa.moveToNext())
        }
        cursorPessoa.close()
        return pessoaModelArrayList
    }
        }