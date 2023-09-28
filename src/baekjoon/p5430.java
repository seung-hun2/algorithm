package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            char[] cmds = sc.next().toCharArray();
            int cnt = sc.nextInt();

            Deque<Integer> dq = new LinkedList<>();
            boolean check = false;
            boolean isValid = true;
            StringTokenizer st = new StringTokenizer(sc.next(),"[,]");
            for(int j=0;j<cnt;j++){
                dq.add(Integer.parseInt(st.nextToken()));
            }

            for(char cmd: cmds){
                if(cmd == 'D'){
                    if(dq.isEmpty()){
                        isValid = false;
                        break;
                    }
                    if(check) dq.pollLast();
                    else dq.pollFirst();
                }
                else check = !check;
            }

            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while(!dq.isEmpty()){
                    sb.append(check ? dq.pollLast() : dq.pollFirst());
                    if(!dq.isEmpty()) sb.append(",");
                }
                System.out.println("["+sb+"]");
            } else {
                System.out.println("error");
            }
        }
    }

}
