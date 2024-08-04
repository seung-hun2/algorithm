package baekjoon;

import java.util.Scanner;

public class p2096 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] max = new int[3];
        int[] min = new int[3];

        for(int i=0;i<N;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            if(i==0){
                max[0] = min[0] = n1;
                max[1] = min[1] = n2;
                max[2] = min[2] = n3;
            }else{
                int beforeMax1 = max[0], beforeMax2 = max[2];
                max[0] = Math.max(max[0], max[1]) + n1;
                max[2] = Math.max(max[1], max[2]) + n3;
                max[1] = Math.max(beforeMax1, Math.max(max[1], beforeMax2))+n2;

                int beforeMin1 = min[0], beforeMin2 = min[2];
                min[0] = Math.min(min[0], min[1]) + n1;
                min[2] = Math.min(min[1], min[2]) + n3;
                min[1] = Math.min(min[1], Math.min(beforeMin1, beforeMin2)) + n2;

            }
        }

        int max_value = 0, min_value = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            max_value = Math.max(max[i],max_value);
            min_value = Math.min(min[i],min_value);
        }

        System.out.println(max_value +" " + min_value);

    }

}
