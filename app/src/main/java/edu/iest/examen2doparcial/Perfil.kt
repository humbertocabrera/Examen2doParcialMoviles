package edu.iest.examen2doparcial

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Perfil : AppCompatActivity() {

    private lateinit var tvTitulo: TextView
    private lateinit var etNombre : EditText
    private lateinit var etGato : EditText
    private lateinit var etEdad : EditText
    private lateinit var fabGuardar : FloatingActionButton

    private val NOMBRE_KEY = "nombre"
    private val GATO_KEY = "gato"
    private val EDAD_KEY = "edad"
    //private val GUARDAR_KEY = "nombre"

    private var nombre: String = ""
    private var gato: String = ""
    private var edad: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var actionBar: ActionBar? = supportActionBar
        var colorDrawable: ColorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)

        inicializarVistas()
        getPreferences()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NOMBRE_KEY, nombre )
        outState?.run {
            putString(NOMBRE_KEY, nombre)
            putString(GATO_KEY, gato)
            putInt(EDAD_KEY, edad)
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")
        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            //Al tener activo el Switch de Preferences, cuando re-abramos la app deben salir
            //los datos previamente guardados.
            nombre = miSharedPreferences.getString(NOMBRE_KEY, "").toString()
            gato = miSharedPreferences.getString(GATO_KEY, "").toString()
            edad = miSharedPreferences.getInt(EDAD_KEY, 0)
        }
        //Seteamos la info en los campos
        tvTitulo.setText("Con Datos Previamente Guardados")
        etNombre.setText(nombre)
        etGato.setText(gato)
        etEdad.setText(edad.toString())
        super.onResume()
    }


    private fun cambiarTextoBienvenida(nombre: String) {
        if (!TextUtils.isEmpty(nombre)) {
            tvTitulo.text = "Bienvenido"
        }
    }

    private fun inicializarVistas(){
        tvTitulo = findViewById(R.id.tvTitulo)
        etNombre = findViewById(R.id.etNombre)
        etGato = findViewById(R.id.etGato)
        etEdad = findViewById(R.id.etEdad)
        fabGuardar = findViewById(R.id.floatActButton)

        fabGuardar.setOnClickListener{
            nombre = etNombre.text.toString()
            gato = etGato.text.toString()
            edad = Integer.valueOf(etEdad.text.toString())
            //cambiarTextoBienvenida(nombre)

            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = miSharedPreferences.edit()

            editor.putString(NOMBRE_KEY, nombre)
            editor.putString(GATO_KEY, gato)
            editor.putInt(EDAD_KEY, edad)
            editor.apply()
        }
    }
    private fun getPreferences(){
        //Linkeamos los elementos del View con las variables previamente inicializadas
        etNombre = findViewById(R.id.etNombre)
        etEdad  = findViewById(R.id.etEdad)
        etGato = findViewById(R.id.etGato)

        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre = miSharedPreferences.getString(NOMBRE_KEY,"").toString()
            edad = miSharedPreferences.getInt(EDAD_KEY,0)
            gato = miSharedPreferences.getString(GATO_KEY,"").toString()


            etNombre.setText(nombre)
            etEdad.setText(edad.toString())
            etGato.setText(gato)
        }
    }
}