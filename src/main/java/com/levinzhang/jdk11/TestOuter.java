package com.levinzhang.jdk11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestOuter {
    public void testingOuterPublic() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        TestInner inner = new TestInner();
        inner.testingInner(this);
    }

    private void testingOuterPrivate() {
        System.out.println("Test");
    }

    class TestInner {
        public void testingInner(TestOuter outer) throws NoSuchMethodException,
                InvocationTargetException, IllegalAccessException {
            testingOuterPrivate();
            Method method =
                    outer.getClass().getDeclaredMethod("testingOuterPrivate");
            method.invoke(outer);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        TestOuter outer = new TestOuter();
        outer.testingOuterPublic();
    }
}
