package LLD.tictactoe;

public class Main {
    public static void main(String a[]){
        String player1 = "Anton";
        String player2 = "Mershesha";
        char p1M = 'X';
        char p2M = '0';
        Player player = new Player(player1,p1M);
        Player player3 = new Player(player2,p2M);
        Board board = new Board(player,player3,3);
    }
}
