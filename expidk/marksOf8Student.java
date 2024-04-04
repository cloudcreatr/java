import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class marksOf8Student {
    public static void main(String[] args) throws IOException{
        int[] marks = new int[8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the marks of 8 students: ");
        for(int i = 0; i<8; i++){
           
                marks[i] = Integer.parseInt(br.readLine());
           
        }
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        System.out.println("The sum of marks of 8 students is: " + sum);
    }
}
