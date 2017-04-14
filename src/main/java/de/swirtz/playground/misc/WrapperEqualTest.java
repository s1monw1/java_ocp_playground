package de.swirtz.playground.misc;

import java.util.HashMap;
import java.util.Map;


public class WrapperEqualTest {

    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);

        System.out.println("Integers with same value are equal using '? " + i1.equals(i2));
        System.out.println("Integers with same value are == using '? " + (i1 == i2));
        System.out.println("Integers with same value are equal when 'new Integer()' is used? " + i1.equals(i3));
        System.out.println("Integers with same value are == when 'new Integer()' is used? " + (i1 == i3));

        Map<MyKey, String> map = new HashMap<>();
        map.put(new MyKey(i1), "i1val");
        map.put(new MyKey(i2), "i2val");
        map.put(new MyKey(i3), "i3val");
        System.out.println("Map size: " + map.size());

    }

    static class MyKey {
        private Integer num;

        //final int num leads to different behaviour: all three Integers are treated equal in equals method!
        MyKey(final Integer num) {
            this.num = num;
        }

        public boolean equals(Object o) {
            if (o instanceof MyKey) {
                System.out.println("equals called");
                boolean equal = ((MyKey) o).num == this.num;
                System.out.println("equals for this " + this.num + " and " + ((MyKey) o).num + ": " + equal);
                return equal;
            }
            return false;
        }

        // Without overriding hashCode all three Integers will be put in Map because equals
        // method is only considered when hashCode returns same result as any aleady stored value in hashMap
        public int hashCode() {
            System.out.println("hashCode called");
            return this.num.hashCode();

        }


    }
}
