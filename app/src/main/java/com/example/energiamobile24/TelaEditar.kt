package com.example.energiamobile24

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.energiamobile24.databinding.ActivityTelaEditarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaEditar : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaEditarBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    private val bancoDados by lazy {
        FirebaseFirestore.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.imgEditar.setOnClickListener {
            editarUsuario()
        }


    }

    private fun editarUsuario() {

        val idNomeAparelho = binding.editNomeAparelho.text.toString()

        if (idNomeAparelho != null) {
            bancoDados
                .collection("Aparelho")
                .document(idNomeAparelho)
                .update("tempoDeUso", binding.editTempoUso.text.toString())
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO ATUALIZAR")
                        .setMessage("Atualizado com sucesso.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERROR AO ATUALIZAR")
                        .setMessage("Não atualizado.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }

        }

    }
}