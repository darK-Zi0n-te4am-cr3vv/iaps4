
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public abstract class Logs {

    public static void Clear() {
        File file = new File("ru_RU_utf-8");

        if (file.exists()) {
            file.delete();
        }
        file = new File("en_US_utf-8");

        if (file.exists()) {
            file.delete();
        }
    }

    public static void StoreLog(
            double X,
            double Y,
            double Radius,
            boolean State)
            throws IOException {

        File file = new File(Language.locale.toString());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                return;
            }
        }

        file.setWritable(true);
        Date date = new Date();
        String dateString;
        Formatter formatter = new Formatter();
        if ("ru" == (Language.locale.getLanguage())) {
            SimpleDateFormat frm = new SimpleDateFormat("k:mm:ss");
            dateString = frm.format(date);
        } else {
            SimpleDateFormat frm = new SimpleDateFormat("K:mm:ss a");
            dateString = frm.format(date);
        }


        FileWriter wFile = new FileWriter(file, true);
        String result = (State) ? "Попал" : "Не попал";
        formatter.format(
                Language.locale,
                "%1$s\t%2$.2f, %3$.2f, %4$.2f\t%5$s\n",
                dateString,
                Radius,
                X,
                Y,
                result);
        wFile.write(formatter.toString());
        wFile.close();
    }

    public static void StoreLog(String logString) throws IOException {
        logString += "\n";
        File file = new File(Language.locale.toString());

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                return;
            }
        }
        
        Date date = new Date();
        String dateString;
        if ("ru" == (Language.locale.getLanguage())) {
            SimpleDateFormat frm = new SimpleDateFormat("k:mm:ss");
            dateString = frm.format(date);
        } else {
            SimpleDateFormat frm = new SimpleDateFormat("K:mm:ss a");
            dateString = frm.format(date);
        }



        FileWriter wFile = new FileWriter(file, true);
        file.setWritable(true);
        Formatter formatter = new Formatter().format(
                Language.locale, "%1$s\t%2$s",
                dateString,logString);
      
        wFile.write(formatter.toString());
        wFile.close();
    }
}
