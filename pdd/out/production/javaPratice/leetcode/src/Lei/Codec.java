package Lei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    public static TreeNode dfs(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.createBiTree(node, new int[]{1,2,0,0,3,4,0,0,5,0,0}, TreeNode.counter);
        String s = serialize(node);
        deserialize(s);
    }
}
