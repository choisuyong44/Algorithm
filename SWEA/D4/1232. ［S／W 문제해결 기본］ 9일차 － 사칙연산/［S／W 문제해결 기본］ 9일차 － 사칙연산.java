import java.io.*;
import java.util.*;

public class Solution {
	
	static class Node{
		boolean isOp; // 나 자신이 연산자인지 -> 연산자라면 재귀 호출
		int num;	  // 나 자신의 번호
		String op;
		int left;
		int right;
	}
	
	static Node root;
	static int N;
	static Map<Integer,Node> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = 10;
		for(int T = 1; T<TC+1;T++) {
			int N = Integer.parseInt(br.readLine());
			
			map = new HashMap<Integer, Node>(); // 빈 맵을 하나 생성
			
			for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Node());
                String token = st.nextToken();
                if (isOp(token)) {
                    map.get(num).isOp = true;
                    map.get(num).op = token;
                    map.get(num).left = Integer.parseInt(st.nextToken());
                    map.get(num).right = Integer.parseInt(st.nextToken());
                } else {
                    map.get(num).isOp = false;
                    map.get(num).num = Integer.parseInt(token);
                }
            }
			System.out.println("#"+T+" "+inorder(1));
		}
	}
	
    private static int inorder(int i) {
        int lft = 2*i;
        int rgt = 2*i + 1;
         
        Node n = map.get(i);
         
        if(n.isOp) {
            if(n.op.equals("+")) {
                return inorder(n.left) + inorder(n.right);
            } else if(n.op.equals("-")) {
                return inorder(n.left) - inorder(n.right);
            }else if(n.op.equals("*")) {
                return inorder(n.left) * inorder(n.right);
            }else if(n.op.equals("/")) {
                return inorder(n.left) / inorder(n.right);
            }
        } 
         
        return n.num;
    }
 
	
    private static boolean isOp(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            return true;
 
        return false;
    }
}