package foodtruckfrenzy.Helper;

import java.io.InputStream;
import java.util.Scanner;

import foodtruckfrenzy.GameFramework.Grid;

/**
 * This class reads the layout file at runtime to store the data to be used in map creation
 * The static functon runs the reads layout.csv storing them in a 2d array of BoardElementEnum
 * They can later be accessed to create the map
 */
public class MapLayout {

    private LayoutEnum[][] layout;

    public MapLayout() {
        InputStream inputStream = MapLayout.class.getResourceAsStream("layout.csv");
        if (inputStream == null) {
            throw new RuntimeException("Unable to open layout.csv file input stream.");
        }

        try (Scanner scanner = new Scanner(inputStream)) {
            layout = new LayoutEnum[Grid.ROWS][Grid.COLS];
            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(",");
                
                if (items.length != Grid.COLS) {
                    throw new RuntimeException("The number of columns in the layout.csv file do not match Grid.cols");
                }

                for (int col = 0; col < items.length; col++) {

                    try {
                        layout[row][col] = LayoutEnum.valueOf(items[col]);
                    } catch (IllegalArgumentException iae) {
                        throw new RuntimeException("Invalid LayoutEnum valie in layout.csv file at row " + row + ", col " + col, iae);
                    }
                    
                }
                row++;
            }

            if (row != Grid.ROWS) {
                throw new RuntimeException("The number of rows in the layout.csv file does not match Grid.ROWS.");
            }
            scanner.close();
        }
    }

    /**
     * Gets the specified BoardElementEnum to be used in map creation
     * @param row row of specified BoardElementEnumt to return
     * @param col column of specified BoardElementEnumt to return
     * @return BoardElementEnum that was specified is returned
     */
    public LayoutEnum getElementAt(int row, int col) {
        return layout[row][col];
    }
}
