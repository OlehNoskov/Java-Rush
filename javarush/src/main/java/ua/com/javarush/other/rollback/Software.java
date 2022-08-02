package ua.com.javarush.other.rollback;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        boolean result = false;
        if (rollbackVersion >= 0 && versionHistoryMap.containsKey(rollbackVersion)) {
            currentVersion = rollbackVersion;
            int size = versionHistoryMap.size() - rollbackVersion;

            for (int i = 0; i < size; i++) {
                versionHistoryMap.remove(rollbackVersion + 1);
                rollbackVersion++;
            }
            result = true;
        }
        return result;
    }
}