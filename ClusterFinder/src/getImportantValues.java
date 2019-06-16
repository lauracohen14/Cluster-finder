import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class getImportantValues {

    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("Which year do you want data for?");
        String year = scan.nextLine();

        System.out.println("Which cluster do you want data for?");
        String cluster = scan.nextLine();


        String nonFileName = year + "cluster"+ cluster;
        String name = nonFileName + ".csv";


        BufferedReader reader = new BufferedReader(new FileReader(name));

        String firstLine = reader.readLine();
        String cols[] = firstLine.split(",");


        String newFirstLine = cols[0] + "," + cols[1] + "," + cols[4] + "," +cols[5] + "," +cols[7] + "," + cols[9];
        

        String newFileName = nonFileName + "Selected.csv";
        PrintWriter writer = new PrintWriter(newFileName);
        writer.println(newFirstLine);


        String line;
        while((line = reader.readLine()) != null){

            String[] lineCol = line.split(",");
            String updatedLine = lineCol[0] + "," + lineCol[1] + "," + lineCol[4] + "," +lineCol[5] + "," +lineCol[7] + "," + lineCol[9];
            writer.println(updatedLine);
        }

        writer.close();
        reader.close();






    }



    //from here get the file, then I want to find the index of importants then
    //get the importants in one line
    //then put that line in a file and output


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
