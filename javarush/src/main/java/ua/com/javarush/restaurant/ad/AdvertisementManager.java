package ua.com.javarush.restaurant.ad;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideo() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {

        }
    }
}