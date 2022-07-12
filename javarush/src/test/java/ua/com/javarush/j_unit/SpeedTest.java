package ua.com.javarush.j_unit;

import org.junit.Assert;
import org.junit.Test;

import ua.com.javarush.strategy_pattern.Helper;
import ua.com.javarush.strategy_pattern.Shortener;
import ua.com.javarush.strategy_pattern.strategy.HasBiMapStorageStrategy;
import ua.com.javarush.strategy_pattern.strategy.HashMapStorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HasBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long shortenerFirstIds = getTimeToGetIds(shortener1, origStrings, new HashSet<>());
        long shortenerSecondIds = getTimeToGetIds(shortener2, origStrings, new HashSet<>());
        Assert.assertEquals(shortenerFirstIds, shortenerSecondIds, 30);

        long shortenerFirstStrings = getTimeToGetStrings(shortener1, new HashSet<>(),origStrings);
        long shortenerSecondStrings = getTimeToGetStrings(shortener2, new HashSet<>(),origStrings);
        Assert.assertEquals(shortenerFirstStrings, shortenerSecondStrings, 30);
    }
}