package ua.com.javarush.collections.cash_proxy.retrievers;

import ua.com.javarush.collections.cash_proxy.storage.Storage;

public class OriginalRetriever implements Retriever {
    Storage storage;

    public OriginalRetriever(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Object retrieve(long id) {
        return storage.get(id);
    }
}