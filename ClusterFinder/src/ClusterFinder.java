import java.io.*;
import java.util.Scanner;
import java.util.*;


public class ClusterFinder {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        Scanner scan = new Scanner(System.in);

        //Get the year
        System.out.println("Which year do you want to read in (1994-2014)?");
        String year = scan.nextLine();
        String yearFile = year + ".csv";

        //Get the cluster
        System.out.println("Which cluster do you want to read in (1-71)?");
        String cluster = scan.nextLine();

        //Read the year file
        BufferedReader reader = new BufferedReader(new FileReader(yearFile));
        String firstLine = reader.readLine();

        //Break first line to get index
        String[] cols = firstLine.split(",");

        //create new file and write the first line to have headers
        String newFileName = year + "cluster"+ cluster + ".csv";
        PrintWriter writer = new PrintWriter(newFileName);
        writer.println(firstLine);

        //check each line, if the cluster indices are equal, write that line to the new file
        String nextline;
        while((nextline = reader.readLine()) != null){
            String[] div = nextline.split(",");
            if(div[32].equals(cluster)){
                writer.println(nextline);
            }
        }

        writer.close();
        reader.close();
    }

}



//        0 = season
//        1 = daytype
//        2 = k_count
//        3 = Municipality
//        4 = monthly_income
//        5 = water_access
//        6 = roof_material
//        7 = wall_material
//        8 = cb_size
//        9 = floor_area
//        10 = years_electrified
//        11 = fridge_freezer
//        12 = geyser
//        13 = heater
//        14 = hotplate
//        15 = iron
//        16 = kettle
//        17 = microwave
//        18 = 3_plate
//        19 = 4_plate
//        20 = tv
//        21 = washing_machine
//        22 = fridge_freezer_use
//        23 = geyser_use
//        24 = heater_use
//        25 = hotplate_use
//        26 = iron_use
//        27 = kettle_use
//        28 = microwave_use
//        29 = 3_plate_use
//        30 = 4_plate_use
//        31 = washing_machine_use
//        32 = k

