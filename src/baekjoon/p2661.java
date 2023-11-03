package baekjoon;

import java.util.Scanner;

public class p2661 {

    static int N;
    static int[] numbers = new int[80];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        solve(0);
    }
    public static boolean solve(int endIndex){
        if(endIndex == N){
            for(int i=0;i<N;i++){
                System.out.print(numbers[i]);
            }
            return true;
        }else{
            for(int i=1;i<=3;i++){
                numbers[endIndex] = i;
                if(!isBad(endIndex)){
                    if(solve(endIndex+1)) return true;
                }
            }
            return false;
        }
    }

    static boolean isBad(int endIndex){
        for(int i=1;i<=(endIndex+1)/2;i++){
            boolean isSame = true;
            for(int j=0;j<i;j++){
                if(numbers[endIndex-j] != numbers[endIndex-j-i]){
                    isSame = false;
                    break;
                }
            }
            if(isSame) return true;
        }
        return false;

    }
}
