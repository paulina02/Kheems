package mx.itson.kheems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import mx.itson.kheems.Adaptador.Adapter
import mx.itson.kheems.entidades.Participantes

class ListParticipanteActivity : AppCompatActivity() {
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_participante)
        listView = findViewById(R.id.lista)
        cargarLista()

    }
    fun cargarLista(){
        val lista = Participantes().obtenerParticipantes(this)
        val adaptador = Adapter(lista)

        listView.adapter = adaptador
    }
}