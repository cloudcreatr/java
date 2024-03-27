import java.io.*;

public class bubblesort {
    public static void main(String args[]) {
        System.out.println("Enter the size ");
        Inputmethods sizeinput = new Inputmethods();

        int size = sizeinput.inputint();
        int[] arr = new int[size];

        System.out.println("enter the elements\n");
        for (int i = 0; i < arr.length; i++) {
            
                arr[i] = sizeinput.inputint();
           
        }
        bubblesortlogic b = new bubblesortlogic();
        b.sort(arr);
        System.out.println("Sorted array: ");
        b.printArray(arr);
    }

}

class Inputmethods {
    public Integer inputint() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            return n;
        } catch (IOException e) {
            System.out.println("Error in input");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
        return null;
    }
}

class bubblesortlogic {
    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
