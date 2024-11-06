package baekjoon;


import java.util.Scanner;

public class p1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = String.valueOf(N);
        int[] arr = new int[10];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            while (true){
                if(arr[i] != 0){
                    sb.append(i);
                    arr[i]--;
                }else break;
            }
        }
        System.out.println(sb);
    }

}
