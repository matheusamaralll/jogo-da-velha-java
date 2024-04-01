package JogoVelha;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private char simbolo;

    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void fazerJogada(Tabuleiro tabuleiro) {
        Scanner ler = new Scanner(System.in);
        int numero;
        boolean jogadaValida = false;

        while (!jogadaValida) {
            System.out.print(nome + ", faça sua jogada (escolha um número de 1 a 9): ");
            numero = ler.nextInt();
            System.out.println("-----------------");
            jogadaValida = tabuleiro.fazerJogada(numero, simbolo);

            if (!jogadaValida) {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
    }

    public void setNome(String string) {
    }
}