package ua.com.javarush.collections.cash_proxy.retrievers;

import ua.com.javarush.collections.cash_proxy.cache.LRUCache;
import ua.com.javarush.collections.cash_proxy.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    LRUCache<Long, Object> cache = new LRUCache<>(10);
    OriginalRetriever originalRetriever;

    @Override
    public Object retrieve(long id) {
        Object result = cache.find(id);
        if (result == null) {
            Object o = originalRetriever.retrieve(id);
            cache.set(id, o);
            return o;
        }
        System.out.println("Returning cached object!");
        return result;
    }

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }
}