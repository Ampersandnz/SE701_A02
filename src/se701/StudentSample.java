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

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("tests/text.txt")));
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

        System.out.println("List is: " + list);

        //OPENFILE BLOCK STARTS HERE

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File("tests/text.txt")));
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //OPENFILE BLOCK ENDS HERE


        //OPENFILE BLOCK STARTS HERE

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("tests/text.txt")));
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

        System.out.println("After writing back to the file, the list is now: " + list);
    }
}
