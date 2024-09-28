package baekjoon;

import java.util.Scanner;

public class p2816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] k = new int[2];
        for(int i=0;i<N;i++){
            String channel = sc.next();
            if(channel.equals("KBS1")) k[0] = i;
            else if(channel.equals("KBS2")) k[1] = i;
        }

        if(k[0] > k[1]) k[1]++;
        for(int i=0;i<2;i++){
            for(int j=0;j<k[i];j++){
                System.out.print("1");
            }
            if(i==1) k[1]--;
            for (int j=0;j<k[i];j++){
                System.out.print("4");
            }
        }
    }

}
