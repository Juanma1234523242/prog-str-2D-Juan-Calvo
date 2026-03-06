package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines){
            if (line==null || line.isBlank())continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();

            result.add(name+"-"+correo);
        }
        return result;

        }

}
