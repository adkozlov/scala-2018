package ru.spbau.jvm.scala.lecture01;

public class JavaMain {

    public static void main(String[] args) {
        JavaBar bar = new JavaBar();
        bar.foo();

        bar.setText("Hello");
        System.out.println(bar.getText());
    }
}
