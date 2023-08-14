package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int[] answer = new int[7];
        boolean check = false;
        int answerIdx = 0;
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                if(sum - arr[i] - arr[j] == 100){
                    for(int k=0;k<9;k++){
                        if(arr[k] != arr[i] && arr[k] != arr[j]){
                            answer[answerIdx++] = arr[k];
                        }
                    }
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        Arrays.sort(answer);
        for(int i=0;i<7;i++){
            System.out.println(answer[i]);
        }

    }

}
