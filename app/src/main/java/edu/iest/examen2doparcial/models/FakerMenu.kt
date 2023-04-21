package edu.iest.examen2doparcial.models

import edu.iest.examen2doparcial.R

class FakerMenu {
    fun getMenu() : ArrayList<Menu>{
        var opciones: ArrayList<Menu>
        opciones = arrayListOf<Menu>()

        opciones.add(Menu(1, R.drawable.cat,"Gatos"))
        opciones.add(Menu(2, R.drawable.profile,"Perfil"))
        opciones.add(Menu(3, R.drawable.config,"Configurar"))
        opciones.add(Menu(2, R.drawable.close,"Cerrar"))

        return opciones
    }
}