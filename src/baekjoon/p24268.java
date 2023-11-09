package baekjoon;

import java.util.Scanner;

public class p24268 {

    static int N,d;
    static int[] number;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d = sc.nextInt();
        number = new int[d];
        used = new boolean[d];

        int result = solve(0);
        System.out.println(result);

    }

    public static int solve(int depth){
        // base case
        if(depth == d){
            int result = 0;
            for(int i=0;i<d;i++){
                result *= d;
                result += number[i];
            }
            return result;
        }
        // recursive case
        int start = 0;
        if(depth == 0) start = 1;
        for(int i=start;i<d;i++){
            if(!used[i]) {
                used[i] = true;
                number[depth] = i;
                int num = solve(depth + 1);
                if(num > N) return num;
                used[i] = false;
            }
        }
        return -1;
    }

}
