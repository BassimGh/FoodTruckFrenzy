package foodtruckfrenzy;

import java.util.ArrayList;
import java.util.Collections;

public class Cop extends Vehicle{

    private FoodTruck foodtruck;

    private ArrayList<Position> queue = new ArrayList<>();
    private ArrayList<Position> visited = new ArrayList<>();
    private ArrayList<Direction> directions = new ArrayList<>();

    private Position target;

    public Cop(int row, int col, Grid grid, FoodTruck player) {
        super(row, col, grid, DrawableEnum.COP_RIGHT);
        this.foodtruck = player;
        target = new Position(player.getRow(), player.getCol(), null);
        queue.add(new Position(row, col, null));
        getDirections();
    }

    @Override
    public boolean moveUp() {
        boolean moved = super.moveUp();
        this.setType(DrawableEnum.COP_UP);
        return moved;
    }

    @Override
    public boolean moveDown() {
        boolean moved = super.moveDown();
        this.setType(DrawableEnum.COP_DOWN);
        return moved;
    }

    @Override
    public boolean moveLeft() {
        boolean moved = super.moveLeft();
        this.setType(DrawableEnum.COP_LEFT);
        return moved;
    }

    @Override
    public boolean moveRight() {
        boolean moved = super.moveRight();
        this.setType(DrawableEnum.COP_RIGHT);
        return moved;
    }

    public void chaseTruck() {
        // target.row = foodtruck.getRow();
        // target.col = foodtruck.getCol();
        // target.prev = queue.get(queue.size() - 1);

        // queue.add(target);
        // getDirections();
        if (!directions.isEmpty()) {
            if (directions.get(0) == Direction.UP)
                moveUp();
            if (directions.get(0) == Direction.DOWN)
                moveDown();
            if (directions.get(0) == Direction.LEFT)
                moveLeft();
            if (directions.get(0) == Direction.RIGHT)
                moveRight();
            directions.remove(0);
        } else {
            System.out.println("directions is empty");
        }
    }

    public void getDirections() {
        // ArrayList<Direction> directions = new ArrayList<>();
        ArrayList<Position> path = new ArrayList<>();
        
        Position currentPos = queue.get(0);
        while (!(currentPos.row == target.row && currentPos.col == target.col)) {
            currentPos = queue.get(0);
            checkAdjacentCells(currentPos);
            visited.add(currentPos);

            queue.remove(0);
        }
        System.out.println("GOT PATH");
        path = getPath(currentPos);

        System.out.println("--- Start Queue -----");
        for (Position p : path) {
            if (p != null )System.out.println(p.col + " " + p.row);
        }
        System.out.println("#################################");
        
        // Converts set of coordinates to set of directions
        for (int i = 0; i < path.size() - 1; i++) {
            // get direction UP
            if (path.get(i).row > path.get(i + 1).row && path.get(i).col == path.get(i + 1).col)
                directions.add(Direction.UP);

            // get direction DOWN
            if (path.get(i).row < path.get(i + 1).row && path.get(i).col == path.get(i + 1).col)
                directions.add(Direction.DOWN);

            // get direction LEFT
            if (path.get(i).row == path.get(i + 1).row && path.get(i).col > path.get(i + 1).col)
                directions.add(Direction.LEFT);

            // get direction RIGHT
            if (path.get(i).row > path.get(i + 1).row && path.get(i).col < path.get(i + 1).col)
                directions.add(Direction.RIGHT);
        }

        System.out.println("--- Start Queue -----");
        for (Direction d : directions) {
            System.out.println(d);
        }
        System.out.println("#################################");

        System.out.println("got directions");
    }

    public ArrayList<Position> getPath(Position pos) {
        ArrayList<Position> path = new ArrayList<>();

        path.add(pos);
        while (!(pos.row == this.getRow() && pos.col == this.getCol())) {
            path.add(pos.prev);
            pos = pos.prev;
            if (pos == null)
                break;
        }

        Collections.reverse(path);

        return path;
    }

    public void checkAdjacentCells(Position pos) {

        // check upper adjacent cell
        if (pos.row - 1 >= 0 && !visited.contains(new Position(pos.row - 1, pos.col, pos)) 
        && !this.getGrid().getCell(pos.row - 1, pos.col).isObstruction())
            queue.add(new Position(pos.row - 1, pos.col, pos));

        // check lower adjacent cell
        if (pos.row + 1 < Grid.ROWS && !visited.contains(new Position(pos.row + 1, pos.col, pos)) 
        && !this.getGrid().getCell(pos.row + 1, pos.col).isObstruction())
            queue.add(new Position(pos.row + 1, pos.col, pos));

        // check left adjacent cell
        if (pos.col - 1 >= 0 && !visited.contains(new Position(pos.row, pos.col - 1, pos)) 
        && !this.getGrid().getCell(pos.row, pos.col - 1).isObstruction())
            queue.add(new Position(pos.row, pos.col - 1, pos));

        // check right adjacent cell
        if (pos.col + 1 < Grid.COLS && !visited.contains(new Position(pos.row, pos.col + 1, pos)) 
        && !this.getGrid().getCell(pos.row, pos.col + 1).isObstruction())
            queue.add(new Position(pos.row, pos.col + 1, pos));

    }
}
