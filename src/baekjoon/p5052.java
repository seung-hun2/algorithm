package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p5052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<t;tc++){
            int n = sc.nextInt();
            String[] arr = new String[n];
            boolean check = true;
            for(int i=0;i<n;i++){
                arr[i] = sc.next();
            }
            Arrays.sort(arr);
            for(int i=0;i<n-1;i++){
                if(arr[i+1].startsWith(arr[i])){
                    check = false;
                    break;
                }
            }
            if(check){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }

}
