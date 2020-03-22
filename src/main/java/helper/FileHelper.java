package helper;

import java.io.File;
import java.io.FileWriter;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public class FileHelper {
    public static void print2File(String value, String file) throws Exception{

        File f1 = new File(file);
        if (f1.exists()==false){
            f1.getParentFile().mkdirs();
        }

        FileWriter fos = new FileWriter(f1, true);
        fos.write(value);
        fos.close();

    }
}
