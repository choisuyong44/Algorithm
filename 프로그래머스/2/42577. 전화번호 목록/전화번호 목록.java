import java.io.*;
import java.util.*;

class Node{
    Map<Character,Node> child;
    boolean isTerminal;
    Node(){
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie{
    Node root;
    
    Trie(){
        this.root = new Node();
    }
    
    public void insert(String str){
        Node cur = root;
        
        for(int i =0;i<str.length();i++){
            char c= str.charAt(i);
            
            // 자식이 없다면 생성
            if(!cur.child.containsKey(c)){
                cur.child.put(c,new Node());
            }
            
            // 자식으로 이동
            cur = cur.child.get(c);
            
            // 내가 마지막 자식이라면
            if(i==str.length()-1){
                cur.isTerminal = true;
            }
        }
    }
    
    public boolean search(String str){
        Node cur = this.root;
        
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            
            
            // 존재하면 계속 아래로 내려감
            // 자기 자신이 있으므로 무조건 존재할 수 밖에 없다고 가정
            if(cur.child.containsKey(c)){
                cur = cur.child.get(c);
            }
            
            // 내가 마지막이면 stop
            if(i==str.length()-1){
                if(cur.child.size()>0) return true;
                return false;
            }
        }
        
        return false;
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        
        for(String phone : phone_book){
            trie.insert(phone);
        }
        
        for(String phone : phone_book){
            if(trie.search(phone)){
                return false;
            }
        }
        
        return answer;
    }
}