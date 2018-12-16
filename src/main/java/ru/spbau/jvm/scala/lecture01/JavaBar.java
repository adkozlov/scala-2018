package ru.spbau.jvm.scala.lecture01;

import java.io.Serializable;

public class JavaBar implements JavaFoo, Serializable {

    public static JavaBar apply() {
        return new JavaBar();
    }

    public static JavaBar apply(int foo) {
        return new JavaBar();
    }

    public static JavaBar apply(double d) {
        return new JavaBar((int) d);
    }

    private static void bar() {

    }

    private final int innerFoo;

    private String text;

    public JavaBar(int innerFoo, String text) {
        this.innerFoo = innerFoo;
        this.text = text;

        bar();
    }

    public JavaBar(int innerFoo) {
        this(innerFoo, "");
    }

    public JavaBar(String text) {
        this(0, text);
    }

    public JavaBar() {
        this(0, "");
    }

    public int getInnerFoo() {
        return innerFoo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int foo() {
        return fooImpl();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JavaBar)) {
            return false;
        }

        JavaBar bar = (JavaBar) obj;
        return innerFoo == bar.innerFoo;
    }

    private int fooImpl() {
        return innerFoo;
    }
}
