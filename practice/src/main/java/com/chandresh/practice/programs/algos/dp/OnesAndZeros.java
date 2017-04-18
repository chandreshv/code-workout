package com.chandresh.practice.programs.algos.dp;

public class OnesAndZeros {

	public int findMaxForm(String[] strs, int m, int n) {
	    int[][] max = new int[m + 1][n + 1];
	    for (int i = 0; i < strs.length; i++) {
	        String str = strs[i];
	        
	        int neededZero = 0;
	        int neededOne = 0;
	        for (int j = 0; j < str.length(); j++) {
	            if (str.charAt(j) == '0') {
	                neededZero++;
	            } else {
	                neededOne++;
	            }
	        }
	        
	        int[][] newMax = new int[m + 1][n + 1];
	        
	        for (int zero = 0; zero <= m; zero++) {
	            for (int one = 0; one <= n; one++) {
	                if (zero >= neededZero && one >= neededOne) {
	                    int zeroLeft = zero - neededZero;
	                    int oneLeft = one - neededOne;
	                    if(1 + max[zeroLeft][oneLeft]< max[zero][one])
	                    	System.out.println("Pakda");
	                    newMax[zero][one] = Math.max(1 + max[zeroLeft][oneLeft], max[zero][one]);
	                } else {
	                    newMax[zero][one] = max[zero][one];
	                }
	            }
	        }
	        
	        max = newMax;
	    }
	    return max[m][n];
	}
	
	public static void main(String args[]){
		
		/*String[] strs = {"10", "0001", "111001", "1", "0"};
		int m=5,n=3;
		
		System.out.println(new OnesAndZeros().findMaxForm(strs, m, n));*/
		
		System.out.println(new OnesAndZeros().isSubsequence("leeet", "ylyeyeytycyoydyey"));
	}
	
	    public boolean isSubsequence(String s, String t) {
	        
	        if(s==null || t==null)
	            return false;
	        
	        int[][] dp = new int[s.length()+1][t.length()+1];
	        
	        for(int i=1;i<=s.length();i++){
	            for(int j=1;j<=t.length();j++){
	                boolean isFound = false;
	                int temp = 0;
	                if(s.charAt(i-1)==t.charAt(j-1) && !isFound && j>=i){
	                    temp=1;
	                    isFound = true;
	                }
	                dp[i][j] = Math.max(dp[i][j-1], temp+dp[i-1][j]);
	            }
	        }
	        for(int[] i:dp){
	        	for(int j:i)
	        	System.out.print(j +" ");
	        System.out.println(" ");	
	        }
	        if(dp[s.length()][t.length()]==s.length())
	            return true;
	        
	        return false;
	        
	    }
}
