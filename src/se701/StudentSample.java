package se701;

import java.io.*;

public class StudentSample {

    public static void main(String[] args) {

        BufferedReader b_reader;
        try {
            b_reader = new BufferedReader(new FileReader("tests/text.txt"));
            String text = null;
            while ((text = b_reader.readLine()) != null) {
                System.out.println(text);
            }
            b_reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos;
        try {
            fos = new FileOutputStream("tests/text.txt");

            BufferedWriter b_writer;
            try {
                b_writer = new BufferedWriter(new OutputStreamWriter(fos));
                b_writer.write("This is the new contents of the file");
                b_writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            b_reader = new BufferedReader(new FileReader("tests/text.txt"));
            String text = null;
            while ((text = b_reader.readLine()) != null) {
                System.out.println(text);
            }
            b_reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
