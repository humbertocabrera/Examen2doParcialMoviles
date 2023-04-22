package edu.iest.examen2doparcial.adapters

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2doparcial.Perfil
import edu.iest.examen2doparcial.R
import edu.iest.examen2doparcial.models.Menu //Importar esto para ArrayList<Menu>
import kotlin.system.exitProcess

class MenuAdapter(opcionesMenu: ArrayList<Menu>, context: Context) :
    RecyclerView.Adapter<MenuAdapter.ContenedorDeVista>(){

    var innerOpcionesMenu: ArrayList<Menu> = opcionesMenu
    var innerContext: Context = context // Se usa con lo de Shared Preferences

    inner class ContenedorDeVista(view: View):
        RecyclerView.ViewHolder(view), View.OnClickListener {

            val imagen : ImageView
            val titulo : TextView

            init {
                imagen = view.findViewById(R.id.fotoGato)
                titulo = view.findViewById(R.id.tituloOpcion)

                imagen.setOnClickListener(this)
            }

        override fun onClick(p0: View?) {
            /*Si llegara a usar las preferencias guardadas para el clic
             uso la linea de abajo*/
            /*val miSharedPreferences = innerContext.getSharedPreferences("PERSISTENCIA",
                AppCompatActivity.MODE_PRIVATE)*/

            val menu: Menu = innerOpcionesMenu.get(adapterPosition)

            /*Si fuera menu y cada imagen llevara a una pantalla distinta aqui
            abajo irian los ifs como el ejemplo para ir a cada pantalla*/

            if (menu.id == 2){
                val i = Intent(innerContext, Perfil::class.java)
                innerContext.startActivity(i)
            }
            if (menu.id == 4){
                exitProcess(0)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_2, parent, false)

        return ContenedorDeVista(view)
    }

    override fun getItemCount(): Int {
        return innerOpcionesMenu.size
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val opciones: Menu = innerOpcionesMenu.get(position)
        holder.imagen.setImageResource(opciones.imagen)
        holder.titulo.text = opciones.titulo
    }

}