package edu.iest.examen2doparcial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2doparcial.R
import edu.iest.examen2doparcial.models.Menu //Importar esto para ArrayList<Menu>

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

                //Aquí irian los OnClickListeners
            }

        override fun onClick(p0: View?) {
        //Aqui irian los onClickListeners
        //Aquí podria ir lo de las preferencias
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