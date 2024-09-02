package baekjoon;

import java.util.Scanner;

public class p1522 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        int min = Integer.MAX_VALUE;
        int aLen = 0;
        for(int i=0;i<ch.length;i++){
            if(ch[i] == 'a') aLen++;
        }

        for(int i=0;i<ch.length;i++){
            int bCnt = 0;
            for(int j=i;j<aLen+i;j++){
                if(ch[j%ch.length] == 'b') bCnt++;
            }
            min = Math.min(min, bCnt);
        }

        System.out.println(min);

    }

}
