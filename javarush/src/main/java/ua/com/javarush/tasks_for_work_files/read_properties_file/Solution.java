package ua.com.javarush.tasks_for_work_files.read_properties_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\tasks_for_work_files\\read_properties_file");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\tasks_for_work_files\\read_properties_file");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\tasks_for_work_files\\read_properties_file");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);

        try (InputStream is = new FileInputStream(fileName)) {
            String ext = getExtension(path);
            if ("xml".equals(ext)) {
                properties.loadFromXML(is);
            } else {
                properties.load(is);
            }

        } catch (IOException e) {
        }
        return properties;
    }

    private String getExtension(Path path) {
        String p = path.toAbsolutePath().toString();
        int index = p.lastIndexOf(File.separator);
        if (index >= 0) {
            int index2 = p.lastIndexOf(".");
            if (index2 > index) {
                return p.substring(index2 + 1);
            }
        }
        return p;
    }
}