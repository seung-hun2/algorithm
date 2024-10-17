package baekjoon;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p2870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<BigInteger> list = new ArrayList<>();
        String check;
        for(int i=0;i<N;i++){
            String str = sc.next();
            check = "";
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                    check += str.charAt(j);
                }else{
                    if(!check.equals("")){
                        list.add(new BigInteger(check));
                        check = "";
                    }
                }
            }

            if(!check.equals("")){
                list.add(new BigInteger(check));
            }

        }
        Collections.sort(list);
        for(BigInteger i: list){
            System.out.println(i);
        }
    }

}
