import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class BinList{

  public String name;
  public ArrayList<Bin> bins;
  public int classSize;

  public BinList(String binFileName){
    try{
      readBinFile(binFileName);
    }catch(IOException e){
      System.out.println("Failed to read bin file: "+binFileName);
    }

  }


  private void readBinFile(String binFileName) throws IOException{

    this.bins = new ArrayList<Bin>();

    BufferedReader reader = new BufferedReader(new FileReader("DiscBins/"+binFileName));


    this.name = reader.readLine();
    this.classSize = Integer.parseInt(reader.readLine());

    //Add first bin 0-min
    int max = Integer.parseInt(reader.readLine());
    int min = 0;
    bins.add(new Bin(""+min+"-"+max, min, max-1));

    //Add middle bins
    for(int i = 0 ; i != classSize-1; ++i){
      min = max;
      max = Integer.parseInt(reader.readLine());
      bins.add(new Bin(""+min+"-"+max, min, max-1));
    }

    //Add final bin
    min = max;
    max = 500000;
    bins.add(new Bin(""+min+"+", min, max));
  }
}
