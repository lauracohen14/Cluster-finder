import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class getMode {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //get the file for the year and cluster you want
        Scanner scan = new Scanner(System.in);
        System.out.println("Which year do you want data for?");
        String year = scan.nextLine();

        System.out.println("Which cluster do you want data for?");
        String cluster = scan.nextLine();


        String nonFileName = year + "cluster"+ cluster + "Selected";
        String name = nonFileName + ".csv";


        BufferedReader reader = new BufferedReader(new FileReader(name));


        //skip the first line since we dont want it
        //also find the index of each column, let you choose which column to find mode of
        String firstLine = reader.readLine();
        String[] firstLineArray = firstLine.split(" ");

        System.out.println("Which column (index) would you like the mode of?");
        for(int i =0; i < firstLineArray.length; i ++){
            System.out.println(firstLineArray[i] + ": index " + i);

        }

        int chosenColumn = scan.nextInt();

        //use this for formatting output
        String chosenColW = " ";

        for(int i = 0; i < firstLineArray.length; i ++){
            chosenColW = firstLineArray[chosenColumn];
        }

        reader.close();


        BufferedReader secondReader = new BufferedReader(new FileReader(name));

        //skip first line
        String firstLine2 = secondReader.readLine();

        String nextLines;

        //hold the different types for the column
        //hold the counts of each type
        ArrayList<String> columnHolder = new ArrayList<String>();
        ArrayList<Integer> counterArray = new ArrayList<Integer>();


        //while havent touched each entry
        while((nextLines = secondReader.readLine()) != null){

            //take the entry and split it
            String[] nextLinesArray = nextLines.split(" ");


            //if this is the first entry, put the value in the holder and add 1 to the counter
            if(columnHolder.size() == 0){
                columnHolder.add(nextLinesArray[chosenColumn]);
                counterArray.add(1);
            }

            //if its not the first
            else {

                boolean in = false;
                //for each value already in the holder
                for (int i = 0; i < columnHolder.size(); i++) {

                    //check if the chosen column matches any of those values
                    if(nextLinesArray[chosenColumn].equals(columnHolder.get(i))){

                        in = true;

                        //if it does, increase count in the count holder
                        Integer value = counterArray.get(i);
                        value = value + 1;
                        counterArray.set(i, value);

                    }


                }
                if(!in){

                    //if it doesnt, add this new value to the end of the holder
                    //add a new count of 1

                    columnHolder.add(nextLinesArray[chosenColumn]);
                    counterArray.add(1);

                }
            }


        }

        secondReader.close();

        int max = 0;
        String columnIndex = "";

        for(int i = 0; i < counterArray.size(); i ++){
            if (counterArray.get(i) > max){
                max = counterArray.get(i);
                columnIndex = columnHolder.get(i);
            }

        }

        System.out.println("The mode of index " + chosenColumn + " " + chosenColW + " is " + columnIndex + " with " + max + " counts.");

    }
}
