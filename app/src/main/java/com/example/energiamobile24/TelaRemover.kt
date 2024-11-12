package com.example.energiamobile24

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.energiamobile24.databinding.ActivityTelaAdicionarBinding
import com.example.energiamobile24.databinding.ActivityTelaRemoverBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaRemover : AppCompatActivity() {

    private val binding by lazy {
       ActivityTelaRemoverBinding.inflate(layoutInflater)
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

        binding.imgRemover.setOnClickListener {
            removerUsuario()
        }




    }

    private fun removerUsuario() {
        val idNomeAparelho = binding.editNomeAparelho.text.toString()

        if (idNomeAparelho != null) {
            bancoDados
                .collection("Aparelho")
                .document(idNomeAparelho)
                .delete()
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO DELETAR")
                        .setMessage("Dados deletados com sucesso.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("DADOS NÃO DELETADO")
                        .setMessage("Dados não deletados.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
        }
    }
}