package realestate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class RealEstateAgent {

    static TreeSet<RealEstate> stock = new TreeSet<>();

    RealEstateAgent() {

        try {
            File inputFile = new File("realestates.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pieces = line.split("#");
                if (!(pieces.length == 6 || pieces.length == 8))
                    System.err.println("There is input problem:" +
                            "no six or eight parts in a row");
                else if (pieces.length == 6) {
                    if (!pieces[0].equals("REALESTATE")) {
                        System.err.println("Six pieces but no" +
                                " REALESTATE start");
                    } else {

                        Genre newGenre;
                        switch (pieces[5]) {
                            case "CONDOMINIUM":
                                newGenre = Genre.CONDOMINIUM;
                                break;
                            case "FARM":
                                newGenre = Genre.FARM;
                                break;
                            case "FAMILYHOUSE":
                                newGenre = Genre.FAMILYHOUSE;
                                break;
                            default:
                                newGenre = Genre.FARM;
                                break;
                        }

                        stock.add(
                                new RealEstate(pieces[1],
                                        Double.parseDouble(pieces[2]),
                                        Integer.parseInt(pieces[3]),
                                        Double.parseDouble(pieces[4]),
                                        newGenre));

                    }
                }


                if (pieces.length == 8) {
                    if (!pieces[0].equals("PANEL")) {
                        System.err.println("Eight pieces but no PANEL start");

                    } else {

                        Genre newGen;
                        switch (pieces[5]) {

                            case "CONDOMINIUM":
                                newGen = Genre.CONDOMINIUM;
                                break;
                            case "FARM":
                                newGen = Genre.FARM;
                                break;
                            case "FAMILYHOUSE":
                                newGen = Genre.FAMILYHOUSE;
                                break;
                            default:
                                newGen = Genre.FARM;
                                break;
                        }
                        boolean insu = false;
                        switch (pieces[6]) {

                            case "yes":
                                insu = true;
                                break;
                            case "no":
                                break;
                        }

                        stock.add(
                                new Panel(pieces[1],
                                        Double.parseDouble(pieces[2]),
                                        Integer.parseInt(pieces[3]),
                                        Double.parseDouble(pieces[4]),
                                        newGen,
                                        Integer.parseInt(pieces[6]),
                                        insu));


                    }
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("No such file.");

        }


    }
}

