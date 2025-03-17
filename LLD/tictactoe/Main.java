package LLD.tictactoe;

public class Main {
    public static void main(String a[]){
        String player1 = "Anton";
        String player2 = "Mershesha";
        char p1M = 'X';
        char p2M = '0';
        Player player = new Player(player1,p1M,1);
        Player player3 = new Player(player2,p2M,-1);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print('\0');
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2)System.out.println("-+-+-");

        }
    }
}
