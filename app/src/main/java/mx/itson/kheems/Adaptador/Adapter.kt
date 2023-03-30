package mx.itson.kheems.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.kheems.R
import mx.itson.kheems.entidades.Participantes

class Adapter(val lista : ArrayList<Participantes>): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(i: Int): Any {
        return lista[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_participante, parent, false)
        }
        val nombreTextView = view?.findViewById<TextView>(R.id.txt_nombre)
        nombreTextView?.text = lista[position].nombre

        val puntosTextView = view?.findViewById<TextView>(R.id.txt_puntos)
        puntosTextView?.text = lista[position].puntos.toString()

        val jugadasTextView = view?.findViewById<TextView>(R.id.txt_jugadas)
        jugadasTextView?.text = lista[position].jugadas.toString()

        return view!!
    }
}