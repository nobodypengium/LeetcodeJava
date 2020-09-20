package sort.easy;

public class AverageSalaryExcludingtheMinimumandMaximumSalary {
    public double average(int[] salary) {
        int sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int s:salary){
            if(s>max)
                max=s;
            if(s<min)
                min=s;
            sum+=s;
        }
        sum = sum-max-min;
        return (double)sum/(double)(salary.length-2); //看好返回值，如果返回float会出错
    }
}
