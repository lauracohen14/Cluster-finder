import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Discretizer {

    public static String inputFileName;
    public static int binFileCount;
    public static String[] binFiles;
    public ArrayList<BinList> classes;


    public static boolean checkMember(int val, Bin bin){
      return val>=bin.min && val<= bin.max;
    }

    public static String setBin(int val, ArrayList<Bin> bins){
      String rtn = "";
      for(Bin bin: bins){
        if(checkMember(val,bin)){
          rtn = bin.name;
          return rtn;
        }
      }
      return rtn;
    }




    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        if(args.length==0){

          System.out.println("No arguments provided");
          System.exit(0);

        }else{
          inputFileName = args[0];
          binFileCount = Integer.parseInt(args[1]);
          binFiles = new String[binFileCount];
          for (int i = 0; i!= binFileCount; ++i){
            binFiles[i] = (args[i+2]);
          }
        }

        Discretizer disc = new Discretizer();

        disc.classes = new ArrayList<BinList>();
        for(int i = 0; i != binFileCount; ++i){
          disc.classes.add(new BinList(binFiles[i]));
        }








        BufferedReader reader = new BufferedReader(new FileReader("Extracts/"+inputFileName));

        String minLine = reader.readLine();
        String cols[] = minLine.split(",");
        int incomeIndex = -1;
        int floorIndex = -1;

        //Determine index of features to discretize
        for (int i = 1; i != cols.length; ++i){
          if(cols[i].equals("monthly_income")){
            incomeIndex = i;
          }else if(cols[i].equals("floor_area")){
            floorIndex = i;
          }
          if(incomeIndex+floorIndex != -2){
            break;
          }
        }
        //
        // fileName = fileName.substring(0,fileName.length()-4);
        // fileName = "Extracts/"+fileName+"Selected.csv";
        // PrintWriter writer = new PrintWriter(fileName);
        // writer.println(minLine);
        //
        //
        // String line;
        // while((line = reader.readLine()) != null){
        //
        //     String[] lineCol = line.split(",");
        //     String updatedLine = lineCol[features[0]];
        //     for (int i = 1; i != featuresCount; ++i){
        //       minLine += ","+lineCol[features[i]];
        //     }
        //     writer.println(updatedLine);
        // }
        //
        // writer.close();
        // reader.close();






    }


}
