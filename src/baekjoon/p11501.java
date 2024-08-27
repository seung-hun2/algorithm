package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p11501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 전보다 가격이 오르면 무조건 사야된다 ,,
        StringBuilder sb = new StringBuilder();
        int T =sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt();
            long ans = 0;

            int maxValue = arr[N-1];
            for(int i=N-2;i>=0;i--){
                if(maxValue < arr[i]){
                    maxValue = arr[i];
                }else{
                    ans += maxValue-arr[i];
                }
            }
            sb.append(ans).append('\n');

            // 내려가는 포인트들을 기억해놓고 그전까지 팔면되지않나?
            // 아래 코드는 반례를 못 찾겠음 ,,
//            List<Integer> point = new ArrayList<>();
//            int value = 0;
//            int x = arr[0];
//            boolean check = false;
//            for(int i=0;i<N;i++){
//                if(x < arr[i]){
//                    check = true;
//                }else{
//                    if(check) {
//                        if(value < arr[i-1]) {
//                            value = arr[i-1];
//                            if(point.size() > 0 ){
//                                point.remove(point.size()-1);
//                            }
//                        }
//                        point.add(i-1);
//                    }
//                    check = false;
//                }
//                x=arr[i];
//            }
//            if(check) {
//                if(value < arr[N-1]) {
//                    if(point.size() > 0 ){
//                        point.remove(point.size()-1);
//                    }
//                }
//                point.add(N-1);
//            }
//
//
//
//            if(point.size() > 0 ) {
//                int idx = 0;
//                for (int i = 0; i < point.size(); i++) {
//                    int next = point.get(i);
//                    while (idx <= next && idx < N) {
//                        if(arr[next] - arr[idx] > 0) {
//                            ans += (arr[next] - arr[idx]);
//                        }
//                        idx++;
//                    }
//                }
//            }
//
//            sb.append(ans).append('\n');

        }

        System.out.println(sb);
    }

}
