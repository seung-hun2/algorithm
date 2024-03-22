package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class p176962 {
    public String[] solution(String[][] plans) {
        Plan[] plan = new Plan[plans.length];
        for(int i=0;i<plans.length;i++){
            plan[i] = new Plan(plans[i]);
        }
        Arrays.sort(plan, (a,b)-> a.start - b.start);
        Stack<Plan> stop = new Stack<>();
        List<String> answer = new ArrayList<>();
        for(int i=0;i<plan.length-1;i++){
            Plan cur = plan[i];
            Plan next = plan[i+1];

            if(cur.getEndTime()>next.start){
                cur.playTime = cur.getEndTime() - next.start;
                stop.push(cur);
                continue;
            }
            answer.add(cur.name);

            int rest = next.start - cur.getEndTime();
            while(rest > 0 && !stop.isEmpty()) {
                Plan stoppedPlan = stop.peek();
                int timeDiff = stoppedPlan.playTime - rest;
                stoppedPlan.playTime = timeDiff;
                rest = timeDiff * -1;
                if(timeDiff > 0) break;
                answer.add(stop.pop().name);
            }

        }
        answer.add(plan[plan.length-1].name);
        while(!stop.isEmpty()) answer.add(stop.pop().name);
        return answer.toArray(new String[answer.size()]);


    }
    class Plan{
        String name;
        int start;
        int playTime;

        public Plan(String name, String start, String playTime){
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            this.playTime = Integer.parseInt(playTime);
        }
        public Plan(String[] plan){
            this(plan[0], plan[1], plan[2]);
        }

        public int getEndTime(){
            return start + playTime;
        }
    }

}
