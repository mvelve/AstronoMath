package Persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JsonWriter {

    private static final int INDENT_FACTOR = 5;
    private PrintWriter printWriter;
    private String writeTo;

    public JsonWriter(String writeTo) {
        this.writeTo = writeTo;
    }


    public void fileOpen() throws FileNotFoundException {
        printWriter = new PrintWriter(new File(writeTo));
    }

    public JSONArray constellationsToJson(ArrayList<String> constellations) {
        JSONArray jsonArray = new JSONArray();
        for (String s : constellations) {
            jsonArray.put(s);
        }
        return jsonArray;
    }

    public JSONObject convertToJson(ArrayList<String> constellations) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name" ,"constellation collection");
        jsonObject.put("constellations", constellationsToJson(constellations));
        return jsonObject;
    }



    // MODIFIES: this
    // EFFECTS: writes the details of the prescription to the JSON file.
    public void writeTo(ArrayList<String> constellations) throws NullPointerException {
        JSONObject jobject = convertToJson(constellations);
        printWriter.print(jobject.toString(INDENT_FACTOR));
    }


    // MODIFIES: this
    // EFFECTS: closes the file writer.
    public void closeWriter() {
        printWriter.close();
    }
}
