package priv.mw.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

public class FileUtils {


    @Value("#{tidy.tidyFileCachePath}")
    private static String tidyFileCachePath;

    public static String saveFile(MultipartFile file, String fileType, String name, String targetPath){
        String fullPath = targetPath+ "//" + fileType;
        String fullFilePath = fullPath +"//" +  name;
        checkPath(fullPath);
        try{
            File targetFile = new File(fullFilePath);
            if(!targetFile.exists()){
                targetFile.createNewFile();
            }
            file.transferTo(targetFile);
        }catch (Exception exception){
            return null;
        }
        return fullFilePath;
    }

    public static boolean delFile(String string){
        return true;
    }

    public static String fileSuffix(String filename){
        String[] nameParts = filename.split("\\.");
        return nameParts[nameParts.length - 1];
    }

    public static String fileType(String suffix){
        HashMap<String, String> typeMap = new HashMap<String, String>(){{
           put("jpg", "img");
           put("png", "img");
           put("gif", "img");
        }};
        return typeMap.get(suffix);
    }

    private static void checkPath(String path){
        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    public static File getFile(String name, String path){
        path = path == null ? tidyFileCachePath : path;
        return new File(path + name);
    }
}
