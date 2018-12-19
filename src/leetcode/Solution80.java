package leetcode;

/**
 * project:algorithms
 * @author:zhengguocchun
 * date:2018/12/19
 */
public class Solution80 {
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int index = 0;
        for(int i = 0 ;i < n;i++){
            if(i > 0 && i < n -1 && nums[i - 1] == nums[i] && nums[i] == nums[i + 1])
                continue;

            nums[index++] = nums[i];
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int index = 0;
        int occur = 1;
        for(int i = 1;i < n;i++){
            if(nums[index] == nums[i]){
                if(occur < 2){
                    nums[++index] = nums[i];
                    occur++;
                }
            }else{
                occur = 1;
                nums[++index] = nums[i];
            }

        }
        return index + 1;
    }
}
