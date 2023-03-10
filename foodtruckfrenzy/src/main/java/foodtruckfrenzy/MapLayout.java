package foodtruckfrenzy;


import java.io.InputStream;
import java.util.Scanner;

public class MapLayout {
    protected static final ItemEnum[][] layout;

    static {
        InputStream inputStream = MapLayout.class.getResourceAsStream("layout.txt");
        Scanner scanner = new Scanner(inputStream);
        layout = new ItemEnum[10][10];
        int row = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(",");
            for (int col = 0; col < items.length; col++) {
                layout[row][col] = ItemEnum.valueOf(items[col]);
            }
            row++;
        }
        scanner.close();
    }
}
