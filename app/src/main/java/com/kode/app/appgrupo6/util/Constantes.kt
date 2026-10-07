package com.kode.app.appgrupo6.util

import com.kode.app.appgrupo6.model.Usuario

class Constantes {

    companion object {
        val LISTA_USUARIOS: List<Usuario> = listOf(
            Usuario("Jean", "123456789"),//lleva solo a la pregunta 1
            Usuario("Allison", "123456789"),//lleva solo a la pregunta 2
            Usuario("lia", "123456789"),//este debe mostra la pregunta 4
        )
    }
}
