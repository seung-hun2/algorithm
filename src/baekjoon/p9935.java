package baekjoon;


import java.util.Scanner;
import java.util.Stack;

public class p9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c4 = sc.next();

        int n = str.length();
        int m = c4.length();

        Stack<Character> s = new Stack<>();
        for(int i=0;i<n;i++){
            s.add(str.charAt(i));
            if(s.size() < m) continue;

            boolean isSame = true;
            for(int j=0;j<m;j++){
                if(s.get(s.size()-m+j) != c4.charAt(j)){
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                for(int j=0;j<m;j++) s.pop();
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s) sb.append(ch);
        if (sb.length() == 0) {
            System.out.println("FRULA");

        } else {
            System.out.println(sb);
        }

    }

}
