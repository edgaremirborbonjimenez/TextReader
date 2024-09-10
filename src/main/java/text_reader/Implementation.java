package text_reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

public class Implementation {

    Scanner sc;
    File file;

    public Implementation() throws IOException{
       sc = new Scanner(System.in);
       file = new File("./src/main/resources/outputMessages.txt");
       FileUtils.writeStringToFile(file,"Project Started \n", StandardCharsets.UTF_8);

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
                    writeUniqueWordsInFile(calculateUniqueWordsFromText());
                    continue;
                case 2:
                    writeAmountLettersInTextInFile(calculateAmountLettersInText());
                    continue;
                case 3:
                    writeMatchedWordsFoundInFile(findMatchedWordsInText());
                    continue;
            }
            if(choice == 4){
                break;
            }
        }
    }

    private List<String> calculateUniqueWordsFromText(){
        System.out.println("------------------------------------------");
        String text;
        while (true){
            System.out.println("Write a text");
            text = sc.nextLine();
            if(text.isBlank()){
                System.out.println("Please enter a text");
                continue;
            }
            break;
        }
        String[] words = StringUtils.split(text, " ");
        Map<String, Integer> wordsCount = new HashMap<>();
        for(String word : words){
            if(!wordsCount.containsKey(word)){
                wordsCount.put(word, 1);
            }else{
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }
        List<String> uniqueWords = new ArrayList<>();
        wordsCount.forEach((key,value)->{
            if(value==1){
                uniqueWords.add(key);
            }
        });
        return uniqueWords;
    }
    private void writeUniqueWordsInFile(List<String> uniqueWords)throws IOException{
        if(uniqueWords.isEmpty()){
            return;
        }
        String message = "There are "+uniqueWords.size()+" unique words in the text \n";
        System.out.println(message);
        FileUtils.writeStringToFile(file, message, StandardCharsets.UTF_8,true);
    }

    private int calculateAmountLettersInText(){
        System.out.println("--------------------------------------");
        String text;
        while (true){
            System.out.println("Write a text");
            text = sc.nextLine();
            if(text.isBlank()){
                System.out.println("Please enter a text");
                continue;
            }
            break;
        }
        int cont = 0;
        for(int i=0; i<text.length(); i++){
            if(Character.isLetter(text.charAt(i))){
                cont++;
            }
        }
        return cont;
    }

    private void writeAmountLettersInTextInFile(int count)throws IOException{
        String message = "There are "+count+" letters in the text \n";
        System.out.println(message);
        FileUtils.writeStringToFile(file,message,StandardCharsets.UTF_8,true);
    }

    private int findMatchedWordsInText(){
        System.out.println("----------------------------------------");
        String word,text;
        while (true){
            System.out.println("Write a word to find matched words");
            word = sc.nextLine();
            if(word.length()==1||word.isBlank()){
                System.out.println("Please enter a word");
                continue;
            }
            System.out.println("Write a text to find matched words");
            text = sc.nextLine();
            if (text.isBlank()){
                System.out.println("Please enter a text");
                continue;
            }
            break;
        }
        String[] words = StringUtils.split(text, " ");
        String finalWord = word;
        int cont = 0;
        for(String w: words){
            if(StringUtils.equals(w,finalWord)){
                cont++;
            }
        }
        return cont;
    }

    private void writeMatchedWordsFoundInFile(int count)throws IOException{
        String message = "There are "+count+" matches \n";
        System.out.println(message);
        FileUtils.writeStringToFile(file,message,StandardCharsets.UTF_8,true);
    }
}
