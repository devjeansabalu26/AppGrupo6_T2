package com.kode.app.appgrupo6.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kode.app.appgrupo6.R
import com.kode.app.appgrupo6.databinding.ActivityLoginBinding
import com.kode.app.appgrupo6.util.Constantes

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        login(
            binding.etusuario.text.toString(),
            binding.etpassword.text.toString()
        )
    }

    private fun login(usuario: String, password: String) {
        if (usuario.isBlank() || password.isBlank()) {
            Toast.makeText(applicationContext,
                getString(R.string.msgcamposvacios),
                Toast.LENGTH_LONG).show()
            return
        }
        if (validarCredenciales(usuario, password)) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("usuario", usuario)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(applicationContext,
                getString(R.string.msgloginerror),
                Toast.LENGTH_LONG).show()
        }
    }

    private fun validarCredenciales(usuario: String, password: String): Boolean {
        return Constantes.LISTA_USUARIOS.any {
            it.usuario == usuario && it.password == password
        }
    }
}
