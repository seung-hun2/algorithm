package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int answer = 0;
        for(int i=0;i< str1.length()-str2.length()+1;i++){
            if(str1.substring(i,i+str2.length()).equals(str2)){
                i+=str2.length()-1;
                answer++;
            }
        }
        System.out.println(answer);
    }

}
