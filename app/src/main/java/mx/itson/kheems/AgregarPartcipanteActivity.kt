package mx.itson.kheems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import mx.itson.kheems.entidades.Participantes

class AgregarPartcipanteActivity : AppCompatActivity()
, View.OnClickListener {
    lateinit var nombre : EditText
    var jugadas : Int = 0
    var puntos : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_partcipante)
        val btnAgregar = findViewById<Button>(R.id.guardar)
        btnAgregar.setOnClickListener(this)
        nombre = findViewById(R.id.nombre)
        jugadas = intent.getIntExtra("jugadas",0)
        puntos = intent.getIntExtra("puntos",0)
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.guardar){
            Participantes().guardar(applicationContext,nombre.text.toString(),puntos,jugadas)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}