import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Bubblesort{

    public static void printArray(int[] array) {
        for (int a : array){
            System.out.print(a + " ");
        
        }
        System.out.println();
    }
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for ( int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArraytoFile(int[] array, String fileName) throws Exception {
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            for (int a: array){
                fileWriter.write(a + "\n");
            }
            fileWriter.close();
        }catch (IOException e) {
            System.out.println("IOException occured");
            e.printStackTrace(); 
        }
        }
    
    
     public static int[] readArrayFromFile(String fileName){
        File file = new File (fileName);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(fileName);
        while (scanner.hasNextLine()) {
          String str = scanner.nextLine();
          int a = Integer.parseInt(str);
          arrayList.add(a);
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++){
            array[i] = arrayList.get(i);

        } return array;
     }
       
      public static void bubblesort(int[]array){
        for (int i = array.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array [j]= array[j+1];
                    array[j + 1] = temp; 

                }
            }
            printArray(array);
        }
      }

      public static void main(String[] args) throws Exception{
        try (Scanner scan = new Scanner(System.in)) {
            int arrayLength = scan.nextInt();
        }
        System.out.println("input fileName"); 
        
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        int[] array = readArrayFromFile(fileName);
        bubblesort(array);
        writeArraytoFile(array, "sorted.txt"); 
           scanner.close();
      }

      }
    
