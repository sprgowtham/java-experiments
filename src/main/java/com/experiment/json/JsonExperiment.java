package com.experiment.json;

import com.experiment.model.Person;  // import the global class
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExperiment {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Use the global Person class
        Person person = new Person("Advik", 8);

        // Convert to JSON
        System.out.println("Done!");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(jsonString);
    }
}
