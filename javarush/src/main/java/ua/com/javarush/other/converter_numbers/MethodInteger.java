package ua.com.javarush.other.converter_numbers;

public class MethodInteger {
    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0")) { //Проверяем на первый символ строки
            char[] chars = s.toCharArray();
            if (chars[1] == 'b') { // проверка на 2 систему исчисления
                s = s.substring(2);
                return "" + Integer.parseInt(s, 2);
            } else if (chars[1] == 'x') { // проверка на 16 систему исчисления
                s = s.substring(2);
                return "" + Integer.parseInt(s, 16);
            }
            return "" + Integer.parseInt(s, 8); // 8 система без 2-го символа вначале
        } else { //Перед нами просто десятичное число
            return s;
        }
    }
}