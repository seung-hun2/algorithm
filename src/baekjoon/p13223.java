package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13223 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),":");
        int start_h = Integer.parseInt(st.nextToken());
        int start_m = Integer.parseInt(st.nextToken());
        int start_s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),":");
        int fin_h = Integer.parseInt(st.nextToken());
        int fin_m = Integer.parseInt(st.nextToken());
        int fin_s = Integer.parseInt(st.nextToken());

        int s_sum = start_h*3600 + start_m*60 + start_s;
        int f_sum = fin_h*3600 + fin_m*60 + fin_s;
        int time = f_sum - s_sum;
        if(time<=0) time += 24*3600;
        int hour = time/3600;
        time%=3600;
        int min = time/60;
        time%=60;
        String answer = String.format("%02d:%02d:%02d",hour,min,time);
        System.out.println(answer);
    }

}
