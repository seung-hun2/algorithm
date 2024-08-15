package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p5073 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ans = {"Equilateral", "Isosceles", "Scalene", "Invalid"};
        StringBuilder sb = new StringBuilder();

        while(true){
            int[] arr = new int[3];
            boolean flag = true;
            for(int i=0;i<3;i++){
                arr[i] = sc.nextInt();
                if(arr[i] == 0) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;

            Arrays.sort(arr);
            if(arr[2] >= arr[0] + arr[1]){
                sb.append(ans[3]).append('\n');
                continue;
            }
            if(arr[0] == arr[1]){
                if(arr[1] == arr[2]){
                    sb.append(ans[0]).append('\n');
                }else{
                    sb.append(ans[1]).append('\n');
                }
            }else if (arr[1] == arr[2]){
                if(arr[0] == arr[1]){
                    sb.append(ans[0]).append('\n');
                }else{
                    sb.append(ans[1]).append('\n');
                }
            }
            else{
                sb.append(ans[2]).append('\n');
            }


        }
        System.out.println(sb);
    }

}
