package baekjoon;

import java.util.Scanner;

public class p20055 {

    static int N,K;
    static int[] A;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[2*N];
        check = new boolean[N];

        for(int i=0;i<A.length;i++){
            A[i] = sc.nextInt();
        }
        System.out.println(solve());
    }

    static int solve(){
        int cnt = 0;
        while(isOk()){
            int tmp = A[A.length-1];
            for(int i=A.length-1;i>0;i--){
                A[i] = A[i-1];
            }
            A[0] = tmp;

            for(int i=check.length-1;i>0;i--){
                check[i] = check[i-1];
            }
            check[0] = false;
            check[N-1] = false;


            for(int i=check.length-1;i>0;i--){
                if(check[i-1] && !check[i]&& A[i]>=1){
                    A[i]--;
                    check[i] = true;
                    check[i-1] = false;
                }
            }

            if(A[0]>0){
                check[0] = true;
                A[0]--;
            }

            cnt++;
        }
        return cnt;
    }

    static boolean isOk(){
        int cnt = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == 0) cnt++;
            if(cnt >= K) return false;
        }
        return true;
    }

}
