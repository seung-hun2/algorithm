package baekjoon;

import java.util.Scanner;

public class p1068 {

    static int N,count = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        arr = new int[N+1];
        visited = new boolean[N+1];
        int root = 0;

        for(int i=0;i<N;i++){
            int next = sc.nextInt();
            if(next == -1) root = i;
            arr[i] = next;
        }

        int eraseIdx = sc.nextInt();
        // 노드 지우는 코드
        delete(eraseIdx);
        // 여기서 개수 출력하는 코드
        countLeaf(root);

        System.out.println(count);
    }

    static void delete(int idx){
        arr[idx] = -2;
        for(int i=0;i<N;i++){
            if(arr[i] == idx) delete(i);
        }
    }

    static void countLeaf(int idx){
        boolean isLeaf = true;
        visited[idx] = true;
        if(arr[idx] != -2){
            for(int i=0;i<N;i++){
                if(arr[i] == idx && !visited[i]) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }

}
