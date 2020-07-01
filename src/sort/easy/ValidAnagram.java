package sort.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(int i=0;i<s.length();i++)
            sCount[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
            tCount[t.charAt(i)-'a']++;
        return Arrays.equals(sCount,tCount);
    }
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> sHash = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        Map<Character,Integer> tHash = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        for(int i=0;i<s.length();i++)
            sHash.put(s.charAt(i),sHash.getOrDefault(s.charAt(i),0)+1);
        for(int i=0;i<t.length();i++)
            tHash.put(t.charAt(i),tHash.getOrDefault(t.charAt(i),0)+1);
        if(sHash.size()!=tHash.size())
            return false;
        for(char c:s.toCharArray())
            if((int)sHash.get(c)!=(int)tHash.getOrDefault(c,0)){
                return false;
            }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> charMap1 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        Map<Character, Integer> charMap2 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        for (char c : s.toCharArray())
            charMap1.put(c, charMap1.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray())
            charMap2.put(c, charMap2.getOrDefault(c, 0) + 1);
        if (charMap1.size() != charMap2.size())
            return false;
        for (char c : s.toCharArray()) {
            if (!charMap1.get(c).equals(charMap2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }
}
