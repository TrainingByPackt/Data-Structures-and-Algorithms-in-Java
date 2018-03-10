package com.packt.datastructuresandalg.lesson4.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    static class Node {
        public Node left;
        public Node right;
        public Integer frequency;
        public Character character;

        public Node() {
            left = right = null;
            frequency = 0;
            character = null;
        }
    }

    Node build(Map<Character, Integer> frequencies) {
        int N = frequencies.size();
        PriorityQueue<Node> pq = new PriorityQueue<>(N,
                (o1, o2) -> Integer.signum(o1.frequency - o2.frequency));
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            Node n = new Node();
            n.character = entry.getKey();
            n.frequency = entry.getValue();
            pq.add(n);
        }
        for (int i = 0; i < N - 1; i++) {
            Node n = new Node();
            n.left = pq.remove();
            n.right = pq.remove();
            n.frequency = n.left.frequency + n.right.frequency;
            pq.add(n);
        }
        return pq.remove();
    }

    public static String decode(String encoding, Node current, Node code, String s) {
        if (current.character != null)
            return decode(encoding, code, code, s + current.character);
        if (encoding.isEmpty())
            return s;
        if (encoding.charAt(0) == '0')
            return decode(encoding.substring(1), current.left, code, s);
        return decode(encoding.substring(1), current.right, code, s);
    }

    public static String decode(String encoding, Node code) {
        return decode(encoding, code, code, "");
    }

    public static void main(String[] args) {
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put('a', 45000);
        frequencies.put('b', 13000);
        frequencies.put('c', 12000);
        frequencies.put('d', 16000);
        frequencies.put('e', 9000);
        frequencies.put('f', 5000);

        Huffman huffman = new Huffman();
        Node code = huffman.build(frequencies);

        System.out.println(Huffman.decode("001011101", code));
    }
}
