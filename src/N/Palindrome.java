package N;

public class Palindrome {
/*
* 5.最长回文子串
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
*
* */
public String longestPalindrome(String s) {
    if(s.length()<2) return s;
    int n=s.length();
    int start=0, end=0;
    for(int i=0;i<n;i++){
        int len1=expandAroundCenter(s,i,i);
        int len2=expandAroundCenter(s,i,i+1);
        int len=Math.max(len1, len2);
        if(end-start<len) {
            start=i-(len-1)/2;
            end=i+len/2;
        }
    }

    return s.substring(start,end+1);
}
    public static int expandAroundCenter(String s,int left,int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)) {
            left--;right++;
        }
        return right-left-1;
    }



    /*
    9. 回文数
    //整数转为字符串
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());

//

     */
}
