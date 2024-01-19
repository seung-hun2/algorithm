package baekjoon;

import java.util.Scanner;

public class p1065 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for(int i=1;i<=N;i++){
            String str = String.valueOf(i);
            int size = 0;
            if(str.length() == 1) {
                answer++;
                continue;
            }
            else{
                size = str.length();
                int value = Integer.MAX_VALUE;
                for(int j=0;j<str.length()-1;j++){
                    if(j == 0) {
                        value = str.charAt(j) - str.charAt(j+1);
                        size--;
                    }
                    
                    if(value != Integer.MAX_VALUE){
                        if(str.charAt(j) - str.charAt(j+1) == value){
                            size--;
                        }
                    }
                }
            }
            if(size == 0) answer++;
        }
        System.out.println(answer);
    }

}
