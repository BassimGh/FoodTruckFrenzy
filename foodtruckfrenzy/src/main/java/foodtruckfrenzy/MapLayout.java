package foodtruckfrenzy;


import java.io.InputStream;
import java.util.Scanner;

public class MapLayout {
    protected static final BoardElementEnum[][] layout;

    static {
        InputStream inputStream = MapLayout.class.getResourceAsStream("layout.txt");
        Scanner scanner = new Scanner(inputStream);
        layout = new BoardElementEnum[Main.ROWS][Main.COLS];
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
}
