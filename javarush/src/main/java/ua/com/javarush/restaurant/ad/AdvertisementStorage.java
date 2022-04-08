package ua.com.javarush.restaurant.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {

    private static class InstanceHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanceHolder.ourInstance;
    }

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        new Advertisement(someContent, "First video", 5000,100, 3*60);
        new Advertisement(someContent, "Second video", 100,100, 15*60);
        new Advertisement(someContent, "Third video", 400,2, 25*60);
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}