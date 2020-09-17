package com.example.mislugares

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.

class VistaLugarActivity : AppCompatActivity() {
    val lugares by lazy { (application as Aplicacion).lugares }
    val usoLugar by lazy { CasosUsoLugar(this, lugares) }
    var pos = 0
    lateinit var lugar: Lugar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_lugar)
        pos = intent.extras?.getInt("pos", 0) ?: 0
        lugar = lugares.elemento(pos)
        actualizaVistas()
    }

    fun actualizaVistas(){
        nombre.text = lugar.nombre
        logo_tipo.imageResource = lugar.tipoLugar.recurso
        tipo.text = lugar.tipoLugar.texto
        direccion.text = lugar.direccion
        telefono.text = Integer.toString(lugar.telefono)
        url.text = lugar.url
        comentario.text = lugar.comentarios
        fecha.text = DateFormat.getDateInstance().format(Date(lugar.fecha))
        hora.text = DateFormat.getTimeInstance().format(Date(lugar.fecha))
        valoracion.rating = lugar.valoracion
        valoracion.setOnRatingBarChangeListener {
                ratingBar, valor, fromUser -> lugar.valoracion = valor
        }
    }
}