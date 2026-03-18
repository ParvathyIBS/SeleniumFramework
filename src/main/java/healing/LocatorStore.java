package healing;

import java.util.HashMap;
import java.util.Map;

public class LocatorStore {

    private static final Map<String, ElementMetadata> STORE = new HashMap<>();

    public static void save(String elementName, ElementMetadata metadata) {
        STORE.put(elementName, metadata);
    }

    public static ElementMetadata get(String elementName) {
        return STORE.get(elementName);
    }
}