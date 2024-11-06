package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int first = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            if(first <= next){
                first = next;
            }else{
                System.out.println("Bad");
                System.exit(0);
            }
        }

        System.out.println("Good");


    }

}
