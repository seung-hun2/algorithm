package baekjoon;

import java.util.Scanner;

public class p1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] check;
        int ans = 0;
        for(int i=0;i<N;i++){
            check = new int[26];
            boolean ch = true;
            char[] arrays = sc.next().toCharArray();

            check[arrays[0]-'a']++;
            for(int j=1;j< arrays.length;j++){
                if(check[arrays[j]-'a'] > 0){
                    if(arrays[j] != arrays[j-1]) ch = false;
                }else{
                    check[arrays[j]-'a']++;
                }
            }

            if(ch) ans++;
        }
        System.out.println(ans);
    }

}
