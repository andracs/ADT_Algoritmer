/*
 *  Developed by András Ács (acsandras@gmail.com)
 *  Zealand / www.zealand.dk
 *  Licensed under the MIT License
 *  2019-04-03/04/2019
 *
 *  Data from http://www.vesseltracking.net/carrier/carrier-ships/1
 *
 */
package fleet.management;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FleetManagement {


    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        fleet.readFromFile();

        System.out.println("******** Fleet manager 0.1 *********");
        System.out.println("******** Up and running    *********");

        System.out.println(fleet.toString());

        String s = "";
        while(true || s.equals("q")){
            System.out.print("\n\n ** Indtast skibsnavn? (F.eks. MAYVIEW MAERSK): ");
            Scanner in = new Scanner(System.in);
            s = in.nextLine();
            if(s.equals("q")) {
                System.out.println("Tak for denne gang!"); break;}
            Ship ship = fleet.getShip(s);
            System.out.println(" Du kan se, hvor skibet er på " + ship.url());
            save(ship);
        }

    }

    private static void save(Ship ship) {

        try {
            String fileName = "data/serializedObjects/" + ship.getName().replace(" ", "-") +  " _" + ship.getIMO() + ".ser";
            FileOutputStream fileOut =
                    new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ship);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in" + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

}
