package leetcode.array;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-30
 */
public class Solution581 {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0, 1, 2, 7, 4, 6, 3, 1, 5, 7}));
    }

    public static int solve(int[] nums){
        //从左往右找最后一个不满足单调递增的位置，它是无序区间的右边界
        int maxVal = Integer.MIN_VALUE;
        int to = -1;
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] < maxVal) to = i;
            maxVal = Math.max(nums[i], maxVal);
        }

        //从右往左找最前一个不满足单调递减的位置，它是无序区间的左边界
        int minVal = Integer.MAX_VALUE;
        int from = nums.length;
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] > minVal) from = i;
            minVal = Math.min(nums[i], minVal);
        }

        //如果完全有序
        if(to == -1) return 0;
        return to - from + 1;
    }
}
