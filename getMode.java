import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class getMode {

    public static void main(String[] args) throws FileNotFoundException, IOException {


        Scanner scan = new Scanner(System.in);
        System.out.println("Which year do you want data for?");
        String year = scan.nextLine();

        System.out.println("Which cluster do you want data for?");
        String cluster = scan.nextLine();


        String nonFileName = year + "cluster"+ cluster + "Selected";
        String name = nonFileName + ".csv";


        BufferedReader reader = new BufferedReader(new FileReader(name));


        String firstLine = reader.readLine();
        String[] firstLineArray = firstLine.split(",");

        System.out.println("Which column (index) would you like the mode of?");
        for(int i =0; i < firstLineArray.length; i ++){
            System.out.println(firstLineArray[i] + ": index " + i);

        }

        int chosenColumn = scan.nextInt();



        String line;
        int entryCounter = 0;

        while((line = reader.readLine()) != null){
            entryCounter ++;
        }

        System.out.println(entryCounter);

        reader.close();

        BufferedReader secondReader = new BufferedReader(new FileReader(name));

        String firstLine2 = secondReader.readLine();

        String nextLines;

        ArrayList<String> columnHolder = new ArrayList<String>();
        ArrayList<Integer> counterArray = new ArrayList<Integer>();


        int countIndex = 0;
        while((nextLines = secondReader.readLine()) != null){

            String[] nextLinesArray = nextLines.split(",");

            if(columnHolder.size() == 0){
                columnHolder.add(nextLinesArray[chosenColumn]);
                counterArray.add(1);
            }
            else {
                for (int i = 0; i < columnHolder.size(); i++) {
                    if(nextLinesArray[chosenColumn] == columnHolder.get(i)){

                        Integer value = counterArray.get(i);
                        value = value + 1;
                        counterArray.set(i, value);

                    }
                    else{
                        columnHolder.add(nextLinesArray[chosenColumn]);
                        counterArray.add(1);
                    }
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

        System.out.println("The mode of index " + chosenColumn + " is " + columnIndex + " with " + max + " counts.");









        //read in file
        //get column we want mode of
        //read in each line, get value of that column
        //for each line, check that column, keep an array of all values found and an array of counts, if current line
        //matches anything in the array, ++ the counter from the other array, if not matching then add it to the array at the end
        //and init that index in other array to zero
        //at the end, see which index is the highest and that is the mode of the column


    }
}
