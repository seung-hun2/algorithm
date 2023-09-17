package baekjoon;

import java.util.Scanner;

public class p1032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        for(int i = 1;i<N;i++){
            char[] newChar = sc.next().toCharArray();
            for(int j=0;j<arr.length;j++){
                if(newChar[j] != arr[j]) arr[j] = '?';
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

}
