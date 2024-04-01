package JogoVelha;
import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Computador computador;

    public JogoDaVelha(){
        tabuleiro = new Tabuleiro();
    }

    public void iniciarJogo() {
        Random rand = new Random();
        tabuleiro.inicializarTabuleiro();
        Scanner ler = new Scanner(System.in);

        System.out.print("Escolha a letra para o Jogador 1 (X ou O): ");
        char letraJogador1 = ler.nextLine().charAt(0);
        char letraJogador2 = (letraJogador1 == 'X') ? 'O' : 'X';

        jogador1 = new Jogador("Jogador 1",letraJogador1);
        jogador2 = new Jogador("Jogador 2",letraJogador2);
        computador = new Computador(letraJogador2);

        char[] jogadores = { jogador1.getSimbolo(), jogador2.getSimbolo() };

        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("-----------------");
        System.out.println("1. Jogador vs. Jogador");
        System.out.println("2. Jogador vs. Computador");
        System.out.println("-----------------");
        System.out.print("Escolha o modo de jogo: ");
        int escolha = ler.nextInt();
    
        if (escolha == 1) {
            System.out.println("Você escolheu Jogador vs. Jogador.");
            System.out.println("-----------------");
            jogador1.setNome("Jogador 1");
            jogador2.setNome("Jogador 2");
        } else if (escolha == 2) {
            System.out.println("Você escolheu Jogador vs. Computador.");
            System.out.println("-----------------");
            jogador1.setNome("Jogador");
            jogador2 = computador;
        } else {
            System.out.println("Escolha inválida. Saindo do jogo.");
            return;
       }
       int vez = rand.nextInt(2);

        while (true) {
            tabuleiro.mostrarTabuleiro();
            if(jogadores[vez]==jogador1.getSimbolo()){
                jogador1.fazerJogada(tabuleiro);
                tabuleiro.mostrarTabuleiro();
                
                if (tabuleiro.verificarVitoria(jogador1.getSimbolo())) {
                    System.out.println(jogador1.getNome() + " venceu!");
                    break;
                } else if (tabuleiro.estaCheio()) {
                    System.out.println("IH, deu velha!");
                    break;
                }
            }else{
                jogador2.fazerJogada(tabuleiro);
                tabuleiro.mostrarTabuleiro();

                if (tabuleiro.verificarVitoria(jogador2.getSimbolo())) {
                    if (jogador2 instanceof Computador) {
                        System.out.println("O Computador venceu!");
                    } else {
                        System.out.println(jogador2.getNome() + " venceu!");
                    }
                    break;
                } else if (tabuleiro.estaCheio()) {
                    System.out.println("IH, deu velha!");
                    break;
                }
            }
            vez = 1 - vez;
        }
        System.out.print("Deseja reiniciar o jogo? (S)im/(N)ão: ");
        String resposta = ler.next();
        if (resposta.equalsIgnoreCase("S")) {
            main(null);
        } else {
            System.out.println("Fechando jogo...");
            ler.close();
        }
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.iniciarJogo();
    }
}