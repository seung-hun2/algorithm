package baekjoon;

import java.util.Scanner;

public class p1244 {

    static int N;
    static int[] sw;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sw = new int[N+1];
        for(int i=1;i<=N;i++) sw[i] = sc.nextInt();
        int stu = sc.nextInt();

        for(int i=0;i<stu;i++){
            int s = sc.nextInt();
            int num = sc.nextInt();
            change(s,num);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(sw[i]).append(" ");
            if(i%20 == 0) sb.append('\n');
        }
        System.out.println(sb);

    }

    static void change(int s, int num){
        if(s == 1){
            // 남학생 -> 배수 스위치 상태 바꾸기
            for(int i=num;i<=N;i+=num){
                if(sw[i] == 1){
                    sw[i] = 0;
                }else sw[i] = 1;
            }
        }else{
            // 여학생 -> 좌우 대칭
            int r = num + 1;
            int l = num - 1;
            while(l > 0 && r <= N){
                if(sw[l] != sw[r]) break;
                l--;
                r++;
            }

            for(int i=l+1;i<r;i++){
                if(sw[i] == 1){
                    sw[i] = 0;
                }else sw[i] = 1;
            }
        }
    }
}
