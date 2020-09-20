package sort.easy;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        //计数排序，先遍历字符串保存到int数组，再来回遍历int数组添加到s后直到数组长度不改变
        int[] iarr = new int[26];
        char[] carr = s.toCharArray();
        String result = "";
        for(char c:carr)
            iarr[(int)(c-'a')]++;
        int sLength=0;
        while(true){
            for(int i=0;i<iarr.length;i++){
                if(iarr[i]>0){
                    result+=(char)(i+'a'); //注意表示含义的变量和表示个数的数组的区别，这里i错写为iarr[i]了
                    iarr[i]--;
                }
            }
            for(int i=iarr.length-1;i>=0;i--){
                if(iarr[i]>0){
                    result+=(char)(i+'a');
                    iarr[i]--;
                }
            }
            if(result.length()==sLength)
                break;
            sLength=result.length();
        }
        return result;
    }
    public String sortString2(String s) {
        //计数排序，先遍历字符串保存到int数组，再来回遍历int数组添加到s后直到数组长度不改变
        //使用StringBuilder加快字符串构建速度
        int[] iarr = new int[26];
        char[] carr = s.toCharArray();
        StringBuilder result = new StringBuilder(); //使用StringBuilder能加快速度
        for(char c:carr)
            iarr[(int)(c-'a')]++;
        int sLength=0;
        while(result.length()<s.length()){
            for(int i=0;i<iarr.length;i++){
                if(iarr[i]>0){
                    result.append((char)(i+'a')); //注意表示含义的变量和表示个数的数组的区别，这里i错写为iarr[i]了
                    iarr[i]--;
                }
            }
            for(int i=iarr.length-1;i>=0;i--){
                if(iarr[i]>0){
                    result.append((char)(i+'a'));
                    iarr[i]--;
                }
            }
            if(result.length()==sLength)
                break;
        }
        return result.toString();
    }
}
