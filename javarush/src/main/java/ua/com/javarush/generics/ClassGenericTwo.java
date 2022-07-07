package ua.com.javarush.generics;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ClassGenericTwo<T extends HashMap> {
    private HashMap map;

    public ClassGenericTwo(HashMap map) {
        this.map = map;
    }

    public HashMap getMap() {
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("string", 4);
        ClassGenericTwo solution = new ClassGenericTwo(hashMap);
        HashMap mapFromSolution = solution.getMap();
        System.out.println(mapFromSolution.getClass());


        LinkedHashMap<ClassGenericTwo, ClassGenericTwo> hashMap2 = new LinkedHashMap<>();
        hashMap2.put(solution, solution);
        ClassGenericTwo solution2 = new ClassGenericTwo(hashMap2);
        LinkedHashMap mapFromSolution2 = (LinkedHashMap) solution2.getMap();   //need to cast  :(
        System.out.println(mapFromSolution2.getClass());
    }
}