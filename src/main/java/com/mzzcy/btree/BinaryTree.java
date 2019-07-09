package com.mzzcy.btree;

import java.util.LinkedList;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author changyin.zhao on 7/9/19
 */
public class BinaryTree {

    public static void main(String[] args) {
        Node root = new BinaryTree().genSortTree2();
        breadthRead(root);
    }

    public Node genSortTree() {
        Random random = new Random();
        Node root = new Node(null, null, 15);

        for (int i = 0; i < 10; i++) {
            Node node = new Node(null, null, random.nextInt(100));
            add(root, node);
        }

        return root;
    }

    public Node genSortTree2() {
        Random random = new Random();
        Node root = new Node(null, null, 15);

        Node node = new Node(null, null, 10);
        add(root, node);
        node = new Node(null, null, 12);
        add(root, node);
        node = new Node(null, null, 9);
        add(root, node);
        node = new Node(null, null, 8);
        add(root, node);
        node = new Node(null, null, 20);
        add(root, node);
        node = new Node(null, null, 18);
        add(root, node);
        node = new Node(null, null, 21);
        add(root, node);
        node = new Node(null, null, 22);
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
                } else {
                    add(parent.getLeft(), node);
                }
            } else {
                if (parent.getRight() == null) {
                    parent.setRight(node);
                } else {
                    add(parent.getRight(), node);
                }
            }
        }
        return parent;
    }

    public static void inorderRead(Node parent) {
        if (parent == null) {
            return;
        }

        if (parent.getLeft() != null) {
            inorderRead(parent.getLeft());
        }
        System.out.println(parent.getValue());

        if (parent.getRight() != null) {
            inorderRead(parent.getRight());
        }
    }

    public static void breadthRead(Node root) {
        if (root == null) {
            return;
        }

        System.out.println("********* start breadthRead *********");
        LinkedList<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while ((nodeQueue.peek()) != null) {
            Node node = nodeQueue.pop();
            if (node.getLeft() != null) {
                nodeQueue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodeQueue.add(node.getRight());
            }
            System.out.println(node.getValue());
        }
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
}