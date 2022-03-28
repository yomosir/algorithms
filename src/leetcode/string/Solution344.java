package leetcode.string;

import java.util.Objects;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-28
 */
public class Solution344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(reverse(s));
    }

    public static String reverse(char[] s){
        int len = s.length;
        int i = 0, j = len - 1;
        while(i < j){
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++;
            j--;
        }
        StringBuilder str = new StringBuilder();
        for (char c : s) {
            if (Objects.nonNull(c)){
                str.append(c);
            }
        }
        return str.toString();
    }
}
