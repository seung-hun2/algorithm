package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[50];
        int idx = 0;
        for(int i=1;;i++){
            int num = i*(i+1)/2;
            if(num > 1000) break;
            arr[idx++] = num;
        }
        boolean[] sumNumber = new boolean[1001];
        boolean[] isEurekaNumber = new boolean[1001];

        for(int i=0;i<idx;i++){
            for(int j=0;j<idx;j++){
                int sum = arr[i] + arr[j];
                if(sum<1000) sumNumber[sum] = true;
            }
        }
        for(int i=1;i<1000;i++){
            if(!sumNumber[i]) continue;
            for(int j=0;j<idx;j++){
                int sum = i + arr[j];
                if(sum <= 1000) isEurekaNumber[sum] = true;
            }
        }


        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            System.out.println(isEurekaNumber[k] ? "1":"0");
        }
    }

}
