import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
public static void main(String[] args){
    try{
        ArrayList<Integer> readArray = new ArrayList<Integer>() ;
        File file = new File("/Users/gelilachaka/downloads/data_random.txt");
        Scanner reader = new Scanner(file);
        while (reader.hasNextInt()){
        readArray.add(reader.nextInt());
        }




    }



catch(IOException e){
    System.out.println("Error while reading") ;
    }
}}