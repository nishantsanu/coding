package javaProjects;

import java.util.*;
import java.io.*;



public class helloworld {
	
	public static String[] keypad(int n){
		// Write your code here
	if(n==0){
          String[] a={""};
          return a;
        }
      int r=n%10;
      String[] smallans=keypad(n/10);
      String word=getOptions(r);
      String[] ans=new String[word.length()*smallans.length];
      int j=0;
      for(int i=0;i<word.length();i++){
        for(int k=0;k<smallans.length;k++){
          ans[j]=smallans[k]+word.charAt(i);
          j++;
}
	}
      return ans;
    }
  public static String getOptions(int digit) {

		//		if(digit == 2) {
		//			return "abc";
		//		}else if(digit == 3) {
		//			return "def";
		//		}
		String ans = "";
		switch(digit) {
		case 2:
			ans = "abc";
			break;
		case 3:
			ans =  "def";
			break;
		case 4:
			ans = "ghi";
			break;
          case 5:
            ans = "jkl";
            break;
          case 6:
            ans ="mno";
            break;
          case 7:
            ans="pqrs";
            break;
          case 8:
            ans="tuv";
            break;
          case 9:
            ans="wxyz";
            break;
		default:
			ans = "";
		}
		return ans;
	
	}
}