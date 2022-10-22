package game;

import java.util.ArrayList;

public class Cell {
    public boolean isAlive;
    public Coordinate position;
    private ArrayList<Cell> neighbours;
    // temporary-field code smell... but necessary because
    // we need to check fist the neighbours and later apply the rules
    // if we don't want to duplicate the board (one for previous state, other for changes)
    // https://refactoring.guru/es/smells/temporary-field
    private int numberOfAliveNeighbours = -1;

    public Cell(boolean status, Coordinate position) {
        this.isAlive = status;
        this.position = position;
    }

    public void setNeighbours(ArrayList<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public void kill() {
        // this method is called kill but should be placed as
        // kill(Cell cell) in the board to be grammar correct
        // anyway this can cause problems
        // if we call .suicide() inside the board we observe that someone cant suicide someone else
        // have we found wrong responsibilities?
        this.isAlive = false;
    }

    public void born() {
        this.isAlive = true;
    }

    public void calculateNeighbours() {
        numberOfAliveNeighbours = 0;
        for (Cell cell : neighbours) {
            if (cell.isAlive())
                numberOfAliveNeighbours++;
        }
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void applyRules() {
        applyDeathRules();
        applyBornRules();
    }

    private void applyBornRules() {
        if (!this.isAlive && numberOfAliveNeighbours == 3)
            born();
    }

    private void applyDeathRules() {
        if (this.isAlive && (numberOfAliveNeighbours <= 1 || numberOfAliveNeighbours >= 4) ) {
            kill();
        }
    }
}
