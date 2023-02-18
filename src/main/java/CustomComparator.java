import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomComparator <K,V extends Comparable> implements Comparator<K> {
    private Map<K, V> map;

    public CustomComparator(Map<K, V> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public int compare(K s1, K s2) {
        return map.get(s2).compareTo(map.get(s1));
    }

    public static <K, V> Map<K, V> sortByValues(Map<K, V> map)
    {
        Comparator<K> comparator = new CustomComparator(map);

        Map<K, V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);

        return sortedMap;
    }
}
