package se701;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentSample {

    public static void main(String[] args) {

        //OPENFILE BLOCK STARTS HERE

        List<String> list = new ArrayList<String>();
        File file = new File("tests/text.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            {
                String text = null;
                while ((text = reader.readLine()) != null) {
                    list.add(text);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //OPENFILE BLOCK ENDS HERE

        System.out.println(list);
    }
}
