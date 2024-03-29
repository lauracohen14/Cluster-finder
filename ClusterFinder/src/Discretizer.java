import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Discretizer {

    public static String inputFileName;
    public static int binFileCount;
    public static String[] binFiles;


    public static boolean checkMember(double val, Bin bin){
      return val>=bin.min && val<= bin.max;
    }

    public static String setBin(double val, BinList binList){
      String rtn = "";
      for(Bin bin: binList.bins){
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
          //filename #binfiles binfiles1 ... binfilesi ... binfilesn
          inputFileName = args[0];
          binFileCount = Integer.parseInt(args[1]);
          binFiles = new String[binFileCount];
          for (int i = 0; i!= binFileCount; ++i){
            binFiles[i] = (args[i+2]);
          }
        }


        ArrayList<BinList> classes = new ArrayList<BinList>();
        for(int i = 0; i != binFileCount; ++i){
          classes.add(new BinList(binFiles[i]));
        }
        ArrayList<String> featureNames = new ArrayList<String>(binFileCount);
        for(BinList bl: classes){
          featureNames.add(bl.name);
        }


        BufferedReader reader = new BufferedReader(new FileReader("Extracts/"+inputFileName));

        String minLine = reader.readLine();
        String cols[] = minLine.split(",");
        int[] indices = new int[binFileCount];

    //Create a mapping from data column index to bin in classes
        HashMap<Integer,BinList> map = new HashMap<Integer,BinList>();
        int breakVal = 0;
        for (int i = 0; i != cols.length; ++i){
          if(!featureNames.contains(cols[i])){
            continue;
          }else{
            indices[breakVal] = i;
            for(int j = 0; j != classes.size(); ++j){
              if(cols[i].equals(classes.get(j).name)){
                map.put(i,classes.get(j));
              }
            }
            ++breakVal;
          }
          if (breakVal >= binFileCount){
            break;
          }
        }

    //Update file
        String fileName = inputFileName.substring(0,inputFileName.length()-4);
        fileName = "Extracts/"+fileName+"Disc.csv";
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(minLine);

        String line;
        while((line = reader.readLine()) != null){

            String[] lineCol = line.split(",");

            //Replace each value with its corresponding bin
            for(int i = 0; i != indices.length; ++i){
              int index = indices[i];
              lineCol[index] = setBin(Double.parseDouble(lineCol[index]), map.get(index));
            }

            //Rewrite updated line
            String updatedLine = lineCol[0];
            for (int i = 1; i != lineCol.length; ++i){
              updatedLine += ","+lineCol[i];
            }
            writer.println(updatedLine);
        }

        writer.close();
        reader.close();






    }


}
