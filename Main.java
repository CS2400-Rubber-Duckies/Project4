import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
public static void main(String[] args){
    try{
        ArrayList<Integer> readArray = new ArrayList<Integer>() ;
        File file = new File("/Users/gelilachaka/downloads/data_random.txt");
        Scanner myreader = new Scanner(file);
        while (myreader.hasNextInt()){
        readArray.add(myreader.nextInt());
        }
int[] HeapArray = new int[readArray.size()];
for (int i =0;i< readArray.size();i++){
    HeapArray[i] = readArray.get(i);
     MaxHeap h = new MaxHeap();

     
}

    }



catch(IOException e){
    System.out.println("Error while reading") ;
    }
}}