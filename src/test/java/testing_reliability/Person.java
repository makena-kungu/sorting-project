package testing_reliability;

import org.jetbrains.annotations.NotNull;

public record Person(
        String name,
        int age,
        float height,
        float weight
) implements Comparable<Person> {

    @Override
    public int compareTo(@NotNull Person o) {
        int s = name.compareTo(o.name);
        if (s != 0) {
            return s;
        }

        int a = Integer.compare(age, o.age);
        if (a != 0) {
            return a;
        }

        int h = Float.compare(height, o.height);
        if (h != 0) return inv(h);

        int w = Float.compare(weight, o.weight);
        if (w != 0) return inv(w);

        return 0;
    }

    private int inv(int val) {
        return -1 * val;
    }
}
