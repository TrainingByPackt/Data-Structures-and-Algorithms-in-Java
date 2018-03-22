package com.packt.datastructuresandalg.lesson2.activity.postfix.solution;

import com.packt.datastructuresandalg.lesson2.stack.Stack;

public class EvalPostfix {

    public double evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix.split(" ")) {
            if (token.chars().allMatch(Character::isDigit))
                stack.push(Integer.parseInt(token));
            else if (token.equals("/"))
                stack.pop().flatMap(op1 -> stack.pop().map(op2 -> op2 / op1))
                        .ifPresent(stack::push);
            else if (token.equals("*"))
                stack.pop().flatMap(op1 -> stack.pop().map(op2 -> op2 * op1))
                        .ifPresent(stack::push);
            else if (token.equals("+"))
                stack.pop().flatMap(op1 -> stack.pop().map(op2 -> op2 + op1))
                        .ifPresent(stack::push);
            else if (token.equals("-"))
                stack.pop().flatMap(op1 -> stack.pop().map(op2 -> op2 - op1))
                        .ifPresent(stack::push);
        }
        return stack.pop().orElseThrow(() -> new IllegalArgumentException("Bad expression"));
    }
}
