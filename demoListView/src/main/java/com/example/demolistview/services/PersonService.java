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
            String edad = parts.length > 2 ? parts[2].trim() : "0";

            result.add(name + "-" + correo + "-" + edad);
        }
        return result;
    }

    public void addPerson(String name, String email, int age) throws IOException{
        validatePerson(name, email, age);
        String nameNoComa = name.replace(",", "");
        String emailNoComa = email.replace(",", "");
        repo.appendNewLine(nameNoComa + "," + emailNoComa + "," + age);
    }

    private void validatePerson(String name, String email, int age){
        if (name==null || name.isBlank() || name.length()<3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email==null)?"": email.trim();
        if (em.isBlank()|| !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Solo se aceptan mayores de edad");
        }
    }
}