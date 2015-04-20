import java.io.*;

public class Test4 {

    public void a() {
        // Encountered OpenStmt! :D
        ;
        String read = "";
        String line = reader.readLine();
        while ((line) != null) {
            read += line;
            line = reader.readLine();
        }
        System.out.println(read);
        // Encountered OpenStmt! :D
        ;
        writer.write(read);
    }
}
