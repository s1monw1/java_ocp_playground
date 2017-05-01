package de.swirtz.playground.misc;

/**
 * Created by simonw on 01.05.17.
 */
public class Outer {
    private int i;

    class Inner {
        public void doX() {
            System.out.println(i);
            System.out.println(Outer.this.i);
        }
    }
}
