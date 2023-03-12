package foodtruckfrenzy;


import java.io.InputStream;
import java.util.Scanner;

public class MapLayout {

    private static BoardElementEnum[][] layout;

    static {
        InputStream inputStream = MapLayout.class.getResourceAsStream("layout.csv");
        Scanner scanner = new Scanner(inputStream);
        layout = new BoardElementEnum[Grid.ROWS][Grid.COLS];
        int row = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(",");
            for (int col = 0; col < items.length; col++) {
                layout[row][col] = BoardElementEnum.valueOf(items[col]);
            }
            row++;
        }
        scanner.close();
    }

    public static BoardElementEnum getElementAt(int row, int col) {
        return layout[row][col];
    }
}
