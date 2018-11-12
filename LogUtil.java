package br.com.equilibrioflorestal.pbtcoleta.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {

    /**

     HOW TO USE

     public static void writelog(String msg){
        Settings settings = new Settings(mContext);
        SharedPreferences sharedPreferences = settings.getSharedPreferences();

        //
        boolean creatLog = sharedPreferences.getBoolean("creatLog", true);
        if(creatLog){
            if(logUtil == null){
                logUtil = new LogUtil(mContext,new File("/sdcard/PBTColeta/log"));
                logUtil.build();
            }
        logUtil.write(msg);
        }
     }


     */

        Context context;
        File folder;
        File file;

    public LogUtil(Context context,File folder){

        this.context = context;
        this.folder = folder;
    }


    public void build(){

        file = new File(folder, gatDate() + ".txt");
    }


    public void write(String data){

        try {

            if (!folder.exists()) {
                folder.mkdirs();
            }

            FileWriter writer = new FileWriter(file,true);


            writer.append(gatDateFormated() + " " + data + "\n");
            writer.flush();
            writer.close();


            //Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String gatDate(){

        DateFormat df = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        return df.format(new Date()).toString();


    }

    public String gatDateFormated(){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return df.format(new Date()).toString();


    }

}
