package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p9996 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String pattern = sc.next();
        StringTokenizer st = new StringTokenizer(pattern,"*");
        String start = st.nextToken();
        String end = st.nextToken();
        int startSize = start.length();
        int endSize = end.length();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            String next = sc.next();
            String startCheck = "";
            String endCheck = "";
            if(next.length() < start.length()){
                sb.append("NE").append('\n');
                continue;
            }
            for(int j=0;j<startSize;j++){
                startCheck += next.charAt(j);
            }
            next = next.substring(startSize);

            if(!startCheck.equals(start)){
                sb.append("NE").append('\n');
                continue;
            }

            if(next.length() < end.length()){
                sb.append("NE").append('\n');
                continue;
            }
            for(int j=next.length()-endSize;j<next.length();j++){
                endCheck += next.charAt(j);
            }
            if(!endCheck.equals(end)){
                sb.append("NE").append('\n');
                continue;
            }

            sb.append("DA").append('\n');
        }

        System.out.println(sb);
    }

}
