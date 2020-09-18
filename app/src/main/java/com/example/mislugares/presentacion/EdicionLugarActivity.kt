package com.example.mislugares.presentacion

import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mislugares.R
import com.example.mislugares.datos.LugaresLista
import com.example.mislugares.modelo.Lugar
import com.example.mislugares.modelo.TipoLugar
import kotlinx.android.synthetic.main.edicion_lugar.*
import java.text.DateFormat
import java.util.*

class EdicionLugarActivity : AppCompatActivity(){
    val lugares = LugaresLista()
    var pos = 0
    lateinit var lugar: Lugar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edicion_lugar)

        val adaptador = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            lugar.tipoLugar.getNombres()
        )


        lugares.añadeEjemplos()
        pos = intent.extras?.getInt("pos", 0) ?: 0
        lugar = lugares.elemento(pos)

        actualizaVistas()
    }

    fun actualizaVistas(){
        nombre.setText(lugar.nombre)
//        tipo.text = lugar.tipoLugar.texto
        direccion.setText(lugar.direccion)
        telefono.setText (Integer.toString(lugar.telefono))
        url.setText(lugar.url)
        comentario.setText(lugar.comentarios)
/*        valoracion.rating = lugar.valoracion
        valoracion.setOnRatingBarChangeListener {
                ratingBar, valor, fromUser -> lugar.valoracion = valor*/
        }
    }
}