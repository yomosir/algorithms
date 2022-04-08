package leetcode.string;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-29
 */
public class Solution03 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()){
            return 0;
        }
        int len = s.length();
        if (1 == len){
            return 1;
        }
        Map<Character, Integer> pos = new HashMap<>(len);
        List<Character> sub = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < len; i++){
            if(!sub.contains(s.charAt(i))){
                // 将字串字符放入list中
                sub.add(s.charAt(i));
                // 保存位置，方便追溯
                pos.put(s.charAt(i), i);
            }else{
                // 如果已经存在了，找到对应位置，重新开始
                sub.clear();
                i = pos.get(s.charAt(i));
            }
            max = Math.max(max, sub.size());
        }
        return max;
    }
}
