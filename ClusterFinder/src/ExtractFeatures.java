import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class ExtractFeatures {

    public static int featuresCount;
    public static int[] features;
    public static String fileName;

    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        if(args.length==0){
          Scanner scan = new Scanner(System.in);

          System.out.println("Which file do you want to extract from?");
          fileName = scan.nextLine();

          System.out.println("How many columns do you want?");
          featuresCount = scan.nextInt();
          features = new int[featuresCount];

          System.out.println("Enter desired columns, each followed by a space");
          for (int i = 0; i != featuresCount+1; ++i){
            features[i]=scan.nextInt();
            scan.skip(" ");
          }
          scan.close();

        }else{
          fileName = args[0];
          featuresCount = Integer.parseInt(args[1]);
          features = new int[featuresCount];
          for (int i = 0; i!= featuresCount; ++i){
            features[i] = Integer.parseInt(args[i+2]);
          }
        }




        BufferedReader reader = new BufferedReader(new FileReader("Extracts/"+fileName));

        String firstLine = reader.readLine();
        String cols[] = firstLine.split(",");
        firstLine = cols[features[0]];


        for (int i = 1; i != featuresCount; ++i){
          firstLine += ","+cols[features[i]];
        }

        fileName = fileName.substring(0,fileName.length()-4);
        fileName = "Extracts/"+fileName+"Selected.csv";
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(firstLine);


        String line;
        while((line = reader.readLine()) != null){

            String[] lineCol = line.split(",");
            String updatedLine = lineCol[features[0]];
            for (int i = 1; i != featuresCount; ++i){
              firstLine += ","+lineCol[features[i]];
            }
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
