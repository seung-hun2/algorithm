package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1208 {

    static int S;
    static long answer;
    static int[] numbers;
    static int status = -1;
    static final int LEFT = 0, RIGHT = 1;
    static Map<Integer, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        status = LEFT;
        recursive(0,N/2,0);

        status = RIGHT;
        recursive(N/2,N,0);

        if(S==0) answer--;
        System.out.println(answer);
    }

    public static void recursive(int index, int end, int sum) {
        // base case
        if (index == end) {
            if(status == LEFT){
                int prev = cnt.getOrDefault(sum, 0);
                cnt.put(sum, prev+1);
            }else if (status == RIGHT){
                answer += cnt.getOrDefault(S-sum, 0);
            }
            return ;
        }
        // recursive
        else {
            recursive(index + 1, end, sum);
            recursive(index + 1, end, sum + numbers[index]);
        }
    }

}
