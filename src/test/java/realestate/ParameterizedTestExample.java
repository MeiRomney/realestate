package realestate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestExample {

    static Stream<RealEstate> provideRealEstates() throws Exception {
        // ✅ Load realestates2.txt from test/resources/realestate/
        var inputStream = ParameterizedTestExample.class.getResourceAsStream("/realestates2.txt");
        if (inputStream == null) {
            throw new IllegalStateException("File not found: /realestates2.txt (place it under src/test/resources/realestate)");
        }

        // ✅ Read all lines first, then close reader safely
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            List<RealEstate> list = reader.lines()
                    .filter(line -> line.startsWith("REALESTATE")) // ignore irrelevant lines
                    .map(line -> {
                        String[] parts = line.split("#");
                        String city = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        int sqm = Integer.parseInt(parts[3]);
                        double rooms = Double.parseDouble(parts[4]);
                        Genre genre = Genre.valueOf(parts[5]);
                        return new RealEstate(city, price, sqm, rooms, genre);
                    })
                    .toList();
            return list.stream(); // ✅ safe stream (no closed reader issue)
        }
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("provideRealEstates")
    void testGetTotalPriceFromFile(RealEstate re) {
        double multiplier;
        switch (re.getCity().toLowerCase()) {
            case "budapest": multiplier = 1.30; break;
            case "debrecen": multiplier = 1.20; break;
            case "nyíregyháza":
            case "nyiregyhaza": multiplier = 1.15; break;
            default: multiplier = 1.0; break;
        }

        double expected = re.getPrice() * re.getSqm() * multiplier;
        assertEquals((int) expected, re.getTotalPrice(),
                "Total price calculation mismatch for: " + re.getCity());
    }
}
