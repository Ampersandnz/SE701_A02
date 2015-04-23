import java.io.*;

public class Test4 extends Test4_1 {

    public void a() {
        FileInputStream in = new FileInputStream("tests/text.txt");

        BufferedReader b_reader;
        try {
            b_reader = new BufferedReader(in);
            String read = "";
            String line = b_reader.readLine();
            while ((line) != null) {
                read += line;
                line = b_reader.readLine();
            }
            System.out.println(read);
            b_reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class Test4_1 implements Test4_2 {

    public String b(String in) {
        return in;
    }
}

public interface Test4_2 {

    public String b(String in);
}
