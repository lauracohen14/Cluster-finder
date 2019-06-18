import java.io.*;
import java.util.*;

public class ModeExtractor{

    public static String fileName;
    public static String modeReq;
    public static void main(String[] args) throws FileNotFoundException, IOException {

      //Allow for command line arguments for quicker testing.
      //If none are given, ask for parameters
      if(args.length == 0){
        System.out.println("No arguments provided");
        System.exit(0);
      }else{
        fileName="Extracts/"+args[0];
        modeReq = args[1];
      }
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String firstLine = reader.readLine();
        String[] flList = firstLine.split(",");
        ArrayList<String> firstLineArray = new ArrayList<String>(Arrays.asList(flList));
        int chosenColumn = firstLineArray.indexOf(modeReq);

        String nextLines;
        HashMap<String,Counter > valueCount = new HashMap<String,Counter >();


        //while havent touched each entry
        while((nextLines = reader.readLine()) != null){

            //take the entry and split it
            String[] nextLinesArray = nextLines.split(",");

            String feature = nextLinesArray[chosenColumn];

            if(valueCount.containsKey(feature)){
              valueCount.get(feature).inc();
            }else{
              valueCount.put(feature, new Counter(feature));
            }
        }

        reader.close();
        Iterator iter = valueCount.values().iterator();
        Counter mode = (Counter) iter.next();
        while(iter.hasNext()){
          Counter curr = (Counter) iter.next();
          // System.out.println(curr);
          if(mode.size() < curr.size()){
            mode = curr;
          }
        }

      //Write new file
          reader = new BufferedReader(new FileReader(fileName));
          fileName = fileName.substring(0,fileName.length()-4);
          fileName = fileName+"Modal.csv";
          PrintWriter writer = new PrintWriter(fileName);
          writer.println(firstLine);

          String line;
          while((line = reader.readLine()) != null){

              String[] lineCol = line.split(",");
              if(mode.match(lineCol[chosenColumn])){
                writer.println(line);
              }
          }
          writer.close();
          reader.close();
    }
}
