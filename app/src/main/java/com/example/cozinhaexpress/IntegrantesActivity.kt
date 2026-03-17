package com.example.cozinhaexpress //Define o pacote do aplicativo, onde a classe IntegrantesActivity está localizada.

import android.content.Intent //Importa a classe Intent, que é usada para iniciar novas atividades ou serviços dentro do aplicativo.
import android.os.Bundle //Importa a classe Bundle, que é usada para passar dados entre atividades ou salvar o estado da atividade.
import android.widget.Button //Importa a classe Button, que é usada para criar e manipular botões na interface do usuário.
import androidx.activity.enableEdgeToEdge //Importa a função enableEdgeToEdge, que é usada para permitir que a interface do usuário se estenda até as bordas da tela.
import androidx.appcompat.app.AppCompatActivity //Importa a classe AppCompatActivity, que é a classe base para atividades que usam a biblioteca de suporte do Android para compatibilidade com versões anteriores.
import androidx.core.view.ViewCompat //Importa a classe ViewCompat, que é usada para fornecer compatibilidade com versões anteriores para operações relacionadas a visualizações, como manipulação de janelas e insets.
import androidx.core.view.WindowInsetsCompat //Importa a classe WindowInsetsCompat, que é usada para fornecer compatibilidade com versões anteriores para operações relacionadas a insets de janela, como obter as áreas de sistema (barras de status, barras de navegação, etc.) e ajustar o layout da interface do usuário de acordo.

//Criação da classe IntegrantesActivity, que é uma atividade (tela) do aplicativo. Esta classe herda (:) de AppCompatActivity, o que significa que ela pode usar recursos de compatibilidade com versões anteriores do Android.
class IntegrantesActivity : AppCompatActivity() {

    //Cria o método onCreate, que é chamado quando a atividade é criada.
    override fun onCreate(savedInstanceState: Bundle?) { //override -> sobrescreve o método da classe pai. fun -> define uma função. onCreate -> método chamado quando a Activity é criada. savedInstanceState → guarda dados caso a tela seja recriada (ex: rotação do celular). Bundle? → Bundle é uma classe usada para passar dados entre diferentes componentes e ? significa que o valor pode ser nulo.
        super.onCreate(savedInstanceState) //super → chama o método da classe pai (AppCompatActivity). onCreate() → executa a inicialização padrão da Activity. (SavedInstanceState) → passa o estado salvo para a classe pai, permitindo que ela restaure o estado da atividade se necessário.
        enableEdgeToEdge() //Habilita o modo de borda a borda, permitindo que a interface do usuário se estenda até as bordas da tela.
        setContentView(R.layout.activity_integrantes) //Define o layout da atividade usando um arquivo XML de layout (activity_integrantes.xml) localizado na pasta res/layout do projeto.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> //Configura um listener (interfaces utilizadas para detectar e responder a interações do usuário) para aplicar os insets (representam a quantidade de espaço que os elementos do sistema ocupam na tela) da janela (áreas de sistema) à visualização principal da atividade (com o ID "main"). Isso garante que a interface do usuário seja ajustada corretamente para evitar sobreposição com as barras de status, barras de navegação, etc.
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()) //Obtém os insets para as barras de sistema (barras de status, barras de navegação, etc.) usando o método getInsets() da classe WindowInsetsCompat. O tipo de insets solicitado é especificado como WindowInsetsCompat.Type.systemBars(), que indica que queremos obter os insets relacionados às áreas de sistema.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom) //Define o preenchimento (padding) da visualização (v) usando os valores dos insets obtidos para as barras de sistema. Isso garante que a interface do usuário seja ajustada corretamente para evitar sobreposição com as áreas de sistema.
            insets //Retorna os insets para que possam ser processados por outros listeners ou pela própria visualização, se necessário.
        }

        val botaoPrincipal = findViewById<Button>(R.id.botaoPrincipal) //Encontra a visualização do botão com o ID "botaoPrincipal" no layout da atividade e a atribui à variável botaoPrincipal. O tipo de visualização é especificado como Button, indicando que estamos procurando um botão na hierarquia de visualizações. R → classe que guarda todos os recursos do projeto.
        val botaoLogout = findViewById<Button>(R.id.botaoLogout) //Encontra a visualização do botão com o ID "botaoLogout" no layout da atividade e a atribui à variável botaoLogout. O tipo de visualização é especificado como Button, indicando que estamos procurando um botão na hierarquia de visualizações. R → classe que guarda todos os recursos do projeto.

        //Configura um listener (evento de clique) para o "botaoPrincipal".
        botaoPrincipal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) //Cria um objeto Intent, que é usado para iniciar uma nova atividade/tela. O construtor do Intent recebe dois parâmetros: o contexto atual (this) e a classe da atividade que queremos iniciar (MainActivity::class.java). Isso indica que queremos iniciar a MainActivity quando o botão for clicado.
            startActivity(intent) //Inicia a atividade especificada pelo Intent criado anteriormente. Isso fará com que a MainActivity seja exibida na tela quando o botão for clicado.
        }

        botaoLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}