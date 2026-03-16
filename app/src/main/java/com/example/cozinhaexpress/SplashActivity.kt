package com.example.cozinhaexpress //Define o pacote do projeto, que é a estrutura de pastas onde esta classe está localizada.

import android.content.Intent //Importa a classe Intent, que é usada para navegar entre telas (Activities).
import android.os.Bundle //Importa a classe Bundle, que é um objeto usado para passar dados entre telas e salvar o estado da Activity.
import android.os.Handler //Importa a classe Handler, que permite agendar ações para serem executadas no futuro, como um atraso para a transição de tela.
import android.os.Looper //Importa a classe Looper, que controla a fila de execução da thread principal do Android (isso é importante porque a interface gráfica só pode ser manipulada na thread principal).
import androidx.activity.enableEdgeToEdge //Importa a função enableEdgeToEdge, que permite que a interface do usuário se estenda até as bordas da tela, proporcionando uma experiência mais imersiva.
import androidx.appcompat.app.AppCompatActivity //Importa a classe AppCompatActivity, que é a classe base para todas as Activities no Android e fornece compatibilidade com versões mais antigas do Android e permite usar componentes modernos da UI.
import androidx.core.view.ViewCompat //Importa a classe ViewCompat, que fornece métodos de compatibilidade para manipular as visualizações (Views) de forma consistente em diferentes versões do Android.
import androidx.core.view.WindowInsetsCompat //Importa a classe WindowInsetsCompat, usada para lidar com as áreas de recorte da tela (como entalhes e barras de navegação) de forma compatível em diferentes versões do Android.

//Criação da classe SplashActivity que herda de AppCompatActivity, ou seja, é uma tela do aplicativo. Esta tela será a primeira a ser exibida quando o app for aberto, mostrando um splash screen por alguns segundos antes de navegar para a tela de login.
class SplashActivity : AppCompatActivity() {
    //Sobrescreve o método onCreate (é um método do ciclo de vida da Activity), que é chamado quando a Activity é criada. É aqui que configuramos a interface e a lógica de inicialização da tela (Activity abre, onCreate executa e o layout é carregado).
    override fun onCreate(savedInstanceState: Bundle?) { //O parâmetro savedInstanceState é um Bundle que pode conter o estado anterior da Activity, caso ela tenha sido recriada (por exemplo, após uma rotação de tela). Se for a primeira vez que a Activity é criada, esse parâmetro será nulo.
        super.onCreate(savedInstanceState) //Chama o método onCreate da classe pai (AppCompatActivity) para garantir que a inicialização básica da Activity seja feita corretamente (savedInstanceState é passado para o método da classe pai para que ela possa restaurar o estado anterior, se necessário).
        enableEdgeToEdge() //Habilita o modo de exibição em borda a borda, permitindo que a interface do usuário se estenda até as bordas da tela, proporcionando uma experiência mais imersiva (isso é especialmente útil em dispositivos com telas grandes ou com entalhes).
        setContentView(R.layout.activity_splash) //Define o layout XML que esta Activity irá usar. R.layout.activity_splash é uma referência ao arquivo activity_splash.xml que deve estar na pasta res/layout. Este arquivo XML define a aparência da tela de splash, como imagens, textos e outros elementos visuais.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> //Configura um listener (é uma função que "ouve" por eventos, como cliques ou mudanças de estado) para aplicar as margens corretas em torno dos elementos da interface, levando em consideração as áreas de recorte da tela (como entalhes e barras de navegação). findViewById(R.id.main) busca a View principal do layout (que deve ter o id "main") para aplicar as margens.
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()) //Obtém as margens necessárias para evitar que os elementos da interface sejam cobertos pelas barras do sistema (como a barra de status e a barra de navegação). Isso garante que o conteúdo da tela seja exibido corretamente, mesmo em dispositivos com entalhes ou barras de navegação.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom) //Define o preenchimento (padding) da View principal usando as margens obtidas. Isso ajusta a posição dos elementos da interface para que eles não sejam cobertos pelas barras do sistema, garantindo uma melhor experiência visual.
            insets //Retorna os insets (objetos que contêm informações sobre as áreas de recorte da tela) para que o sistema possa continuar a processá-los normalmente. Isso é necessário para que outras partes do sistema possam aplicar as margens corretamente, se necessário.
        }

        //Cria um Handler que executa uma ação após um atraso de tempo. O Handler é associado ao Looper da thread principal, o que significa que a ação será executada na thread principal (importante para manipular a interface do usuário).
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java) //Cria um Intent para navegar da SplashActivity para a LoginActivity. O Intent é um objeto que descreve a ação a ser realizada (navegar para outra tela) e os dados necessários para essa ação (a classe da tela de destino). This é a Activity atual (SplashActivity). LoginActivity::class.java é a classe da tela de destino (LoginActivity) que queremos abrir.
            startActivity(intent) //Inicia a LoginActivity usando o Intent criado. Isso faz com que a tela de login seja exibida por cima da tela de splash.
            finish() //Chama finish() para encerrar a SplashActivity, removendo-a da pilha de atividades. Isso garante que o usuário não possa voltar para a tela de splash usando o botão de voltar, e que a SplashActivity seja destruída para liberar recursos.
        }, 3000) //3000 ms = 3 segundos
    }
}