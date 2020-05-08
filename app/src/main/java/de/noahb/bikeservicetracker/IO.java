package de.noahb.bikeservicetracker;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {


    public static void addService(Service s, Context context) throws IOException {

        ArrayList<String> services = getFileContent(context);
        services.add(";" + s.getName() + "," + s.getDescription() + "," + s.getDistance_interval() + "," + services.get(1) + "," + ((s.isReminder()) ? 1 : 0) + ";");

        String out = "";

        for(String n : services){
            out = out.concat(n + ";");
        }

        writeFileContent(out, "myService", context);
    }

    public static String[] getFiles(Context context){
        return context.fileList();
    }


    public static void initFiles(int dist, Context context){
        String filename = "myService";
        String fileContents = "myServiceFile;" + dist;
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> getFileContent(Context context) throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<String>();
        FileInputStream fis = context.openFileInput(context.fileList()[0]);
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                list.addAll(Arrays.asList(line.split("[;]")));
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        }
        return list;
    }

    public static void writeFileContent(String string, String filename, Context context) throws IOException {

        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(string.getBytes(StandardCharsets.UTF_8));
    }
}
