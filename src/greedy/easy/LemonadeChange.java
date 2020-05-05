package greedy.easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int balance[] = new int[3];
        for(int bill:bills){
            switch(bill){
                case 5:
                    balance[0]++;
                    break;
                case 10:
                    if(balance[0]<=0)
                        return false;
                    balance[0]--;
                    break;
                case 20:
                    if((balance[1]<=0&&balance[0]<=2)||balance[0]<=0) //没有5块钱或者在没有10块钱的情况下没有3张五块钱不可以
                        return false;
                    else if(balance[1]>0){ // 有10块钱和5块钱，优先找10块
                        balance[1]--;
                        balance[0]--;
                    }else{ // 没有10块钱，但是有至少3张5块
                        balance[0] -=3;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
