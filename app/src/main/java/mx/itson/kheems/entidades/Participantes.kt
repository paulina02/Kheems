package mx.itson.kheems.entidades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.kheems.persistencia.BaseDatos

class Participantes {
    var id = 0
    var nombre : String? = null
    var puntos : Int=0
    var jugadas : Int=0

    constructor()

    constructor(nombre:String,puntos:Int,partidas:Int){
        this.nombre = nombre
        this.puntos = puntos
        this.jugadas = jugadas
    }

    fun guardar(context: Context, nombre:String, puntos: Int, jugadas: Int){
        try {

            val KheemsDB = BaseDatos(context,"Kheems", null,1)
            var baseDatos : SQLiteDatabase = KheemsDB.writableDatabase
            val valores = ContentValues()

            valores.put("nombre",nombre)
            valores.put("puntos",puntos)
            valores.put("jugadas",jugadas)

            baseDatos.insert("participantes",null,valores)

        }catch (ex: Exception){

        }
    }

    fun obtenerParticipantes(context: Context) : ArrayList<Participantes>{

        val participantes : MutableList<Participantes> = ArrayList()

        try {
            val KheemsDB = BaseDatos(context,"Kheems", null,1)
            var baseDatos : SQLiteDatabase = KheemsDB.readableDatabase
            val cursor = baseDatos.rawQuery("SELECT id,nombre,puntos, jugadas FROM participantes ORDER BY puntos ASC LIMIT 10",null)

            while (cursor.moveToNext()){
                val j = Participantes(cursor.getString(1),cursor.getInt(2),cursor.getInt(3))

                participantes.add(j)
            }

        }catch (ex : Exception){
            Log.e("Ocurrio un error al obtener jugadores", ex.toString())

        }
        return participantes as ArrayList<Participantes>
    }
}
