import java.util.*;

class Solution {
    static Stack<Character> stack = new Stack();
    
    boolean solution(String s) {
        boolean answer = true;
        
        char c;
        for(int i =0;i<s.length();i++){
            c = s.charAt(i);
            if(c =='('){
                // 여기서 조심 마지막이 아님을 보장해야함
                if(i != s.length()-1 && s.charAt(i+1)==')'){
                    i++;
                    continue;
                }
                
                else{
                    stack.push('(');
                }
            }
            
            else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}