package foodtruckfrenzy;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position> {
    public boolean containsPos(Position pos) {
        if (this.isEmpty()) return false;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).col == pos.col && this.get(i).row == pos.row)
                return true;
        }
        
        return false;
    }
    
}
