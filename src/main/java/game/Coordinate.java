package game;

import java.util.ArrayList;

public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Coordinate> getNeighbours() {
        ArrayList<Coordinate> neighbours = new ArrayList<>();
        for (int x = this.x-1; x <= this.x + 1; x++) {
            for (int y = this.y-1; y <= this.y + 1; y++) {
                Coordinate neighbour = new Coordinate(x, y);
                if (neighbour.equals(this))
                    continue;
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        String xyComposed = x + "-" + y;
        return xyComposed.hashCode();
    }
}
