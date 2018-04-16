package com.packt.datastructuresandalg.lesson3.binarytree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SimpleBinaryTree<K, V> implements BinaryTree<K, V> {
    protected BinaryTreeNode<K, V> root;

    public void put(K key, V value) {
        if (root == null)
            root = new BinaryTreeNode<>(key, value);
        else
            put(key, value, root);
    }

    private void put(K key, V value, BinaryTreeNode<K, V> node) {
        if (((Comparable) key).compareTo(node.getKey()) == 0) {
            node.setKey(key);
            node.setValue(value);
        } else if (((Comparable) key).compareTo(node.getKey()) < 0) {
            if (node.getLeft().isPresent())
                put(key, value, node.getLeft().get());
            else
                node.setLeft(new BinaryTreeNode<>(key, value));
        } else {
            if (node.getRight().isPresent())
                put(key, value, node.getRight().get());
            else
                node.setRight(new BinaryTreeNode<>(key, value));
        }
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(root).flatMap(n -> get(key, n));
    }

    private Optional<V> get(K key, BinaryTreeNode<K, V> node) {
        if (((Comparable) key).compareTo(node.getKey()) == 0)
            return Optional.of(node.getValue());
        else if (((Comparable) key).compareTo(node.getKey()) < 0)
            return node.getLeft().flatMap(n -> get(key, n));
        else
            return node.getRight().flatMap(n -> get(key, n));
    }

    public void leftRotate(BinaryTreeNode<K, V> nodeX,
                           BinaryTreeNode<K, V> parent) {
        BinaryTreeNode<K, V> nodeY = nodeX.getRight().get();
        nodeX.setRight(nodeY.getLeft().orElse(null));
        if (parent == null)
            this.root = nodeY;
        else if (parent.getLeft().filter(n -> n == nodeX).isPresent())
            parent.setLeft(nodeY);
        else
            parent.setRight(nodeY);
        nodeY.setLeft(nodeX);
    }

    public void rightRotate(BinaryTreeNode<K, V> nodeX,
                           BinaryTreeNode<K, V> parent) {
        BinaryTreeNode<K, V> nodeY = nodeX.getLeft().get();
        nodeX.setLeft(nodeY.getRight().orElse(null));
        if (parent == null)
            this.root = nodeY;
        else if (parent.getRight().filter(n -> n == nodeX).isPresent())
            parent.setRight(nodeY);
        else
            parent.setLeft(nodeY);
        nodeY.setRight(nodeX);
    }


    public Optional<K> minKey() {
        return Optional.ofNullable(root).map(this::minKey);
    }

    protected K minKey(BinaryTreeNode<K, V> node) {
        return node.getLeft().map(this::minKey).orElse(node.getKey());
    }

    public void printBfs() {
        Optional.ofNullable(root).ifPresent(r -> {
            Queue<BinaryTreeNode<K, V>> queue = new LinkedList<>();
            queue.add(r);
            while (!queue.isEmpty()) {
                BinaryTreeNode<K, V> node = queue.remove();
                System.out.println(node.getKey());
                node.getLeft().ifPresent(queue::add);
                node.getRight().ifPresent(queue::add);
            }
        });
    }


    public void printDfs() {
        Optional.ofNullable(root).ifPresent(this::printDfs);
    }

    private void printDfs(BinaryTreeNode<K, V> node) {
        //System.out.println("PREORDER " + node.getKey());
        node.getLeft().ifPresent(this::printDfs);
        System.out.println("INORDER " + node.getKey());
        node.getRight().ifPresent(this::printDfs);
        //System.out.println("POSTORDER " + node.getKey());
    }


    public static void main(String[] args) {
        SimpleBinaryTree<Integer, String> binaryTree = new SimpleBinaryTree<Integer, String>();
        System.out.println(binaryTree.minKey());
        binaryTree.put(457998224, "Isabel");
        binaryTree.put(366112467, "John");
        binaryTree.put(671031776, "Ruth");
        binaryTree.put(225198452, "Sarah");
        binaryTree.put(419274013, "Peter");
        binaryTree.put(751965387, "Tom");

        System.out.println(binaryTree.get(457998224));
        System.out.println(binaryTree.get(366112467));
        System.out.println(binaryTree.get(671031776));
        System.out.println(binaryTree.get(225198452));
        System.out.println(binaryTree.get(419274013));
        System.out.println(binaryTree.get(751965387));

        binaryTree.put(751965387, "Sam");

        System.out.println(binaryTree.get(751965387));
        System.out.println(binaryTree.get(999999999));
        System.out.println(binaryTree.minKey());

        binaryTree.printDfs();
        binaryTree.printBfs();
    }
}
