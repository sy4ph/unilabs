package lab21;

import java.util.*;
import java.util.stream.Collectors;


public class zadanie5 {

    public static void main(String[] args) {
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {

        return Arrays.stream(elements).collect(Collectors.toCollection(ArrayList::new));
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {

        return Arrays.stream(elements).collect(Collectors.toCollection(HashSet::new));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {

        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K, V> kvHashMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            kvHashMap.put(keys.get(i), values.get(i));
        }
        return kvHashMap;
    }
}