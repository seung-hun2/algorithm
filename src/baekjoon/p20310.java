package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p20310 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        // 1은 앞에서부터 없애야하고 0은 뒤에서부터 없애야 사전순으로 빠른 걸 구할수 있지 않을까,,
        int o = 0, z = 0;
        char[] ch = new char[S.length()];
        for(int i=0;i<S.length();i++){
            ch[i] = S.charAt(i);
            if(S.charAt(i) == '0'){
                z++;
            }else{
                o++;
            }
        }

        o /= 2;
        z /= 2;


        int slen = S.length();
        for(int i=0;i<slen && o!=0;i++){
            if(ch[i] == '1'){
                o--;
                ch[i] = 0;
            }
        }

        for(int i=slen-1;i>=0 && z!=0;i--){
            if(ch[i] == '0'){
                z--;
                ch[i] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<slen;i++){
            if(ch[i]!=0){
                sb.append(ch[i]);
            }
        }
        System.out.println(sb);
    }

}
