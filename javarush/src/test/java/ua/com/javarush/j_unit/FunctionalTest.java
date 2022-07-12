package ua.com.javarush.j_unit;

import org.junit.Assert;
import org.junit.Test;

import ua.com.javarush.strategy_pattern.Shortener;
import ua.com.javarush.strategy_pattern.strategy.*;

public class FunctionalTest {

    @Test
    public void testStorage(Shortener shortener) {
        String firstString = "Test string 1";
        String secondString = "Test string 2";
        String thirdString = "Test string 1";

        long firstId = shortener.getId(firstString);
        long secondId = shortener.getId(secondString);
        long thirdId = shortener.getId(thirdString);

        Assert.assertEquals(firstString, shortener.getString(firstId));
        Assert.assertEquals(secondString, shortener.getString(secondId));
        Assert.assertEquals(thirdString, shortener.getString(thirdId));

        Assert.assertNotEquals(firstId, secondId);
        Assert.assertNotEquals(secondId, thirdId);
        Assert.assertEquals(firstId, thirdId);
    }

    @Test
    public void testHashMapStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new HasBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(Shortener shortener) {
        Shortener shortener1 = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}