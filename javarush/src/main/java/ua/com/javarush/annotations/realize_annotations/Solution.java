package ua.com.javarush.annotations.realize_annotations;

@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новый файл добавлен"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Диана", position = Position.OTHER),
                        @Author("Игорь"),
                        @Author(value = "Витек", position = Position.SENIOR)})
})
public class Solution {
    public static void main(String[] args) {
        // Возвращает обьект аннотацию, если такая у класса есть (getAnnotation)
        System.out.println(Solution.class.getAnnotation(Changelog.class).toString());
    }
}