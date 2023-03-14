package foodtruckfrenzy;

import java.util.ArrayList;
import java.util.Collections;

public class Cop extends Vehicle{

    private FoodTruck foodtruck;

    private ArrayList<Position> queue = new ArrayList<>();
    private PositionList visited = new PositionList();
    private ArrayList<Direction> directions = new ArrayList<>();

    private Position target;
    private Position searchOrigin;

    public Cop(int row, int col, Grid grid, FoodTruck player) {
        super(row, col, grid, DrawableEnum.COP_RIGHT);
        this.foodtruck = player;
        target = new Position(player.getRow(), player.getCol(), null);
        queue.add(new Position(row, col, null));
        System.out.println("\n ONLY SHOULD PRINT ONCE \n");
        searchOrigin = new Position(row, col, null);
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
        System.out.println(directions.size());
        target.row = foodtruck.getRow();
        target.col = foodtruck.getCol();

        // System.out.println("--- Queue -----");
        // for (Position q : queue) {
        //     if (q != null )System.out.println(q.col + " " + q.row);
        //     else System.out.println("null");
        // }

        if (!queue.isEmpty())
            target.prev = queue.get(0);
        
        // System.out.println("target pos \t" + target.col + " " + target.row);
        // System.out.println("previous pos \t" + target.prev.col + " " + target.prev.row);
        // System.out.println("\n");
        // System.out.println("--- Queue -----");
        // for (Position q : queue) {
        //     if (q != null )System.out.println(q.col + " " + q.row);
        // }
        // System.out.println("#################################");

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
        }

        if (!(target.row == target.prev.row && target.col == target.prev.col)) {
            System.out.println("getting directinons");
            queue.add(new Position(target.row, target.col, target.prev));
            getDirections();
        }
    }

    public void getDirections() {
        // ArrayList<Direction> directions = new ArrayList<>();
        ArrayList<Position> path = new ArrayList<>();
        
        Position currentPos = queue.get(0);
        System.out.println("current Position: " + currentPos.col + " " + currentPos.row);

        while (!(currentPos.row == target.row && currentPos.col == target.col)) {
            currentPos = queue.get(0);
            checkAdjacentCells(currentPos);
            visited.add(currentPos);

            queue.remove(0);
        }
        // Position lastPos = queue.get(queue.size()-1);
        queue.clear();
        queue.add(currentPos);
        System.out.println("QUeue size: " + queue.size());
        System.out.println("Last element: " + queue.get(queue.size() - 1).col + " " + queue.get(queue.size() - 1).row);
        System.out.println("current Position: " + currentPos.col + " " + currentPos.row);
        
        System.out.println("--- Queue -----");
        for (Position q : queue) {
            if (q != null )System.out.println(q.col + " " + q.row);
        }
        System.out.println("#################################");
        
        path = getPath(currentPos);

        System.out.println("--- Path -----");
        for (Position p : path) {
            if (p != null)System.out.println(p.col + " " + p.row);
            else System.out.println("null");
        }
        System.out.println("#################################");
        
        if (path.size() > 0) {
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
                if (path.get(i).row == path.get(i + 1).row && path.get(i).col < path.get(i + 1).col)
                    directions.add(Direction.RIGHT);
            }
        }

        System.out.println("--- Directions -----");
        for (Direction d : directions) {
            System.out.println(d);
        }
        System.out.println("#################################");
    }

    public ArrayList<Position> getPath(Position pos) {
        ArrayList<Position> path = new ArrayList<>();

        path.add(pos);
        while (!(pos.row == searchOrigin.row && pos.col == searchOrigin.col)) {
            path.add(pos.prev);
            pos = pos.prev;
            if (pos == null)
                break;
        }
        Collections.reverse(path);

        searchOrigin = path.get(path.size() - 1);
        return path;
    }

    public void checkAdjacentCells(Position pos) {

        // check upper adjacent cell
        if (pos.row - 1 >= 0 && !visited.containsPos(new Position(pos.row - 1, pos.col, pos)) 
        && !this.getGrid().getCell(pos.row - 1, pos.col).isObstruction())
            queue.add(new Position(pos.row - 1, pos.col, pos));

        // check lower adjacent cell
        if (pos.row + 1 < Grid.ROWS && !visited.containsPos(new Position(pos.row + 1, pos.col, pos)) 
        && !this.getGrid().getCell(pos.row + 1, pos.col).isObstruction())
            queue.add(new Position(pos.row + 1, pos.col, pos));

        // check left adjacent cell
        if (pos.col - 1 >= 0 && !visited.containsPos(new Position(pos.row, pos.col - 1, pos)) 
        && !this.getGrid().getCell(pos.row, pos.col - 1).isObstruction())
            queue.add(new Position(pos.row, pos.col - 1, pos));

        // check right adjacent cell
        if (pos.col + 1 < Grid.COLS && !visited.containsPos(new Position(pos.row, pos.col + 1, pos)) 
        && !this.getGrid().getCell(pos.row, pos.col + 1).isObstruction())
            queue.add(new Position(pos.row, pos.col + 1, pos));

    }
}
