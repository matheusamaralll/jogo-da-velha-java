package JogoVelha;
import java.util.Random;

public class Computador extends Jogador {
    public Computador(char simbolo) {
        super("Computador", simbolo);
    }

    public void fazerJogada(Tabuleiro tabuleiro) {
        Random rand = new Random();
        int numero;
        boolean jogadaValida = false;

        while (!jogadaValida) {
            numero = rand.nextInt(9) + 1;
            jogadaValida = tabuleiro.fazerJogada(numero, getSimbolo());
        }
        System.out.println("O Computador fez sua jogada: " );
    }
}
