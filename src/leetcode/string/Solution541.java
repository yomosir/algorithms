package leetcode.string;

import java.util.*;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-28
 */
public class Solution541 {
    public static void main(String[] args) {
        reverse("a", 2);
    }

    /**
     *
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     *
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2 输出: "bacdfeg"
     */
    private static void reverse(String str, int k){
        int len = str.length();
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while(l < len){
            if (l + k <= len) r = l + k;
            else r = len;
            StringBuilder temp = new StringBuilder();
            temp.append(str, l, r);
            StringBuilder tempReverse = temp.reverse();
            System.out.println(tempReverse);
            sb.append(tempReverse);
            if (r + k > len) sb.append(str, r, len);
            else sb.append(str, r, r + k);
            l = r + k;
            r = l + k;
            if (r >= len){
                r = len;
            }
        }
        System.out.println(sb.toString());
    }


    public String reverseStr(String s, int k) {

        List<Integer> highTemp = new LinkedList<>();
        Iterator<Integer> iterator =  highTemp.iterator();
        while (iterator.hasNext()){
            Integer j = iterator.next();
            iterator.remove();
        }

        int size = s.length();
        char[] ch = s.toCharArray();

        for(int i = 0; i < size; i = i + 2 * k ){
            swap(ch, i, Math.min(i + k, size) - 1);
        }
        return new String(ch);
    }

    public void swap(char[] ch, int left, int right){
        while(left < right){

            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
    }
}
