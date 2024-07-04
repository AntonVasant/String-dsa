package LLD.tictactoe;

public class Player {

    String playerName;
    char playerMove;
    int playerId;
    public Player(String name,char playerMove){
        this.playerName = name;
        this.playerMove = playerMove;

    }

    public char getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(char playerMove) {
        this.playerMove = playerMove;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
