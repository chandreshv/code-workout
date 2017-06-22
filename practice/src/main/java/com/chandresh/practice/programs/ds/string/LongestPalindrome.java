package com.chandresh.practice.programs.ds.string;

public class LongestPalindrome {

	
	public static void main(String args[]){
		String inp = "gaa";
		
		System.out.println(findLongestPalindrome(inp));
	}

	private static String findLongestPalindrome(String inp) {
		if(inp==null)
			return null;
		
		int start=-1,end=-1;
		
		for(int i=0;i<inp.length();i++){
			int tempStart=-1,tempEnd=-1,j=i,k=inp.length()-1;
			
			while(j<=k){
				if(j==k){
					if(tempStart!=-1 && tempEnd!=-1 && (tempEnd-tempStart>end-start)){
						start=tempStart;
						end=tempEnd;
					}
					break;
				}
				if(inp.charAt(j)==inp.charAt(k)){
					if(tempStart==-1)
						tempStart=j;
					if(tempEnd==-1)
						tempEnd=k;
					j++;k--;
				}else{
					tempStart=-1;
					tempEnd=-1;
					k--;
				}
			}
			if(tempStart!=-1 && tempEnd!=-1 && (tempEnd-tempStart>end-start)){
				start=tempStart;
				end=tempEnd;
			}
		}
		
		if(start==-1 || end == -1)
			return String.valueOf(inp.charAt(0));
		return inp.substring(start, end+1);
	}
}
