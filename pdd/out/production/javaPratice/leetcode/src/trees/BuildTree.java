package trees;

import java.util.*;

public class BuildTree {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder,
        int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }


    public static void main(String[] args) {
        int[] inorder = new int[]{3,9,20,15,7};
        int[] postorder = {9,3,15,20,7};
        BuildTree bt = new BuildTree();
//        TreeNode node = bt.buildTree(inorder, postorder);
        String s = "a,b,c,d,e,f,#,a,s,d";
        System.out.println(Arrays.toString(s.split(",")));
        Queue<String> queue = new LinkedList<>(Arrays.asList(s.split(",")));
        while (!queue.isEmpty()){
        String q = queue.poll();
        if (q.equals("#"))
            System.out.println("found it");
        }
    }
}
