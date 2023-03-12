package foodtruckfrenzy;

import java.util.ArrayList;

public class Cop extends Vehicle{

    private FoodTruck foodtruck;

    private int targetX;
    private int targetY;

    public Cop(int row, int col, Grid grid, FoodTruck target) {
        super(row, col, grid, DrawableEnum.COP_RIGHT);
        targetX = target.getCol();
        targetY = target.getRow();
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
        this.moveRight();
        int currentX = this.getRow();
        int currentY = this.getCol();

        int targetX = foodtruck.getCol();
        int targetY = foodtruck.getRow();

        getPath();

        // while (!(currentX == targetX && currentY == targetY)) {
        //     move();
        // }
    }

    public void getPath() {
        Position currentPosition = new Position(this.getCol(), this.getRow());
        ArrayList<Direction> allDirections = new ArrayList<>();
        allDirections.add(Direction.UP);
        allDirections.add(Direction.DOWN);
        allDirections.add(Direction.LEFT);
        allDirections.add(Direction.RIGHT);

        ArrayList<Position> visited = new ArrayList<>();
        ArrayList<Position> toVisit = new ArrayList<>(); 

        toVisit.add(currentPosition);
        visited.add(currentPosition);

        while (!allDirections.isEmpty()) {
            if (isValidMove(allDirections.get(0))) {
                toVisit.add()
            }
            allDirections.remove(0);
        }

    }

    public Direction isValidMove(Direction direction) {
        if (direction == Direction.UP && targetY - 1 > 0 &&
            this.getGrid().getCell(targetX, targetY - 1).isObstruction())
                return Direction.UP;

        if (direction == Direction.DOWN && targetY + 1 < Grid.ROWS &&
            this.getGrid().getCell(targetX, targetY + 1).isObstruction())
                return Direction.DOWN;

        if (direction == Direction.LEFT && targetX - 1 > 0 &&
            this.getGrid().getCell(targetX - 1, targetY).isObstruction())
                return Direction.LEFT;

        if (direction == Direction.RIGHT && targetX + 1 < Grid.COLS &&
            this.getGrid().getCell(targetX + 1, targetY).isObstruction())
                return Direction.RIGHT;

        return null;
    }

}
