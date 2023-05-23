package Lei;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    static int counter = 0;//定义一个静态计数变量
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode(){}
    public TreeNode(int val){this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }


    public void setlChild(TreeNode lChild) {
        this.left = lChild;
    }


    public void setrChild(TreeNode rChild) {
        this.right = rChild;
    }


    public static TreeNode createBiTree(TreeNode root, int[] a, int i) {
        if (i < a.length) {
            if (a[i] == 0) {
                root = null;
            } else {
                TreeNode lchild = new TreeNode();
                TreeNode rchild = new TreeNode();
                root.val = a[i];
                root.left = createBiTree(lchild, a, ++counter);
                root.right = createBiTree(rchild, a, ++counter);
            }
        }
        return root;
    }


    public static void levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);// 从根节点入队列
        while (!queue.isEmpty()) {// 在队列为空前反复迭代
            TreeNode bitNode = queue.poll();// 取出队列首节点
            if (bitNode.left != null)
                queue.offer(bitNode.left);// 左孩子入列
            if (bitNode.right != null)
                queue.offer(bitNode.right);// 右孩子入列
        }
    }

}
