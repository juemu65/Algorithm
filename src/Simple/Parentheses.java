package Simple;

import java.util.*;

public class Parentheses {
//20.有效括号
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。


    public boolean isValidParentheses(String s) {

        char[] chs=s.toCharArray();
        int cur=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch (c){
                case '(':
                case '[':
                case '{':chs[cur++]=c; break;

                case ')':if(cur==0) return false;
                    char c1=chs[--cur];if(c1!='(') return false;break;
                case ']':if(cur==0) return false;
                    char c2=chs[--cur];if(c2!='[') return false;break;
                case '}':if(cur==0) return false;
                    char c3=chs[--cur];if(c3!='{') return false;break;
            }
        }
        if(cur!=0){
            return false;
        }
        return true;
    }
}
