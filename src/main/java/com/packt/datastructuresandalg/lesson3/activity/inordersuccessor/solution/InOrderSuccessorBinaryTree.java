package com.packt.datastructuresandalg.lesson3.activity.inordersuccessor.solution;

import com.packt.datastructuresandalg.lesson3.binarytree.BinaryTreeNode;
import com.packt.datastructuresandalg.lesson3.binarytree.SimpleBinaryTree;

import java.util.Optional;

public class InOrderSuccessorBinaryTree<K, V> extends SimpleBinaryTree<K, V> {
    public Optional<K> inOrderSuccessorKey(K key) {
        Optional<BinaryTreeNode<K, V>> node = Optional.ofNullable(root);
        Optional<K> successor = Optional.empty();
        while (node.isPresent() && !node.get().getKey().equals(key)) {
            if (((Comparable) node.get().getKey()).compareTo(key) > 0) {
                successor = node.map(BinaryTreeNode::getKey);
                node = node.flatMap(BinaryTreeNode::getLeft);
            } else
                node = node.flatMap(BinaryTreeNode::getRight);
        }

        return node.flatMap(BinaryTreeNode::getRight).map(this::minKey)
                .map(Optional::of).orElse(successor);
    }
}
