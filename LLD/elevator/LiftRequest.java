package LLD.elevator;

public class LiftRequest {
    private int source;
    private int destination;
    private char moveDirection;

    public LiftRequest(int source, int destination, char moveDirection) {
        this.source = source;
        this.moveDirection = moveDirection;
        this.destination = destination;
    }

    public char getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(char moveDirection) {
        this.moveDirection = moveDirection;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
