package Lei;


import java.util.LinkedList;
import java.util.Queue;

//定义一个节点
class BitNode {
    int data;
    BitNode lchild;
    BitNode rchild;

    public void setNode(int data, BitNode lc, BitNode rc) {
        this.data = data;
        lchild = lc;
        rchild = rc;
    }


    static int counter = 0;//定义一个静态计数变量

    /**
     * 构造二叉树
     *
     * @param root根节点
     * @param a数据源
     * @param i计数器
     * @return 根节点
     */
    public static BitNode createBiTree(BitNode root, int[] a, int i) {
        if (i < a.length) {
            if (a[i] == 0) {
                root = null;
            } else {
                BitNode lchild = new BitNode();
                BitNode rchild = new BitNode();
                root.data = a[i];
                root.lchild = createBiTree(lchild, a, ++counter);
                root.rchild = createBiTree(rchild, a, ++counter);
            }
        }
        return root;
    }

    // 访问节点
    public static void visitTNode(BitNode node) {
        System.out.print(node.data + " ");
    }

    // 层次遍历
    public static void levelTraverse(BitNode root) {
        Queue<BitNode> queue = new LinkedList<BitNode>();
        queue.offer(root);// 从根节点入队列
        while (!queue.isEmpty()) {// 在队列为空前反复迭代
            BitNode bitNode = queue.poll();// 取出队列首节点
            visitTNode(bitNode);
            if (bitNode.lchild != null)
                queue.offer(bitNode.lchild);// 左孩子入列
            if (bitNode.rchild != null)
                queue.offer(bitNode.rchild);// 右孩子入列
        }
    }

    public static void main(String[] args) {
        BitNode root = new BitNode();
//        int[] a = { 1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
        int[] a = {1,2,4,0,0,0,3,2,4,0,0,0,4,0,0};
        root = createBiTree(root, a, counter);
        levelTraverse(root);

    }
}
