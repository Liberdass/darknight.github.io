package javaNormal.io.testCharStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
    public static void main(String[] args) {
        File f = new File("F:/111.txt");

        try(FileWriter fileWriter = new FileWriter(f)){
            String words = "im sb";
            fileWriter.write(words);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileReader fileReader = new FileReader(f)){
            char[] input = new char[(int)f.length()];
            fileReader.read(input);
            for(char c : input){
                System.out.println(c);
            }
//            Closing Stream is not necessary when using try(){}
//            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
