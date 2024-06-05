package elfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class CSVReader {
    private final File file;

    public CSVReader(File file) {
        this.file = file;
    }

    public Set<Product> readFile() {
        try {
            System.out.println(System.getProperty("java.class.path"));
            Scanner csvScanner = new Scanner(file);
            Set<Product> products = new HashSet<>();

            while (csvScanner.hasNextLine()) {
                String line = csvScanner.nextLine();
                Map<String, String> records = getRecordFromLine(line);
                Product product = new Product(records.get("id"), records.get("name"), new BigDecimal(records.get("price")));
                products.add(product);
            }

            return products;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> getRecordFromLine(String line) {
        Map<String, String> values = new HashMap<>();

        try (Scanner rowScanner = new Scanner(line)) {
            String DELIMITER = ",";
            rowScanner.useDelimiter(DELIMITER);

            if (rowScanner.hasNext()) {
                values.put("id", rowScanner.next());
            } else {
                throw new IllegalArgumentException("Line does not contain enough fields: " + line);
            }

            if (rowScanner.hasNext()) {
                values.put("name", rowScanner.next());
            } else {
                throw new IllegalArgumentException("Line does not contain enough fields: " + line);
            }

            if (rowScanner.hasNext()) {
                values.put("price", rowScanner.next());
            } else {
                throw new IllegalArgumentException("Line does not contain enough fields: " + line);
            }
        }

        return values;
    }
}
