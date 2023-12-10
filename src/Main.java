import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/moeen/IdeaProjects/java_practice_problem/src/moeen.text");
        if(file.exists()) {
            file.createNewFile();
        }

    }
}