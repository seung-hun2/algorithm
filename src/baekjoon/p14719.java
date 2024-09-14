package baekjoon;

import java.util.Scanner;

public class p14719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] map = new int[W];
        for(int i=0;i<W;i++){
            map[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i=1;i<W-1;i++){
            int l = 0;
            int r = 0;
            for(int j=0;j<i;j++){
                l = Math.max(map[j],l);
            }
            for(int j=i+1;j<W;j++){
                r = Math.max(map[j],r);
            }

            if(map[i] < l && map[i] < r){
                ans += Math.min(l,r) - map[i];
            }

        }

        System.out.println(ans);

    }

}
