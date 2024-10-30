package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = Integer.MAX_VALUE;
        String[] sub = str.split("-");

        for(int i=0;i<sub.length;i++){
            int tmp = 0;
            String[] add = sub[i].split("\\+");

            for(int j=0;j<add.length;j++){
                tmp += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }
        System.out.println(sum);



    }


}
