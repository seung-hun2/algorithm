package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1931 {

    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Meeting[] meetings = new Meeting[N];
        for(int i=0;i<N;i++){
             st = new StringTokenizer(br.readLine()," ");
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end==o2.end)
                    return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });

        int cnt = 0;
        int ended =0;
        for(Meeting meeting: meetings){
            if(ended <= meeting.start){
                cnt++;
                ended = meeting.end;
            }
        }
        System.out.println(cnt);
    }

}
