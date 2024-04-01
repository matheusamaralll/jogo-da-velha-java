package JogoVelha;

public class Tabuleiro {
    private char[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new char[3][3];
    }

    public void inicializarTabuleiro() {
        char valor = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = valor;
                valor++;
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.println("  " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("  ---------");
        System.out.println("  " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("  ---------");
        System.out.println("  " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
        System.out.println(" ");
    }

    public boolean fazerJogada(int numero, char simbolo) {
        if (numero >= 1 && numero <= 9) {
            int linha = (numero - 1) / 3;
            int coluna = (numero - 1) % 3;
            if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O') {
                tabuleiro[linha][coluna] = simbolo;
                return true;
            }
        }
        return false;
    }

    public boolean verificarVitoria(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == simbolo && tabuleiro[1][j] == simbolo && tabuleiro[2][j] == simbolo) {
                return true;
            }
        }
        if (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) {
            return true;
        }
        if (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo) {
            return true;
        }
        return false;
    }

    public boolean estaCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] != 'X' && tabuleiro[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public void desfazerJogada(int linha, int coluna) {
    }
}