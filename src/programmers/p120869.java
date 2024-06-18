package programmers;

public class p120869 {
    public int solution(String[] spell, String[] dic) {
        int answer = 2; int index = 0;

        for(int i = 0; i < dic.length; i++) {
            index = 0;
            for(int j = 0; j < spell.length; j++) {
                if(dic[i].contains(spell[j])) index++;
                if(index == spell.length) answer = 1;
            }
        }

        return answer;
    }

}
