package shuati;

public class Flatten {
    TreeNode pre  = null;
    public static void flatten(TreeNode root) {
        if(root == null ) return;
        flatten(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
        flatten(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node = TreeNode.createBiTree(node, new int[]{1,2,3,0,0,4,0,0,5,0,6},TreeNode.counter);
//        System.out.println(node);
        flatten(node);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    static int counter = 0;//定义一个静态计数变量
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
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
}