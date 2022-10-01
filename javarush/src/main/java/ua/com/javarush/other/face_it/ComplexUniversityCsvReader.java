package ua.com.javarush.other.face_it;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ComplexUniversityCsvReader {
    public static void main(String[] args) throws IOException {

        // set correct path to csv file on your disc
        File csvFile = new File("MSI-master.csv");

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .typedSchemaFor(University.class)
                .withHeader()
                .withColumnSeparator(';')
                .withComments();

        MappingIterator<University> complexUsersIter = csvMapper
                .readerWithTypedSchemaFor(University.class)
                .with(csvSchema)
                .readValues(csvFile);

        List<University> complexUsers = complexUsersIter.readAll();

        complexUsers.forEach(System.out::println);
    }
}
