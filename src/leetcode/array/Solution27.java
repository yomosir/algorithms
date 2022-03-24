package leetcode.array;

/**
 * @author zhengguochun
 * @description
 * @date 2022/3/24 5:15 PM
 **/
public class Solution27 {

    private static int search(int[]nums, int val){
        int slowIndex = 0;
        int len = nums.length;
        for (int fastIndex = 0; fastIndex < len; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {

    }
}
