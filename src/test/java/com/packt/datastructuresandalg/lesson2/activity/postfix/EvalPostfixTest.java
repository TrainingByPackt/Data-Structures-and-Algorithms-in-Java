package com.packt.datastructuresandalg.lesson2.activity.postfix;

import junit.framework.TestCase;

public class EvalPostfixTest extends TestCase {
    private EvalPostfix evalPostfix = new EvalPostfix();

    public void testEvalSimpleAddition() {
        assertEquals(3.0, evalPostfix.evaluate("1 2 +"));
    }

    public void testEvalMultipleOperands() {
        assertEquals(7.0, evalPostfix.evaluate("1 2 3 * +"));
    }

    public void testEvalPlusPrecedence() {
        assertEquals(9.0, evalPostfix.evaluate("1 2 + 3 *"));
    }

    public void testEvalDiv() {
        assertEquals(11.0, evalPostfix.evaluate("5 4 2 / 3 * +"));
    }

    public void testEdgeCaseNumber() {
        assertEquals(9.0, evalPostfix.evaluate("9"));
    }

}
