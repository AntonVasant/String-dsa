package LLD.snakeLadder;

import java.util.UUID;

public class Player {
    String name;
    String id;
    int currentPos;

    public Player(String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.currentPos = 0;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }


}
