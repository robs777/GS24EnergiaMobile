package com.example.energiamobile24

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaGeral : AppCompatActivity() {

    // Adicionar
    lateinit var imgIrTelaAdicionar: ImageView
    lateinit var txtIrTelaAdicionar: TextView

    // Editar
    lateinit var imgIrTelaEditar: ImageView
    lateinit var txtIrTelaEditar: TextView

    // Remover
    lateinit var imgIrTelaRemover: ImageView
    lateinit var txtIrTelaRemover: TextView

    // Visualizar
    lateinit var imgIrTelaVisualizar: ImageView
    lateinit var txtIrTelaVisualizar: TextView

    // Recomendacao
    lateinit var imgIrTelaRecomendacao: ImageView
    lateinit var txtIrTelaRecomendacao: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_geral)

        // ADICIONAR
        imgIrTelaAdicionar = findViewById(R.id.imgIrTelaAdicionar)
        imgIrTelaAdicionar.setOnClickListener {
            val navegarTelaAdicionar = Intent(this, TelaAdicionar::class.java)
            startActivity(navegarTelaAdicionar)
        }

        txtIrTelaAdicionar = findViewById(R.id.txtIrTelaAdicionar)
        txtIrTelaAdicionar.setOnClickListener {
            val navegarTelaAdicionar = Intent(this, TelaAdicionar::class.java)
            startActivity(navegarTelaAdicionar)


        }

        // EDITAR
        imgIrTelaEditar = findViewById(R.id.imgIrTelaEditar)
        imgIrTelaEditar.setOnClickListener {
            val navegarTelaEditar = Intent(this, TelaEditar::class.java)
            startActivity(navegarTelaEditar)
        }

        txtIrTelaEditar = findViewById(R.id.txtIrTelaEditar)
        txtIrTelaEditar.setOnClickListener {
            val navegarTelaEditar = Intent(this, TelaEditar::class.java)
            startActivity(navegarTelaEditar)


        }

        // REMOVER
        imgIrTelaRemover= findViewById(R.id.imgIrTelaRemover)
        imgIrTelaRemover.setOnClickListener {
            val navegarTelaRemover = Intent(this, TelaRemover::class.java)
            startActivity(navegarTelaRemover)
        }

        txtIrTelaRemover = findViewById(R.id.txtIrTelaRemover)
        txtIrTelaRemover.setOnClickListener {
            val navegarTelaRemover = Intent(this, TelaRemover::class.java)
            startActivity(navegarTelaRemover)


        }

        // VISUALIZAR
        imgIrTelaVisualizar = findViewById(R.id.imgIrTelaVisualizar)
        imgIrTelaVisualizar.setOnClickListener {
            val navegarTelaVisualizar = Intent(this, TelaVisualizar::class.java)
            startActivity(navegarTelaVisualizar)
        }

        txtIrTelaVisualizar = findViewById(R.id.txtIrTelaVisualizar)
        txtIrTelaVisualizar.setOnClickListener {
            val navegarTelaVisualizar = Intent(this, TelaVisualizar::class.java)
            startActivity(navegarTelaVisualizar)


        }

        // RECOMENDACAO
        imgIrTelaRecomendacao = findViewById(R.id.imgIrTelaRecomendacao)
        imgIrTelaRecomendacao.setOnClickListener {
            val navegarTelaRecomendacao = Intent(this, TelaRecomendacao::class.java)
            startActivity(navegarTelaRecomendacao)
        }

        txtIrTelaRecomendacao = findViewById(R.id.txtIrTelaRecomendacao)
        txtIrTelaRecomendacao.setOnClickListener {
            val navegarTelaRecomendacao = Intent(this, TelaRecomendacao::class.java)
            startActivity(navegarTelaRecomendacao)


        }




    }

}