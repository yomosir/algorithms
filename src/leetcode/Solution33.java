package leetcode;

/**
 * project:algorithms
 * author:zhengguocchun
 * date:2018/12/19
 */
public class Solution33 {
    public static int search(int[] nums, int target) {
        int first = 0;
        int n = nums.length;
        int last = n;
        while(last != first){
            int mid = (last + first) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[first]){
                if(target >= nums[first] && target <= nums[mid]){
                    last = mid;
                }else{
                    first = mid;
                }
            }else{
                if(target >= nums[mid] && target <= nums[last - 1]){
                    first = mid;
                } else{
                    last = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int [] arr = {4,5,6,7,0,1,2} ;
        int target = 0;
        System.out.println(search(arr,target));
    }
}
