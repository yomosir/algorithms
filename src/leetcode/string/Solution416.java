package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengguochun
 * @description
 * @date 2022-04-03
 */
public class Solution416 {
    public static void main(String[] args) {
        canPartition(new int[]{14, 9, 8, 4, 3, 2});
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num: nums){
            sum += num;
        }
        // 如果和不能除以二，则不可能拆分成两个值相等的数组
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        // 使用前缀和的概念
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++){
            prefixSum += nums[i];
            // 如果前缀和中存在等于一般的
            if (null != map.get(prefixSum - target)){
                return true;
            }
            map.put(prefixSum, 1);
        }
        return false;
    }
}
