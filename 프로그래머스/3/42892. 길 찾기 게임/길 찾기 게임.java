import java.util.*;

class Solution {
    
    // 노드 클래스
    class Node {
        int x, y, idx;
        Node left, right;
        
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        // 리스트 삽입
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        
        // y 내림차순 - x 오름차순
        list.sort((a, b) -> {
            if (a.y == b.y) return Integer.compare(a.x, b.x);
            return Integer.compare(b.y, a.y);
        });
        
        // 루트 노드 구하고 BST 트리 만들기
        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++) insert(root, list.get(i));
        
        // 전위순회, 후위순회
        List<Integer> preorderResult = new ArrayList<>();
        List<Integer> postorderResult = new ArrayList<>();
        
        preorder(root, preorderResult);
        postorder(root, postorderResult);
        
        int[][] answer = new int[2][n];
        
        for(int i = 0; i < n; i++) {
            answer[0][i] = preorderResult.get(i);
            answer[1][i] = postorderResult.get(i);
        }
        
        return answer;
    }
    
    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    void preorder(Node node, List<Integer> res) {
        if (node == null) return;
        
        res.add(node.idx);
        preorder(node.left, res);
        preorder(node.right, res);
    }
    
    void postorder(Node node, List<Integer> res) {
        if (node == null) return;
        
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.idx);
    }
}