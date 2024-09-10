package execution;

import text_reader.Implementation;

import java.io.IOException;

public class Execute {
    public static void main(String[] args) {
        try {
            Implementation impl = new Implementation();
            impl.displayMenu();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
