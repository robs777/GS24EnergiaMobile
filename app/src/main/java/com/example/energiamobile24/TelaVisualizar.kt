package com.example.energiamobile24

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.energiamobile24.databinding.ActivityTelaRemoverBinding
import com.example.energiamobile24.databinding.ActivityTelaVisualizarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaVisualizar : AppCompatActivity() {

    private val binding by lazy {
        ActivityTelaVisualizarBinding.inflate(layoutInflater)
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

        binding.btnListar.setOnClickListener {
            listarDados()
        }

    }


    private fun listarDados() {

            bancoDados
                .collection("Aparelho")
                .addSnapshotListener { querySnapshot, erro ->
                    val listaDocs = querySnapshot?.documents

                    var listaResultado = ""

                    listaDocs?.forEach { documentSnaphot ->
                        val dados = documentSnaphot.data

                        if (dados != null) {
                            val nomeAparelho= dados["nomeAparelho"]
                            val tempoDeUso= dados["tempoDeUso"]
                            listaResultado += "Aparelho: $nomeAparelho - Tempo de Uso: $tempoDeUso \n"
                        }
                    }

                    binding.txtResultado.text = listaResultado
                }
        }

}