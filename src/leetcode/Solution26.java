package leetcode;

import java.util.Arrays;

/*Given a sorted array, remove the duplicates in place such that each element appear only
        once and return the new length.
        Do not allocate extra space for another array, you must do this in place with constant memory.
        For example, Given input array A = [1,1,2],
        Your function should return length = 2, and A is now [1,2].*/
public class Solution26 {
  public static int removeDuplicates(int[] nums) {
      //将不一样的数据一次移动到数组的最前面
      if (nums.length == 0 || nums == null)
          return 0;
      int index = 0;
      int n = nums.length;
      for (int i = 1; i < n; i++) {
          if (nums[index] != nums[i])
              nums[++index] = nums[i];
      }

      //System.out.println(Arrays.toString(nums));
      return index + 1;
  }
  public static void main(String [] args){
        int [] arr = {0,0,1,1,1,2,2,3,3,4};
        int len = Solution26.removeDuplicates(arr);
        System.out.println(len);
  }
}
