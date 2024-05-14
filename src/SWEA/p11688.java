package SWEA;

import java.util.Scanner;

public class p11688 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            String str = sc.next();
            int a = 1, b = 1;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch == 'L'){
                    a = a;
                    b = a+b;
                }else{
                    a = a + b;
                    b = b;
                }
            }

            sb.append("#").append(tc).append(" ").append(a).append(" ").append(b).append('\n');
        }
        System.out.println(sb);
    }

}
