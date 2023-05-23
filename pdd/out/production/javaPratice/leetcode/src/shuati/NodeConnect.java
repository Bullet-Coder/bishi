package shuati;

import Lei.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//填充每个节点的下一个右侧节点指针
class NodeConnect {
    public TreeNode connect(TreeNode root){
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(i < size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] data = {1,2,3,4,5,6,7};
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left.val = 2;
        node.right.val = 3;
        node.left.left.val = 4;
        node.left.right.val = 5;
        node.right.left.val = 6;
        node.right.left.val = 7;
        NodeConnect nc = new NodeConnect();
        TreeNode ans = nc.connect(node);
        System.out.println(ans);
    }
}
