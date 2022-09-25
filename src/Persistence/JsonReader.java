package Persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// CLASS LEVEL COMMENT: This class creates a Json reader capable of reading quizzes represented in Json
// ATTRIBUTION: the following class has been modeled after JsonSerializationDemo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonReader {
    private String source;


    public JsonReader(String source) {
        this.source = source;
    }



    public ArrayList<String> read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseConstellation(jsonObject);
    }



    public ArrayList<String> parseConstellation(JSONObject jsonObject) {
        ArrayList<String> constellations = new ArrayList<>();
        JSONArray constellationArray = jsonObject.getJSONArray("constellations");
        for (Object o : constellationArray) {
            String constellation  = (String) o;
            constellations.add(constellation);
        }
        return constellations;
    }

    // EFFECTS: reads source file as string and returns it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }
}
