package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class p9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            Stack<Character> stack = new Stack<>();
            String str = sc.next();
            boolean check = false;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == '('){
                    stack.push('(');
                }else{
                    if(stack.isEmpty()){
                        System.out.println("NO");
                        check = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if (!check && stack.isEmpty())
                System.out.println("YES");
            else {
                if(!check) {
                    System.out.println("NO");
                }
            }
        }
    }

}
