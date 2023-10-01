package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p5397 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            char[] ch = sc.next().toCharArray();
            Deque<Character> beforeCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();
            for(char c: ch){
                if(c == '<'){
                    if(!beforeCursor.isEmpty()) afterCursor.offerLast(beforeCursor.pollLast());
                }
                else if(c == '>'){
                    if(!afterCursor.isEmpty()) beforeCursor.offerLast(afterCursor.pollLast());
                }
                else if(c == '-'){
                    beforeCursor.pollLast();
                }
                else{
                    beforeCursor.offerLast(c);
                }
            }
            while(!beforeCursor.isEmpty()) sb.append(beforeCursor.pollFirst());
            while(!afterCursor.isEmpty()) sb.append(afterCursor.pollLast());
            sb.append('\n');
        }
        System.out.println(sb);

    }

}
