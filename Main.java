import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int[][] arr = new int[a][2];
        for(int i=0; i<a; i++){
            for(int j=0; j<2; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        int temp = 0;
        for(int i=0; i<a;i++) {
            for (int j = 1; j < 2; j++) {
                if (arr[i][j] < arr[i][j - 1]) {
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j - 1];
                    arr[i][j - 1] = temp;
                }
            }
        }
            for(int i=0; i<a;i++){
                for(int j=0; j<2; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

    }
}