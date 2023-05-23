package 队列和栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    public Node clone(Node node, HashMap<Integer, Node> visited) {
        if (node == null) return null;
        System.out.println(node.val);
        if (visited.containsKey(node.val)) {
            System.out.println(visited.get(node.val));
            return visited.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor, visited));
        return newNode;
    }


    public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    List<Node> ls1 = new ArrayList<>();
    List<Node> ls2 = new ArrayList<>();
    List<Node> ls3 = new ArrayList<>();
    List<Node> ls4 = new ArrayList<>();
    ls1.add(n2);
    ls1.add(n4);
    ls2.add(n1);
    ls2.add(n3);
    n1.neighbors = ls1;
    n2.neighbors = ls2;
    n3.neighbors = ls1;
    n4.neighbors = ls2;
    CloneGraph cg = new CloneGraph();
    Node n = cg.cloneGraph(n1);
    System.out.println(n);
    }
}