package stack.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new NewComparator());
        for(int i:stones){
            priorityQueue.add(i);
        }
        while(priorityQueue.size()>1){
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();
            int new_stone = 0;

            if(stone1==stone2)
                continue;
            else if(stone1>stone2)
                new_stone=stone1-stone2;
            else if(stone1<stone2)
                new_stone=stone2-stone1;
            priorityQueue.add(new_stone);
        }
        if(priorityQueue.size()==0)
            return 0;
        else
            return priorityQueue.peek();
    }

    class NewComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer integer, Integer t1) {
            return t1-integer;
        }
    }
}
