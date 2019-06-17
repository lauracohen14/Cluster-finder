import java.io.*;
import java.util.Scanner;
import java.util.*;


public class ClusterFinder {
    public static String year;
    public static int clusterCount;
    public static ArrayList<String> clusters;


    public static void main(String args[]) throws FileNotFoundException, IOException {



      //Allow for command line arguments for quicker testing.
      //If none are given, ask for parameters
      if(args.length == 1){

        Scanner scan = new Scanner(System.in);

        //Get the year
        System.out.println("Which year do you want to read in (1994-2014)?");
        year = scan.nextLine();

        //Get the cluster
        System.out.println("How many clusters do you want?");
        clusterCount = scan.nextInt();
        clusters = new ArrayList<String>();


        System.out.println("Enter desired clusters, follow each with return");
        for (int i = 0; i != clusterCount; ++i){
          clusters.add(scan.nextLine());
        }


      }else{
        year = args[1];
        clusterCount = Integer.parseInt(args[2]);
        clusters = new ArrayList<String>();
        for (int i = 0; i != clusterCount; ++i){
          clusters.add(args[i+3]);
        }
      }

      //Read the year file
      BufferedReader reader = new BufferedReader(new FileReader(year+".csv"));
      String firstLine = reader.readLine();

      //Break first line to get index
      String[] cols = firstLine.split(",");

      //create new file and write the first line to have headers
      String newFileName = year + "clusterCount"+ clusterCount + ".csv";
      PrintWriter writer = new PrintWriter(newFileName);
      writer.println(firstLine);

      //check each line, if the cluster indices are equal, write that line to the new file
      String nextline;
      while((nextline = reader.readLine()) != null){
          String[] div = nextline.split(",");
          if(clusters.contains(div[32])){
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
