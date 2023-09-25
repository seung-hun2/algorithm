package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p15828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        while(true){
            int a = sc.nextInt();
            if(a>0){
                if(q.size()<N)
                    q.offer(a);
            }else if (a==0){
                q.poll();
            }else{
                break;
            }
        }
        if(q.size()!=0) {
            while(!q.isEmpty()){
                System.out.print(q.poll()+" ");
            }
            System.out.println();
        }
        else{
            System.out.println("empty");
        }
    }

}
