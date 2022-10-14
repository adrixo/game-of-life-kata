package game;

public class Cell {
    public boolean isAlive;
    public Coordinate position;

    public Cell(boolean status, Coordinate position) {
        this.isAlive = status;
        this.position = position;
    }

    public void kill() {
        // this method is called kill but should be placed as
        // kill(Cell cell) in the board to be gramarly correct
        // anyways this can cause problems
        // if we call .suicide() inside of the board we observe that someone cant suicide someone else
        // have we found wrong responsabilities?
        this.isAlive = false;
    }

    public void born() {
        this.isAlive = true;
    }
}
