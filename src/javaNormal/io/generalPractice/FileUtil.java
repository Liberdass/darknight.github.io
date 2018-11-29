package javaNormal.io.generalPractice;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private File src;
    private File targ;

    public FileUtil(File src, File targ){
        this.src=src;
        this.targ=targ;
    }

    public static void main(String[] args) {
        File testFile = new File("f:/test/111.txt");
        File testFile2 = new File("f:/test2/");
        FileUtil.findStringInFolder(testFile2,"package");
    }

    public static void copy(File src,File targ){
        try {
            if (src.isFile()) {
                copyFile(src, targ);
            } else if (src.isDirectory()) {
                copyFolder(src, targ);
            } else {
                throw new UnknownSourceException("未知源:"+src.toString());
            }
        }catch (UnknownSourceException e){
            e.printStackTrace();
        }
    }

    public static void copyFile(File src,File targ){
        try(FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(targ)
        ){
            byte[] bytes = new byte[(int)src.length()];
            fileInputStream.read(bytes);
            fileOutputStream.write(bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copyFolder(File src,File targ){
        if (!targ.exists()) {
                myMkdir(targ);
            }
        for (File f : src.listFiles())
        {
            if (f.isDirectory())
            {
                /*将文件夹本身复制过去*/
                File floder = new File(targ.toString()+"/" + getSelfName(f));
                floder.mkdir();
                copyFolder(f, floder);//folder变成子文件夹了
            }
            else
            {
                copyFile(f, new File(targ.toString()+"/"+getSelfName(f)));
            }
        }
//        try(FileInputStream fileInputStream = new FileInputStream(src);
//            FileOutputStream fileOutputStream = new FileOutputStream(targ)
//        ){
//            //start创建目标文件夹
//            if(targ.exists()){
//                throw new FolderExistedException("目标文件夹已存在");
//            }else {
//                String path = targ.toString();
//                path = path.replaceAll("\\\\","/");
//                String[] paths = path.split("/");
//                for(int i = 0; i < paths.length ; i++){
//                    new File(getFatherFolder(targ).toString()+paths[i]).mkdir();
//                }
//            }
//            //end
//            File[] files = src.listFiles();
//            for(File file : files){
//                if(file.isFile()){
//                    copyFile(file,new File(targ.toString()+FileUtil.getSelfName(file)));
//                }else if (file.isDirectory()){
//                    copyFolder(file, new File(targ.toString()+file.toString()));
//                }else {
//                    throw new UnknownSourceException("未知源"+file.toString());
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (FolderExistedException fe){
//            fe.getMessage();
//            fe.printStackTrace();
//        }catch (UnknownSourceException ue){
//            ue.getMessage();
//            ue.printStackTrace();
//        }
    }

    public static void myMkdir(File folder){
        if(getFatherFolder(folder).exists()){
            folder.mkdir();
        }else if (!getFatherFolder(folder).exists()){
            myMkdir(getFatherFolder(folder));
        }
    }

    public static File getFatherFolder(File file){
        File fatherFolder ;
        String path = file.toString();
        path = path.replaceAll("\\\\","/");
        String[] paths = path.split("/");
        String fatherPath = "";
        for(int i = 0; i < paths.length - 1; i++){
            fatherPath = fatherPath + paths[i]+"/";
        }
        fatherFolder = new File(fatherPath.toString());
        try {
            if (fatherFolder.exists()) {
                return fatherFolder;
            } else if (!fatherFolder.exists()) {
                getFatherFolder(fatherFolder);
                return fatherFolder;
            } else {
                throw new UnknownSourceException("未知目标文件");
            }
        }catch (UnknownSourceException ue){
            ue.getMessage();
            ue.printStackTrace();
            return null;
        }
    }

    public static String getSelfName(File file){
        String selfName ;
        String path = file.toString();
        path = path.replaceAll("\\\\","/");
        String[] paths = path.split("/");
        selfName = paths[paths.length - 1];
        return selfName;
    }

    public static void findStringInFolder(File folder, String str){
        List<String> files = new ArrayList<>();
        for(File f : folder.listFiles()) {
            if (f.isFile()) {
                if (1 == findStringInFile(f, str)) {
                    files.add(f.toString());
                } else if (2 == findStringInFile(f, str)) {
                    //
                } else {
                    //
                }
            }else if(f.isDirectory()){
                findStringInFolder(f,str);
            }
        }
        for (String s : files){
            System.out.println(s);
        }
    }

    public static int findStringInFile(File file, String str){
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            byte[] bytes = new byte[(int)file.length()];
            fileInputStream.read(bytes);
            String s = new String(bytes);
            if(s.split(str).length > 1){
                System.out.println(str);
                return 1;
            }else {
                System.out.println(file.toString()+" has not "+str);
                return 2;
            }
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }
}
