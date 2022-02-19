package ua.com.javarush.multithreading.inner_classes.implements_interface;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}