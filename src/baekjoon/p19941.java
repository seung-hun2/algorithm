package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class p19941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        char[] ch = sc.next().toCharArray();
        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++){
            if(ch[i] == 'P'){
                for(int j=-K;j<=K;j++){
                    if(i+j >= N) break;
                    if(i+j<0) continue;

                    if(ch[i+j] == 'H' && !visited[i+j]){
                        visited[i+j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

}
