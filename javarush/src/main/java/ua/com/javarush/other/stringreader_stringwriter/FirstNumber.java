package ua.com.javarush.other.stringreader_stringwriter;

public class FirstNumber {
    public static void main(String[] args) {
        System.out.println(calculateQuest("1,200.1"));
    }

    public static int calculateQuest(String string) {
        int result = 0;
        StringBuilder temp = new StringBuilder();
        String[] arrayString = string.split("");
        for (int i = 0; i < arrayString.length; i++) {

            // Проверка что символ это число и оно не равно нулю
            if (Character.isDigit(arrayString[i].toCharArray()[0])) {
                temp.append(arrayString[i]);

                //Если мы обошли весь массив остановиться
                if (i == arrayString.length - 1) {
                    break;
                }

                // Если следующий элемент после числа не число останавливаем цикл
                if (!Character.isDigit(arrayString[i + 1].toCharArray()[0])) {
                    break;
                }
            }
        }
        if (temp.length() != 0 && Integer.parseInt(String.valueOf(temp)) != 0) {
            result = Integer.parseInt(temp.toString());
        } else {
            System.out.println("Not a number!");
        }
        return result;
    }
}