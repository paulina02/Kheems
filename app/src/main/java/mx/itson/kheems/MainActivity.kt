package mx.itson.kheems

import android.content.Intent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var ubicacion = 0
    var contador = 0
    var puntos = 0
    var jugadas =1
    lateinit var btnSeleccion : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnReiniciar = findViewById<Button>(R.id.btn_reiniciar)
        btnReiniciar.setOnClickListener(this)
        val btnPartidas = findViewById<Button>(R.id.btn_list)
        btnPartidas.setOnClickListener(this)

        iniciar()
    }

    fun iniciar() {
        jugadas++
        ubicacion = Random().nextInt(11)+1
        contador = 0
        findViewById<View>(R.id.opcion1).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion2).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion3).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion4).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion5).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion6).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion7).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion8).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion9).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion10).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion11).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion12).setBackgroundResource(R.drawable.icon_pregunta)
        for (i in 1..12) {
            btnSeleccion = findViewById<ImageButton>(
                resources.getIdentifier(
                    "opcion$i",
                    "id",
                    this.packageName
                )
            )
            btnSeleccion.setOnClickListener(this)
            btnSeleccion.isEnabled = true
        }


    }
    fun destapar(opcion: Int) {
        if (opcion == ubicacion) {
            jugadas++
            Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show()
            for (i in 1..12) {
                btnSeleccion = findViewById<ImageButton>(
                    resources.getIdentifier(
                        "opcion$i", "id", this.packageName
                    )
                )
                if (i == opcion) {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora)

                } else {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
                }
            }
        } else {

            var btnSeleccion = findViewById<View>(
                resources.getIdentifier(
                    "opcion$opcion", "id", this.packageName
                )
            ) as ImageButton
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
            contador++
            puntos++
            if (contador == 11) {

                var btngGanador = findViewById<ImageButton>(
                    resources.getIdentifier(
                        "opcion$ubicacion", "id", this.packageName
                    )
                )
                btngGanador.setBackgroundResource(R.drawable.cheems_win)
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AgregarPartcipanteActivity::class.java)
                    intent.putExtra("partidas",jugadas)
                    intent.putExtra("puntos",puntos)

                startActivity(intent)

            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            (R.id.opcion1)->{
                destapar(1)
                val btn = findViewById<ImageButton>(R.id.opcion1)
                btn.isEnabled =false
            }
            (R.id.opcion2)->{
                destapar(2)
                val btn = findViewById<ImageButton>(R.id.opcion2)
                btn.isEnabled =false
            }
            (R.id.opcion3)->{
                destapar(3)
                val btn = findViewById<ImageButton>(R.id.opcion3)
                btn.isEnabled =false
            }
            (R.id.opcion4)->{
                destapar(4)
                val btn = findViewById<ImageButton>(R.id.opcion4)
                btn.isEnabled =false
            }
            (R.id.opcion5)->{
                destapar(5)
                val btn = findViewById<ImageButton>(R.id.opcion5)
                btn.isEnabled =false
            }
            (R.id.opcion6)->{
                destapar(6)
                val btn = findViewById<ImageButton>(R.id.opcion6)
                btn.isEnabled =false
            }
            (R.id.opcion7)->{
                destapar(7)
                val btn = findViewById<ImageButton>(R.id.opcion7)
                btn.isEnabled =false
            }
            (R.id.opcion8)->{
                destapar(8)
                val btn = findViewById<ImageButton>(R.id.opcion8)
                btn.isEnabled =false
            }
            (R.id.opcion9)->{
                destapar(9)
                val btn = findViewById<ImageButton>(R.id.opcion9)
                btn.isEnabled =false
            }
            (R.id.opcion10)->{
                destapar(10)
                val btn = findViewById<ImageButton>(R.id.opcion10)
                btn.isEnabled =false
            }
            (R.id.opcion11)->{
                destapar(11)
                val btn = findViewById<ImageButton>(R.id.opcion11)
                btn.isEnabled =false
            }
            (R.id.opcion12)->{
                destapar(12)
                val btn = findViewById<ImageButton>(R.id.opcion12)
                btn.isEnabled =false
            }
        }
            if(v?.id ==  R.id.btn_reiniciar){
                iniciar()
            }
                if(v?.id ==  R.id.btn_list){
                val intent = Intent(this,ListParticipanteActivity::class.java)
                startActivity(intent)
            }



    }


}