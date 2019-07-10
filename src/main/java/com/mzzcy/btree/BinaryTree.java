package com.mzzcy.btree;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 二叉排序树的生成
 * 求各个节点的深度
 * 求树的深度
 * 先中后序遍历 递归 非递归
 * 层次遍历
 *
 *
 * @author changyin.zhao on 7/9/19
 */
public class BinaryTree {

    public static void main(String[] args) {
        Node root = new BinaryTree().genSortTree2();
        inorderRead2(root);
        //        inorderRead(root);
        //        System.out.println("depth is: " + queryDepth(root));
    }

    //随机生成二叉排序树
    public Node genSortTree() {
        Random random = new Random();
        Node root = new Node(15);

        for (int i = 0; i < 10; i++) {
            Node node = new Node(random.nextInt(100));
            add(root, node);
        }

        return root;
    }

    /**
     * 生成二叉排序树
     */
    public Node genSortTree2() {
        Node root = new Node(15);
        root.setDepth(1);

        Node node = new Node(10);
        add(root, node);
        node = new Node(12);
        add(root, node);
        node = new Node(9);
        add(root, node);
        node = new Node(8);
        add(root, node);
        node = new Node(20);
        add(root, node);
        node = new Node(18);
        add(root, node);
        node = new Node(21);
        add(root, node);
        node = new Node(22);
        add(root, node);

        return root;
    }

    public Node add(Node parent, Node node) {
        if (parent != null && node != null) {
            if (parent.getValue() == node.getValue()) {
                return parent;
            }

            if (parent.getValue() > node.getValue()) {
                if (parent.getLeft() == null) {
                    parent.setLeft(node);
                    //                    node.setDepth(parent.getDepth() + 1);
                } else {
                    add(parent.getLeft(), node);
                }
            } else {
                if (parent.getRight() == null) {
                    parent.setRight(node);
                    //                    node.setDepth(parent.getDepth() + 1);
                } else {
                    add(parent.getRight(), node);
                }
            }
        }
        return parent;
    }

    /**
     * 中序遍历
     */
    public static void inorderRead(Node parent) {
        if (parent == null) {
            return;
        }

        if (parent.getLeft() != null) {
            parent.getLeft().setDepth(parent.getDepth() + 1);
            inorderRead(parent.getLeft());
        }
        System.out.println(parent.getValue() + " depth->: " + parent.getDepth());

        if (parent.getRight() != null) {
            parent.getRight().setDepth(parent.getDepth() + 1);
            inorderRead(parent.getRight());
        }
    }

    /**
     * 中序遍历 -- 非递归
     */
    public static void inorderRead2(Node parent) {
        if (parent == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        pushStack(stack, parent);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.getValue());
            if (curNode.getRight() != null) {
                pushStack(stack, curNode.getRight());
            }
        }
    }

    public static void pushStack(Stack<Node> stack, Node node) {
        if (stack != null && node != null) {
            stack.add(node);
            while (node.getLeft() != null) {
                node = node.getLeft();
                stack.add(node);
            }
        }
    }

    /**
     * 层次遍历
     */
    public static void breadthRead(Node root) {
        if (root == null) {
            return;
        }

        System.out.println("********* start breadthRead *********");
        LinkedList<Node> nodeQueue = new LinkedList<>();
        //        root.setDepth(1);
        nodeQueue.add(root);

        while ((nodeQueue.peek()) != null) {
            Node node = nodeQueue.pop();
            int depth = node.getDepth() + 1;
            if (node.getLeft() != null) {
                //                node.getLeft().setDepth(depth);
                nodeQueue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                //                node.getRight().setDepth(depth);
                nodeQueue.add(node.getRight());
            }
            System.out.println(node.getValue() + " depth: " + node.getDepth());
        }
    }

    /**
     * 求节点的度
     */
    public static int queryDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.getLeft() != null) {
            left = queryDepth(root.getLeft());
        }
        int right = 0;
        if (root.getRight() != null) {
            right = queryDepth(root.getRight());
        }
        return left > right ? left + 1 : right + 1;
    }
}

@Setter
@Getter
@Builder
@AllArgsConstructor
class Node {
    private Node left;
    private Node right;
    private int value;
    private int depth;

    public Node(int value) {
        this.value = value;
    }
}