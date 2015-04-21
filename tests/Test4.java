import java.io.*;

public class Test4 {

    public void a() {

        BufferedReader b_reader;
        try {
            b_reader = new BufferedReader(new FileReader("tests/text.txt"));
            String read = "";
            String line = b_reader.readLine();
            while ((line) != null) {
                read += line;
                line = b_reader.readLine();
            }
            System.out.println(read);

            BufferedWriter b_writer;
            try {
                b_writer = new BufferedWriter(new FileWriter("tests/text.txt"));
                b_writer.write(read);
                b_writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            b_reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
