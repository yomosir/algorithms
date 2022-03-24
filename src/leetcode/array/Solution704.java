package leetcode.array;

/**
 * @author zhengguochun
 * @description
 * @date 2022/3/24 4:55 PM
 **/
public class Solution704 {
    // 二分法条件：有序，无重复数据

    private static int searchV1(int [] array, int target){
        int size = array.length;
        if (target < array[0] || target > array[size - 1]){
            return -1;
        }
        int middle = size >> 1;
        // 边界
        while(middle >= 0 && middle < size){
            if (array[middle] == target){
                return middle;
            }else if (array[middle] > target){
                middle = middle >> 1;
            }else{
                middle = middle + ((size - middle) >> 1);
            }
        }
        return -1;
    }

    private static int searchV2(int [] array, int target){
        int left = 0;
        // 定义target在左闭右开的区间里，即：[left, right)
        int right = array.length;
        // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target) {
                // target 在左区间，在[left, middle)中
                right = middle;
            } else if (array[middle] < target) {
                // target 在右区间，在[middle + 1, right)中
                left = middle + 1;
            } else { // nums[middle] == target
                // 数组中找到目标值，直接返回下标
                return middle;
            }
        }
        // 未找到目标值
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7};
        System.out.println(searchV1(array, 7));
    }
}
