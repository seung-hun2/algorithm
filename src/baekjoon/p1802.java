package baekjoon;

import java.util.Scanner;

public class p1802 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 1 -> OUT
        // 0 -> IN
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            String next = sc.next();
            if(check(next,0,next.length()-1)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);

    }

    static boolean check(String next, int start, int end){
        if(start == end) return true;
        int mid = (start + end)/2;
        for(int i=start;i<mid;i++){
            if(next.charAt(i) == next.charAt(end-i)) return false;
        }
        return check(next, start, mid-1) && check(next, mid+1, end);
    }

}
