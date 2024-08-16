package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class p25757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char ch = sc.next().charAt(0);
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(sc.next());
        }

        if (ch == 'Y') {
            System.out.println(set.size());
        }else if(ch == 'F'){
            System.out.println(set.size()/2);
        }else{
            System.out.println(set.size()/3);
        }
    }

}
