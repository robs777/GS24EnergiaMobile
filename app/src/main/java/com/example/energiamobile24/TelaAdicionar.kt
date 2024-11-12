package com.example.energiamobile24

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.energiamobile24.databinding.ActivityTelaAdicionarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaAdicionar : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaAdicionarBinding.inflate(layoutInflater)
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


        binding.imgAdicionar.setOnClickListener {
            salvarInfo()
        }




    }



    private fun salvarInfo() {
        val idNomeAparelho = binding.editNomeAparelho.text.toString()

        val dados = mapOf(
            "nomeAparelho" to idNomeAparelho,
            "tempoDeUso" to binding.editTempoUso.text.toString()
        )



        if (idNomeAparelho != null) {
            bancoDados
                .collection("Aparelho")
                .document(idNomeAparelho)
                .set(dados)
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO CADASTRAR")
                        .setMessage("Aparelho salvo com sucesso.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERROR AO CADASTRAR APARELHO")
                        .setMessage("Aparelho não salvo.")
                        .setPositiveButton("Fechar") { dialog, posicao -> }
                        .create().show()
                }
        }

    }
}