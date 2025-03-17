package LLD.tictactoe;

public class Player {

    String playerName;
    char playerMove;
    int playerId;
    public Player(String name,char playerMove, int playerId){
        this.playerName = name;
        this.playerId = playerId;
        this.playerMove = playerMove;

    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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
