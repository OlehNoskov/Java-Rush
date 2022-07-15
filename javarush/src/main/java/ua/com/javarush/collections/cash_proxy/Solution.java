package ua.com.javarush.collections.cash_proxy;

import ua.com.javarush.collections.cash_proxy.retrievers.CachingProxyRetriever;
import ua.com.javarush.collections.cash_proxy.retrievers.OriginalRetriever;
import ua.com.javarush.collections.cash_proxy.retrievers.Retriever;
import ua.com.javarush.collections.cash_proxy.storage.RemoteStorage;
import ua.com.javarush.collections.cash_proxy.storage.Storage;

/**
Кеширующий Proxy
 Proxy (Заместитель) — это структурный паттерн проектирования,
 который позволяет подставлять вместо реальных объектов специальные объекты-заменители.
 Эти объекты перехватывают вызовы к оригинальному объекту,
 позволяя сделать что-то до или после передачи вызова оригиналу.
*/

public class Solution {
    private static final int n = 10;

    public static void main(String[] args) {
        Storage storage = new RemoteStorage();

        fillStorage(storage);

        System.out.println("Testing OriginalRetriever: ");
        testRetriever(new OriginalRetriever(storage));

        System.out.println("\n\n\n\n\n\n\n\n\n\nTesting CachingProxyRetriever: ");
        testRetriever(new CachingProxyRetriever(storage));
    }

    private static void fillStorage(Storage storage) {
        for (int i = 0; i < n; i++) {
            storage.add("Resource #" + i);
        }
    }

    private static void testRetriever(Retriever retriever) {
        for (int i = 0; i < n * 4; i++) {
            System.out.println("Loaded value : " + retriever.retrieve((long) (Math.random() * n)));
        }
    }
}