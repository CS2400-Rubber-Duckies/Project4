import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> readArray = Main.listNum();
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);

        for (Integer data : readArray) {
            maxHeap.add(data);
            System.out.println(data);
        }
        Sequencial(maxHeap);

        Integer[] OptimalList = Main.listNum().toArray(new Integer[0]);
        MaxHeap<Integer> OptimalHeap = new MaxHeap<Integer>(OptimalList);
        Optimal(OptimalHeap);

    }

    static ArrayList<Integer> listNum() {
        ArrayList<Integer> readArray = new ArrayList<Integer>();
        try {
            File file = new File("data_random.txt");
            Scanner myreader = new Scanner(file);
            while (myreader.hasNextInt()) {
                readArray.add(Integer.parseInt(myreader.nextLine()));
            }
            myreader.close();
        }

        catch (IOException e) {
            System.out.println("Error while reading");
        }
        return readArray;
    }

    static void Sequencial(MaxHeap<Integer> heap) {
        System.out.print("Heap built using sequential insertions: ");
        heap.FirstTenEntry();
        System.out.println();

        System.out.print("Number of swaps in the heap creation: " + heap.SequencialSwaps);
        System.out.println();

        // Remove first 10 and print
        for (int i = 0; i < 10; i++) {
            heap.removeMax();
        }
        System.out.print("Heap after 10 removals: ");
        heap.FirstTenEntry();

    }

    static void Optimal(MaxHeap<Integer> heap) {
        System.out.println();
        System.out.print("Heap built using optimal method: ");
        heap.FirstTenEntry();
        System.out.println();

        System.out.print("Number of swaps in the heap creation: " + heap.OptimalSwaps);
        System.out.println();

        // Remove first 10 and print
        for (int i = 0; i < 10; i++) {
            heap.removeMax();
        }
        System.out.print("Heap after 10 removals: ");
        heap.FirstTenEntry();

    }
}