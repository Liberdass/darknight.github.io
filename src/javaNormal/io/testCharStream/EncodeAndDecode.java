package javaNormal.io.testCharStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncodeAndDecode {
    public static void main(String[] args) {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        File f1 = new File("f:/111.txt");
        File f2 = new File("f:/222.txt");
        encodeAndDecode.decodingFile(f1,f2);
    }

    public void decodingFile(File decoding,File decode){
        String decodingWords = "";
        //加密
        try(FileReader fileReader = new FileReader(decoding)){
            char[] decodingChars = new char[(int)decoding.length()];
            fileReader.read(decodingChars);
            decodingWords = new String(decodingChars);
            decodingWords = this.decodingMethod(decodingWords);
        }catch (IOException e){
            e.printStackTrace();
        }
        //写入
        try(FileWriter fileWriter = new FileWriter(decode)){
            fileWriter.write(decodingWords);
        }catch (IOException e2){
            e2.printStackTrace();
        }
    }

    public String decodingMethod(String decoding){
        char[] words = new char[decoding.length()];
        words = decoding.toCharArray();
        for(int i =0; i< words.length; i++){
            if(words[i] <= '9' && words[i] > '0' ){
                words[i]--;
            }else if(words[i] == '0' ){
                words[i] = '9';
            }else  if(words[i] <= 'z' && words[i] > 'a' || words[i] <= 'Z' && words[i] > 'A'){
                words[i]--;
            }else if(words[i] == 'a' || words[i] == 'S'){
                if(words[i] == 's')words[i] = 'z';
                if(words[i] == 'A')words[i] = 'Z';
            }else {

            }
        }
        return new String(words);
    }

    public void encodingFile(File encoding, File encode){
        String encodingWords = "";
        //加密
        try(FileReader fileReader = new FileReader(encoding)){
            char[] encodingChars = new char[(int)encoding.length()];
            fileReader.read(encodingChars);
            encodingWords = new String(encodingChars);
            encodingWords = this.encodingMethod(encodingWords);
        }catch (IOException e){
            e.printStackTrace();
        }
        //写入
        try(FileWriter fileWriter = new FileWriter(encode)){
            fileWriter.write(encodingWords);
        }catch (IOException e2){
            e2.printStackTrace();
        }
    }

    public String encodingMethod(String encoding){
        char[] words = new char[encoding.length()];
        words = encoding.toCharArray();
        for(int i =0; i< words.length; i++){
            if(words[i] < '9' && words[i] >= '0' ){
                words[i]++;
            }else if(words[i] == '9' ){
                words[i] = '0';
            }else  if(words[i] < 'z' && words[i] >= 'a' || words[i] < 'Z' && words[i] >= 'A'){
                words[i]++;
            }else if(words[i] == 'z' || words[i] == 'Z'){
                if(words[i] == 'z')words[i] = 'a';
                if(words[i] == 'Z')words[i] = 'A';
            }else {

            }
        }
        return new String(words);
    }
}
