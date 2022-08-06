package ua.com.javarush.other;

/**
 * Принадлежность точки многоугольнику
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PointInPolygon {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        //show true
        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        //show false
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        // my solution
        boolean result = false;
        // Проверка, является ли список точек фигурой
        if (polygon.size() < 3) {
            return result;
        }
        int maxX = polygon.stream().max(Comparator.comparing(p -> p.x)).get().x;
        int minX = polygon.stream().min(Comparator.comparing(p -> p.x)).get().x;

        int maxY = polygon.stream().max(Comparator.comparing(p -> p.y)).get().y;
        int minY = polygon.stream().min(Comparator.comparing(p -> p.y)).get().y;

        return point.x > minX && point.x < maxX && point.y > minY && point.y < maxY;

//        solution Java Rush
//        int i;
//        int j;
//        boolean result = false;
//        for (i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
//            if ((polygon.get(i).y > point.y) != (polygon.get(j).y > point.y) &&
//                    (point.x < (polygon.get(j).x - polygon.get(i).x)
//                            * (point.y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x)) {
//                result = !result;
//            }
//        }
//        return result;
    }
}