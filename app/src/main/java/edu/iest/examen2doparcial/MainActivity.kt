package edu.iest.examen2doparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2doparcial.adapters.MenuAdapter
import edu.iest.examen2doparcial.models.FakerMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = FakerMenu().getMenu()
        val recycler = findViewById<RecyclerView>(R.id.recyclerMenu)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        recycler.layoutManager = linearLayoutManager
        recycler.adapter = MenuAdapter(menu, this)

        val gridLayoutManager = GridLayoutManager(this, 2)
        recycler.layoutManager = gridLayoutManager
    }

    //Funcion que al crear el menu de Opciones indica que se use el icono que se establecio
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)
        return super.onCreateOptionsMenu(menu)
    }
}