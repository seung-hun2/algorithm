package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(n>0){
            int d = n%b;
            if(d<10) answer+=d;
            else answer += (char)(d-10+'A');
            n /= b;
        }
        for(int i=answer.length()-1;i>=0;i--){
            System.out.print(answer.charAt(i));
        }
        System.out.println();


    }

}
