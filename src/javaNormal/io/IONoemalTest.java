package javaNormal.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IONoemalTest {
    public static void main(String[] args) {
        // 绝对路径
        File f = new File("C:/WINDOWS");
        try {
            String[] fileString = f.list();
            System.out.println(Arrays.toString(fileString));
            File[] files = f.listFiles();
            List<File> fileList = new ArrayList<>();
            List<File> folderList = new ArrayList<>();
            long maximum = 0;
            long minimum = Integer.MAX_VALUE;
            for (File file : files) {
                if (true == file.isFile()) {
                    if (file.length() > maximum) {
                        maximum = file.length();
                    }
                    if (file.length() < minimum && file.length() != 0) {
                        minimum = file.length();
                    }
                    fileList.add(file);
                } else if (true == file.isDirectory()) {
                    folderList.add(file);
                }
            }
            System.out.println("--------------------遍历文件(不包括子文件和文件夹)----------------------");
            System.out.println(fileList.toString());
            System.out.println("maximum: "+maximum + " bytes");
            System.out.println("minimum: "+minimum + " bytes");
            System.out.println("-----------------------------------------------------\n");

            System.out.println("--------------------遍历文件(子文件夹里的文件)----------------------");
            List<File> fileList2 = new ArrayList<>();
            List<File> folderList2 = new ArrayList<>();
            for(File folder : folderList){
                File[] dires = folder.listFiles();//dires文件夹下的文件
                System.out.println(folder.toString()+"("+dires.length+"个文件)");
                for(File file : dires){
                    if (true == file.isFile()) {
                        fileList2.add(file);
                        System.out.println("  --"+file.toString());
                    }
                    if (true == file.isDirectory()) {
                        folderList2.add(file);
                    }
                }
            }
            System.out.println("  子文件夹:");
            System.out.println("  --"+folderList2.toString());
            System.out.println("------------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void outPutUnderFolderFile(File path){

    }
}
