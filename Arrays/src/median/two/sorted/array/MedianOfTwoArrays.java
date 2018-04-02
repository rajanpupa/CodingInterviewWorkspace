package median.two.sorted.array;

/*
 * if total length is odd, the n/2th element is the median
 * if total length is even, average of n/2th element and n/2 -1 th element is the median
 */
public class MedianOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {1,2,3,4};
		
		MedianOfTwoArrays mta = new MedianOfTwoArrays();
		
		double median = mta.findMedianSortedArrays(nums1, nums2);
		
		System.out.println(median);
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tlen = nums1.length + nums2.length;
        
        if(tlen==1){
            return nums1.length > 0 ? nums1[0] : nums2[0];
        }
                
        int i1=0, i2=0, i=0;
                
        for(; i1<nums1.length && i2 < nums2.length && i<tlen/2 -1; i++){
            if(nums1[i1]<nums2[i2]) i1++;
            else i2++;
        }
        
        if( (i1+i2) < tlen/2 -1 ){
            while(i1< nums1.length && i< tlen/2 -1 ){
                i++;
                i1++;
            }
            while(i2< nums2.length && i< tlen/2 -1 ){
                i++;
                i2++;
            }
        }
        
        System.out.printf("tlen=%d, i=%d, i1=%d, i2=%d \n",tlen, i, i1, i2);
        
       int [] lohi= new int[2];
        
       for(int j=0; j<2; j++){
           if(i1<nums1.length && i2 < nums2.length){
               lohi[j] = nums1[i1]<nums2[i2]?nums1[i1++]:nums2[i2++];
           }else if(i1>=nums1.length){
               lohi[j] = nums2[i2++];
           }else{
               lohi[j] = nums1[i1++];
           }
       }
        
        if(tlen %2 == 0){
            return (lohi[0] + lohi[1])/2.0;
        }else{
            return lohi[1];
        }
    }
}
