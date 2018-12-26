package leetcode;

import java.util.Arrays;

/**
 * project:algorithms
 * author:zhengguocchun
 * date:2018/12/26
 */
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        System.out.println(total);
        if(total % 2 != 0){
            return find_kth(nums1,len1,nums2,len2,(total / 2) + 1);
        }else{
            System.out.println("12312");
            return (find_kth(nums1,len1,nums2,len2,total / 2) + find_kth(nums1,len1,nums2,len2,total / 2 + 1)) / 2;
        }
    }

    private static double find_kth(int []a ,int m,int[] b,int n,int k){
        System.out.println(k);
        if(m > n) return find_kth(b,n,a,m,k);
        if(m == 0) return b[k - 1];
        if(k == 1)return Math.min(a[0],b[0]);
        int pa = Math.min(k / 2,m),pb = k - pa;
        if(a[pa -1] < b[pb - 1])
            return find_kth(Arrays.copyOfRange(a,pa,m - 1),m - pa,b,n,k - pa);
        else if(a[pa -1] > b[pb - 1]) {
            System.out.println("asd" + pb);
            return find_kth(a, m, Arrays.copyOfRange(b, pb, n - 1), n - pb, k - pb);
        }else
            return a[pa -1];
    }

    public static void main(String [] args){
            int [] nums1 = {1,3};
            int [] nums2 = {2};
           System.out.println( findMedianSortedArrays(nums1,nums2));
    }
}
