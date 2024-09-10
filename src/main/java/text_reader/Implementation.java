package text_reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import service.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Implementation {

    Scanner sc;
    File file;
    Service service;

    public Implementation() throws IOException{
       sc = new Scanner(System.in);
        service = new Service();

    }

    public void displayMenu()throws IOException{
        while(true){
            System.out.println("Select an option");
            System.out.println("1.- Calculate the number of unique words in the text");
            System.out.println("2.- Calculate the number of letters in the text");
            System.out.println("3.- Find the number of matched words in the text");
            System.out.println("4.- Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    service.writeUniqueWordsInFile(service.calculateUniqueWordsFromText());
                    continue;
                case 2:
                    service.writeAmountLettersInTextInFile(service.calculateAmountLettersInText());
                    continue;
                case 3:
                    service.writeMatchedWordsFoundInFile(service.findMatchedWordsInText());
                    continue;
            }
            if(choice == 4){
                break;
            }
        }
    }
}
