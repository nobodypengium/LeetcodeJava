package greedy.easy;

public class IsSubsequence {
    // 为什么要写递归呢？这么麻烦
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))
            return true;

        if(s.length()>1){
            for(int i=0;i<t.length();i++)
                if(s.charAt(0)==t.charAt(i)) // 比较成功就调用相同的方法解决之后的s和之后的t的是否是子串问题
                    return isSubsequence(s.substring(1),t.substring(i+1));
        }else{ // 终止条件，s.length()==1，比较到最后一个子字符串字符了
            for(int i=0;i<t.length();i++)
                if(s.charAt(0)==t.charAt(i))
                    return true;
            return false;
        }
        return false;
    }

    // 循环，遍历长字符串，如果遇到跟短字符串指针所在位置相同的字母，则短字符串指针往后移，看看有没有下一个字符。
    // 时间复杂度O(n)
    public boolean isSubsequence1(String s, String t){
        int j=0;
        for(int i=0;i<t.length()&&j<s.length();i++){
            if(s.charAt(j)==t.charAt(i))
                j++;
        }
        return j==s.length();
    }

    public boolean isSubsequence2(String s, String t){
        t = " "+t;
        int table[][] = new int[26][t.length()];
        for(int ch=0;ch<26;ch++){
            int p=-1; //从后往前遍历，当然最右边几个没有对应字符啦
            for(int i=t.length()-1;i>=0;i--){
                table[ch][i]=p;
                if(t.charAt(i)=='a'+ch)
                    p=i;
            }
        }
        for(int i=0,p=0;i<s.length();i++){ // 从入口空格开始(p=0)
            p = table[s.charAt(i)-'a'][p];
            if(p==-1)
                return false;
        }
        return true;
    }

    // 使用index of加快速度，indexOf(字符串，起始位置)，找不到返回-1，找到返回位置，如果起始位置超过数组长度，也会返回-1
    public boolean isSubsequence3(String s, String t){
        int p = -1;
        for(int i=0;i<s.length();i++){
            p=t.indexOf(s.charAt(i),p+1);
            if(p==-1)
                return false;
        }
        return true;
    }


}
