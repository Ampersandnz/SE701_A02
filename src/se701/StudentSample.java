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
        List<String> list = new ArrayList<String>();

        //OPENFILE BLOCK STARTS HERE

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
                file = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //OPENFILE BLOCK ENDS HERE


        //OPENFILE BLOCK STARTS HERE

        File file = new File("tests/text.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            {
                String text = null;
                for (String s : list) {
                    writer.write(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                file = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //OPENFILE BLOCK ENDS HERE

        System.out.println(list);
    }
}
