package com.chandresh.practice.programs.ds.tree;

public class MedianCalculator {

	
	public double findMedian(int[] nums1, int[] nums2){
		if((nums1==null || nums1.length==0) &&
				(nums2==null || nums2.length==0))
			return -1;
		
		if(nums1==null || nums1.length==0)
			return (double)(nums2[(nums2.length-1)/2]+nums2[nums2.length/2])/2;
		
		if(nums2==null || nums2.length==0)
			return (double)(nums1[(nums1.length-1)/2]+nums1[nums1.length/2])/2;
		
		int lenA = nums1.length, lenB = nums2.length;
		if(lenA>lenB)
			return findMedian(nums2, nums1);
		if(lenA==1 && lenB==1)
			return (double)(nums1[0]+nums2[0])/2;
		
		if(lenA==1){
			if(lenB%2==0){
				if(nums2[(nums2.length-1)/2]<=nums1[0] && nums2[(nums2.length)/2]>nums1[0])
					return nums1[0];
				if(nums2[(nums2.length-1)/2]>nums1[0])
					return nums2[(nums2.length-1)/2];
				if(nums2[(nums2.length)/2]<nums1[0])
					return nums2[(nums2.length)/2];
			}else{
				if((nums2[nums2.length/2]>nums1[0] && nums2[(nums2.length/2)-1]<nums1[0])
						|| (nums2[nums2.length/2]<nums1[0] && nums2[(nums2.length/2)+1]>nums1[0]))
					return (double)((nums2[nums2.length/2] + nums1[0])/2);
				
				if(nums2[(nums2.length/2)-1]>nums1[0])
						return (double)((nums2[nums2.length/2] + nums2[(nums2.length/2)-1])/2);
				
				if(nums2[(nums2.length/2)+1]<nums1[0])
					return (double)((nums2[nums2.length/2] + nums2[(nums2.length/2)+1])/2);
			}
				
		}
		int lo=1, hi=nums1.length;
		
		while(hi>=lo){
			int midA = lo+((hi-lo)/2);
			int midB = ((lenA+lenB)/2)-midA;
			double LA,LB,RA,RB;
			if(midA==0){
				LA=Integer.MIN_VALUE;
				LB=nums2[(lenA+lenB)/2-1];
			}else if(midB==0){
				LA=nums1[(lenA+lenB)/2-1];
				LB=Integer.MIN_VALUE;
			}else{
				LA=nums1[midA-1];
				LB=nums2[midB-1];
			}
			
			if(midA==lenA){
				RA=Integer.MAX_VALUE;
				RB=nums2[nums2.length-1-((lenA+lenB)/2-1)];
			}else if(midB==lenB){
				RA=nums1[nums1.length-1-((lenA+lenB)/2-1)];
				RB=Integer.MAX_VALUE;
			}else{
				RA= (lenA%2==0)?nums1[midA]:nums1[midA-1];
				RB= (lenB%2==0)?nums2[midB]:nums2[midB-1];
			}
				
			if(LA>RB)
				hi=midA-1;
			else if(LB>RA)
				lo=midA+1;
			else{
				return (Math.max(LA, LB)+Math.min(RA, RB))/2;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] a= {1};
		int[] b={1};
		System.out.println(new MedianCalculator().findMedian(a, b));
	}
}
