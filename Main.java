import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
public static void main(String[] args){

    ArrayList<Integer> readArray = Main.listNum();
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
    
    for(Integer data: readArray){
           maxHeap.add(data);
           System.out.println(data);
    }
    Sequencial(maxHeap);

    Integer[] OptimalList = Main.listNum().toArray(new Integer [0]);
    MaxHeap<Integer> OptimalHeap = new MaxHeap<Integer>(OptimalList);
    Optimal(OptimalHeap);

}
  static ArrayList<Integer>listNum(){
    ArrayList<Integer> readArray = new ArrayList<Integer>() ;
    try{
        File file = new File("/Users/gelilachaka/downloads/data_random.txt");
        Scanner myreader = new Scanner(file);
        while (myreader.hasNextInt()){
        readArray.add(Integer.parseInt(myreader.nextLine()));
        }
    }

catch(IOException e){
    System.out.println("Error while reading") ;
    }
    return readArray;
}

static void Sequencial(MaxHeap<Integer> heap){



}

static void Optimal(MaxHeap<Integer> heap){

}
}