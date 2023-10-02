package baekjoon;

import java.util.Scanner;

public class p16120 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        char[] rewind = new char[input.length];
        int rewindLength = 0;

        for(char ch : input){
            rewind[rewindLength++] = ch;
            if(rewindLength >= 4 && rewind[rewindLength-1] == 'P' && rewind[rewindLength-4] == 'P' && rewind[rewindLength-3] == 'P' && rewind[rewindLength-2] == 'A'){
                rewindLength -= 3;
            }
        }

        System.out.println(rewindLength==1 && rewind[0] == 'P' ? "PPAP" : "NP");
    }


}
