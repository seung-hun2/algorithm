package baekjoon;

import java.util.Scanner;

public class p12891 {

    static int baseToIndex(char alpha){
        if(alpha == 'A') return 0;
        else if(alpha == 'C') return 1;
        else if(alpha == 'G') return 2;
        else if(alpha == 'T') return 3;
        else return -1;
    }

    static boolean isValid(int[] count, int[] minCount){
        for(int i=0;i<count.length;i++){
            if(count[i] < minCount[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int[] minCount = new int[4];
        for(int i=0;i<4;i++){
            minCount[i] = sc.nextInt();
        }

        int ans = 0;
        int[] count = new int[4];
        for(int i=0;i<P-1;i++){
            count[baseToIndex(arr[i])]++;
        }

        for(int i=P-1;i<S;i++){
            count[baseToIndex(arr[i])]++;
            if(isValid(count, minCount)) ans++;
            count[baseToIndex(arr[i-P+1])]--;
        }

        System.out.println(ans);
    }

}
