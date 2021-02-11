package pl.sda.dao.impl;

import pl.sda.dao.PersonDao;
import pl.sda.model.Person;
import pl.sda.util.FileUtil;
import pl.sda.util.PersonUtil;
import pl.sda.util.PersonValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersonDao implements PersonDao {

    private final FileUtil fileUtil;

    private final PersonUtil personUtil;

    private final Path FILE_PATH = Paths.get("D:/", "IdeaProject", "IdeaProjectsSpringAdnotation", "filePersonDao.txt");

    private final List<String> allLines = Files.readAllLines(FILE_PATH);

    private final List<Person> personList = new ArrayList<>();

    public FilePersonDao(FileUtil fileUtil, PersonUtil personUtil) throws IOException {
        this.fileUtil = fileUtil;
        this.personUtil = personUtil;

    }


    @Override
    public void add(Person person) throws IOException {

        String personId = fileUtil.parseIdToString(person.getId());

        String result = String.join(";", new String[]{personId, person.getName(), person.getSurname()});

        if (Files.notExists(FILE_PATH)) {
            Files.createFile(FILE_PATH);
            System.out.println("New file has been created");
        }
        Files.writeString(FILE_PATH, result + System.lineSeparator(), StandardOpenOption.APPEND);

    }

    @Override
    public Person getById(int id) {

        for (Person p : personList) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("Unrecognized id");
    }

    @Override
    public List<Person> getAll() {

        for (String s : allLines) {
            String[] splitedLines = s.split(";");
            String idAsString = splitedLines[0];
            String name = splitedLines[1];
            String surname = splitedLines[2];

//                System.out.printf("id= %s, name= %s, surname= %s\n", idAsString, name, surname);

            int id = personUtil.parseIdToInd(idAsString);

            Person person = new Person(id, name, surname);
            personList.add(person);
        }

        return personList;
    }

    @Override
    public void deleteById(int id) throws IOException {

        String s = fileUtil.parseIdToString(id);

        List<String> FILE_OUT = Files.lines(FILE_PATH)
                .filter(line -> !line.contains(s))
                .collect(Collectors.toList());

        Files.write(FILE_PATH, FILE_OUT, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}

