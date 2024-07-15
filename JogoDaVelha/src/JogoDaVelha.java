import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {                
        Campo velha[][] = new Campo[3][3]; 
        char simboloAtual = 'X';
        Boolean game = true;
        String vitoria = "";               
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < velha.length; i++) {
            for (int j = 0; j < velha.length; j++) {
                velha[i][j] = new Campo();
            }
        }
        
        while (game) {                        
            desenhaJogo(velha);
            vitoria = verificaVitoria(velha);
            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu.%n", vitoria);
                break;
            }            
            try {
                if (verificaJogada(velha, jogar(scanner, simboloAtual),simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    }else{
                        simboloAtual = 'X';
                    }
                }
            }catch(Exception e){
                System.out.printf("Erro");
            }        
        }       
    }

    public static void desenhaJogo(Campo[][] velha){
        //limparTela();
        System.out.println("    0   1   2");
        System.out.printf("0   %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("   -----------");
        System.out.printf("1   %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("   -----------");
        System.out.printf("2   %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }

    public static void limparTela(){
        for (int i = 0; i < 200; i++) {
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scanner, char sa){
        int p[] = new int[2];
        System.out.printf("%s %c %n","Quem joga: ", sa);
        System.out.printf("Informa a linha: ");
        p[0]= scanner.nextInt();
        System.out.printf("Informe a coluna: ");
        p[1] = scanner.nextInt();
        return p;
    }

    public static Boolean verificaJogada(Campo[][] velha, int p[], char simboloAtual){
        if (velha[p[0]][p[1]].getSimbolo()== ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else{
            return false;
        }
    }

    public static String verificaVitoria(Campo[][] velha){
        return "";
    } 
}
