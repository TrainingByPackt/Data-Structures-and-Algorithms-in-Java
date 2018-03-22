package com.packt.datastructuresandalg.lesson2.stack;

import java.util.Optional;

public class StringReverse {

    public String reverse(String str) {
        StringBuilder result = new StringBuilder();
        StackArray<Character> stack = new StackArray<>(100);
        for (char c : str.toCharArray())
            stack.push(c);
        Optional<Character> optChar = stack.pop();
        while (optChar.isPresent()) {
            result.append(optChar.get());
            optChar = stack.pop();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringReverse().reverse("This will be reversed"));
    }
}
