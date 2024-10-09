import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static class Node {
		int num;
		Node left, right;

		Node(int num) {
			this.num = num;
		}

		Node(int num, Node left, Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}

		void insert(int n) {
			// 현재 노드보다 작으면 왼쪽 서브트리로
			if (n < this.num) { 
				if (this.left == null)
					this.left = new Node(n);
				else
					this.left.insert(n);
			} 
			// 현재 노드보다 크면 오른쪽 서브트리로
			else { 
				if (this.right == null)
					this.right = new Node(n);
				else
					this.right.insert(n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		String s;
		while (true) {
			s = br.readLine();
			if (s == null || s.equals(""))
				break;
			root.insert(Integer.parseInt(s));
		}
		postOrder(root);
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
}