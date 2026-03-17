package com.example.cozinhaexpress //Define em qual pacote (pasta lógica) essa classe está.

import android.content.Intent //Importa a classe Intent, que é usada para abrir outras telas (Activity).
import android.os.Bundle //Importa a classe Bundle, que é usada para passar informações entre telas (Activity) ou restaurar o estado da Activity.
import android.widget.Button //Importa a classe Button, que é usada para criar botões na interface do usuário.
import android.widget.EditText //Importa a classe EditText, que é usada para criar campos de texto editáveis na interface do usuário.
import android.widget.Toast //Importa a classe Toast, que é usada para mostrar mensagens rápidas na tela (pequenas notificações) para o usuário.
import androidx.activity.enableEdgeToEdge //Importa a função enableEdgeToEdge, que é usada para permitir que a interface do usuário ocupe toda a tela, incluindo as áreas de recorte (notch) e as barras de navegação.
import androidx.appcompat.app.AppCompatActivity //Importa a classe AppCompatActivity, que é a classe base para atividades que usam a biblioteca de suporte para compatibilidade com versões anteriores do Android.
import androidx.core.view.ViewCompat //Importa a classe ViewCompat, que é usada para fornecer compatibilidade com versões anteriores do Android para operações relacionadas a visualizações (views), como aplicar insets (margens) para evitar sobreposição de elementos da interface do usuário com as barras de sistema.
import androidx.core.view.WindowInsetsCompat //Importa a classe WindowInsetsCompat, que é usada para fornecer compatibilidade com versões anteriores do Android para operações relacionadas a insets (margens) da janela, como obter as áreas ocupadas pelas barras de sistema (status bar, navigation bar) e ajustar a interface do usuário de acordo.

//Criação da classe LoginActivity, que é uma tela de login para o aplicativo. Ela herda (:) de AppCompatActivity, o que significa que é uma atividade (tela) que pode usar os recursos da biblioteca de suporte para compatibilidade com versões anteriores do Android.
class LoginActivity : AppCompatActivity() {
    //O método onCreate é chamado quando a atividade é criada. Ele é usado para configurar a interface do usuário e definir o comportamento da tela.
    override fun onCreate(savedInstanceState: Bundle?) { //(savedInstanceState: Bundle?) significa que o método pode receber um objeto Bundle que contém informações sobre o estado anterior da atividade, caso ela tenha sido destruída e recriada (por exemplo, durante uma rotação de tela). O ponto de interrogação (?) indica que o Bundle pode ser nulo, ou seja, a atividade pode não ter um estado anterior para restaurar.
        super.onCreate(savedInstanceState) //Chama o método onCreate da classe pai (AppCompatActivity) para garantir que a configuração básica da atividade seja feita corretamente.
        enableEdgeToEdge() //Chama a função enableEdgeToEdge para permitir que a interface do usuário ocupe toda a tela, incluindo as áreas de recorte (notch) e as barras de navegação.
        setContentView(R.layout.activity_login) //Define qual arquivo XML será usado como interface.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> //Configura um listener para aplicar os insets (margens) da janela à visualização principal (com id "main"). Isso é necessário para garantir que a interface do usuário não seja sobreposta pelas barras de sistema (status bar, navigation bar).
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()) //Obtém as áreas ocupadas pelas barras de sistema usando o método getInsets e o tipo WindowInsetsCompat.Type.systemBars().
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom) //Define o padding (margem interna) da visualização principal (v) usando os valores obtidos para as barras de sistema. Isso garante que a interface do usuário seja ajustada corretamente para evitar sobreposição com as barras de sistema.
            insets //Retorna os insets (que descrevem o quanto você precisa preencher o conteúdo do app para evitar sobreposições com partes da interface do sistema ou recursos do dispositivo) para que possam ser aplicados corretamente.
        }

        val email = findViewById<EditText>(R.id.editEmail) //Encontra a visualização EditText com o id "editEmail" e a atribui à variável "email". Isso permite que o código acesse o campo de texto onde o usuário digita seu email.
        val senha = findViewById<EditText>(R.id.editSenha) //Encontra a visualização EditText com o id "editSenha" e a atribui à variável "senha". Isso permite que o código acesse o campo de texto onde o usuário digita sua senha.
        val botao = findViewById<Button>(R.id.btnLogin) //Encontra a visualização Button com o id "btnLogin" e a atribui à variável "botao". Isso permite que o código acesse o botão de login para configurar seu comportamento quando for clicado.

        //Configura um listener (define o que acontece quando o botão é clicado) para o botão de login, que será acionado quando o usuário clicar no botão.
        botao.setOnClickListener {

            val emailDigitado = email.text.toString() //email → campo EditTex, .text → texto dentro dele, .toString() → converte para String e atribui à variável "emailDigitado".
            val senhaDigitada = senha.text.toString() //senha → campo EditText, .text → texto dentro dele, .toString() → converte para String e atribui à variável "senhaDigitada".

            //Verifica se o email e a senha digitados correspondem aos valores pré-definidos
            if(emailDigitado == "admin@teste.com" && senhaDigitada == "teste123"){

                //Login correto → abrir tela principal
                val intent = Intent(this, MainActivity::class.java) //Cria um objeto Intent para abrir a MainActivity. O primeiro parâmetro (this) é o contexto atual (LoginActivity), e o segundo parâmetro (MainActivity::class.java) é a classe da atividade que queremos abrir.
                startActivity(intent) //Inicia a atividade especificada pelo Intent, ou seja, abre a MainActivity.

            //Caso o login esteja errado
            } else {

                //Mostra uma mensagem temporária na tela.
                Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show() //Cria um Toast (mensagem temporária) com o texto "Ops! Algo deu errado". O primeiro parâmetro (this) é o contexto atual (LoginActivity), o segundo parâmetro é a mensagem a ser exibida, e o terceiro parâmetro (Toast.LENGTH_SHORT) define a duração da exibição do Toast (curta duração). O método show() exibe o Toast na tela.
            }
        }
    }
}