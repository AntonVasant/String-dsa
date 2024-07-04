package array;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int mid  = length/2;
        double current=0;
        double prev =0;
        int index1=0;
        int index2=0;
        boolean isEven = length%2==0;
        for(int i=0;i<=mid;i++){
            prev=current;
            if((index1 < nums1.length) && (index2>=nums2.length || nums1[index1] < nums2[index2])){
                current = nums1[index1++];
            }else{
                current = nums2[index2++];
            }
        }
        if(isEven){
            return (current+prev)/2;
        }else{
            return current;
        }
    }
}
