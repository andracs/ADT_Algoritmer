/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-04-03/04/2019
 *
 */

package fleet.management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Fleet implements java.io.Serializable {

    private static final String COMMA_DELIMITER = ",";
    private HashSet<Ship> ships;

    public Fleet() {
        ships = new HashSet<Ship>();
    }

    public void readFromFile() {

        // Fra https://www.baeldung.com/java-csv-file-array
        try (BufferedReader br = new BufferedReader(new FileReader("data/shipdata/convertcsv.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);

                int imo = Integer.valueOf(values[0]);
                String shipName = values[1];
                Year built = Year.of(Integer.valueOf(values[2]));
                int TEU = Integer.valueOf(values[3]);
                int GT = Integer.valueOf(values[4]);
                int DWT = Integer.valueOf(values[5]);
                double length = Double.valueOf(values[6]);

                Ship ship = new Ship(imo, shipName, built, TEU, GT , DWT, length);
                ships.add(ship);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Ship getShip(String name) {
        Iterator i = ships.iterator();
        while(i.hasNext()) {
            Ship s = (Ship) i.next();
            //System.out.println("Searching for " + name  + " found " + s.getName());
            if (s.getName().equals(name) ) {
                System.out.println("Found " + s.toString());
                return s ;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String returnStr = "Fleet: ";

        Iterator i = ships.iterator();
        while(i.hasNext()) {
            Ship s = (Ship) i.next();
            returnStr += s.getName() + ",  ";
        }
        return returnStr;
    }

    public HashSet<Ship> getShips() {
        return ships;
    }
}
