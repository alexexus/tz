package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        parseJson();
    }

    public static void parseJson() {
        Scanner sc = new Scanner(System.in);
        String path1 = sc.nextLine();
        String path2 = sc.nextLine();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<Long, String> map = new HashMap<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path2));
            Values values = gson.fromJson(reader, Values.class);
            List<Value> valueList = values.getValues();

            for (Value v : valueList) {
                map.put(v.getId(), v.getValue());
            }
            reader.close();

            Reader reader2 = Files.newBufferedReader(Paths.get(path1));
            Tests tests = gson.fromJson(reader2, Tests.class);
            List<Test> testList = tests.getTests();
            setValue(map, testList);

            reader2.close();

            try (PrintWriter out = new PrintWriter(new FileWriter("report.json"))) {
                out.write(gson.toJson(testList));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setValue(Map<Long, String> map, List<Test> testList) {
        for (Test t : testList) {
            if (t.getValues() == null) {
                t.setValue(map.get(t.getId()));
            } else {
                t.setValue(map.get(t.getId()));
                setValue(map, t.getValues());
            }
        }
    }
}
