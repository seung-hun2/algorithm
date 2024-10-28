package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p3649 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int x = sc.nextInt() * 10000000;
            int n = sc.nextInt();
            int[] lego = new int[n];
            for (int i = 0; i < n; i++) {
                lego[i] = sc.nextInt();
            }
            Arrays.sort(lego);

            boolean check = false;
            int l = 0, r = n - 1;
            while (l < r) {
                int sum = lego[l] + lego[r];
                if (sum == x) {
                    System.out.print("yes " + lego[l] + " " + lego[r]);
                    System.out.println();
                    check = true;
                    break;
                } else if (sum > x) {
                    r--;
                } else {
                    l++;
                }
            }

            if (!check) {
                System.out.println("danger");
            }
        }
    }

}
