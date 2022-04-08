package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengguochun
 * @description
 * @date 2022-04-03
 */
public class Solution438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("baa", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        /**
         * "cbaebabacd"
         * "abc"
         */
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int pLen = p.length();
        for (int i = 0; i < pLen; i++){
            map.put(p.charAt(i), null == map.get(p.charAt(i))? 1: map.get(p.charAt(i)) + 1);
        }
        int gap = length - pLen;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= gap; i++){
            String temp = s.substring(i, i + pLen);
            if (check(temp, pLen, map)){
                res.add(i);
            }
        }
        return res;
    }

    public static boolean check(String str, int len, Map<Character, Integer> map){
        Map<Character, Integer> temp = new HashMap<>(map);
        for (int i = 0; i < len; i++){
            if (map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                count--;
                if (0 >= count ){
                    map.remove(str.charAt(i));
                }
            }
        }
        return temp.size() == 0;
    }
}
