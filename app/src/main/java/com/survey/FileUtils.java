package com.survey;
import android.os.Environment;

/**
 * Created by Lucas on 28/02/2018.
 */

public class FileUtils {

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

}
