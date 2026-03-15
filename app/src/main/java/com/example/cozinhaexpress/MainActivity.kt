// Define o pacote do projeto — identifica onde essa classe está
package com.example.cozinhaexpress

// Importações: são as bibliotecas que precisamos para o código funcionar
import android.content.Intent  // Usado para navegar entre telas
import android.os.Bundle       // Necessário para o onCreate funcionar
import androidx.appcompat.app.AppCompatActivity // Classe base de toda Activity
import android.widget.Button   // Permite acessar o botão do XML

/*
    MainActivity: é a Tela 2 do app (Receitas).
    AppCompatActivity é a classe base que toda tela (Activity) precisa herdar.
    O ":" significa "herda de" em Kotlin.
*/
class MainActivity : AppCompatActivity() {

    /*
        onCreate: função chamada automaticamente quando a tela é criada.
        É aqui que configuramos tudo que a tela precisa ao abrir.
        savedInstanceState guarda o estado anterior da tela (se houve).
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama o onCreate da classe pai

        /*
            setContentView: conecta esta Activity ao arquivo XML da tela.
            R.layout.activity_main referencia o arquivo activity_main.xml
            que criamos na pasta res/layout.
        */
        setContentView(R.layout.activity_main)

        /*
            findViewById: busca um elemento do XML pelo seu id.
            Aqui estamos buscando o botão com id="btnVerEquipe"
            que definimos no activity_main.xml.
            O "as Button" confirma que esse elemento é um Button.
        */
        val btnVerEquipe = findViewById<Button>(R.id.btnVerEquipe)

        /*
            setOnClickListener: define o que acontece quando o botão é clicado.
            Tudo dentro das chaves { } é executado ao clicar.
        */
        btnVerEquipe.setOnClickListener {

            /*
                Intent: é o mecanismo do Android para navegar entre telas.
                this = tela atual (MainActivity)
                IntegrantesActivity::class.java = tela de destino (Tela 3)
            */
            val intent = Intent(this, IntegrantesActivity::class.java)

            /*
                startActivity: executa a navegação de fato,
                abrindo a IntegrantesActivity por cima da atual.
            */
            startActivity(intent)
        }
    }
}