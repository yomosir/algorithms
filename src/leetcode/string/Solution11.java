package leetcode.string;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-29
 */
public class Solution11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int maxArea = 0;
        int minPos = 0;
        int minVal = 0;
        while(i < j){
            // 去比较小的位置和比较小的值
            if (height[i] < height[j]){
                minPos = i;
                minVal = height[i];
            }else{
                minPos = j;
                minVal = height[j];
            }
            int area = (j - i + 1) * minVal;
            // 取较大的面积
            maxArea = Math.max(area, maxArea);
            // 如果移动后的位置比较小的高度高，则可以计算，否则
            if (minPos == i){
                // move i
                i++;
            }else{
                // move j
                j--;
            }
        }
        return maxArea;
    }
}
