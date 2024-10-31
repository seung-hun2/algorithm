package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class p30804 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        HashMap<Integer, Integer> fruits = new HashMap<>();
        int maxLength = 0;
        int l = 0;
        for(int r=0;r<N;r++){
            fruits.put(arr[r], fruits.getOrDefault(arr[r],0)+1);
            while(fruits.size()>2){
                fruits.put(arr[l], fruits.get(arr[l])-1);
                if(fruits.get(arr[l]) == 0){
                    fruits.remove(arr[l]);
                }
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        System.out.println(maxLength);

    }

}
