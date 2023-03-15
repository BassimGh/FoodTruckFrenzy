package foodtruckfrenzy.Drawable.Vehicle;

import java.util.LinkedList;

class PositionList extends LinkedList<Position> {
    public boolean containsPos(Position pos) {
        if (this.isEmpty()) return false;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).col == pos.col && this.get(i).row == pos.row)
                return true;
        }
        
        return false;
    }
    
}
