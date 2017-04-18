package com.chandresh.practice.programs.algos.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }
    
public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
            	System.out.println("Substring to be tested " + s.substring(j, i)+ " value of i and j is "+ i +" "+j);
                if(f[j] && dict.contains(s.substring(j, i))){
                	System.out.println("Substring passed " + s.substring(j, i));
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
    
    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)){
    // try every unchosen number as next step
            for(int i=1; i<used.length; i++){
                if(!used[i]){
                    used[i] = true;
     // check whether this lead to a win (i.e. the other player lose)
                    if(!helper(desiredTotal-i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
   
// transfer boolean[] to an Integer 
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
    
    public static void main(String[] args){
    	Set<String> dict = new HashSet<String>();
    	dict.add("re");
    	dict.add("ret");
    	System.out.println(new Solution().wordBreak("ret", dict));
    }
}