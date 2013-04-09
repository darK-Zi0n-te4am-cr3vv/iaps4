
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    static String resourceName = "Strings";
    static Locale locale;
    static ResourceBundle messages;

    static void setLocale(Locale loc) {


        //Лог
        locale = loc;
        messages = ResourceBundle.getBundle(resourceName, loc);
        
    }

    static Locale getStartLocale() {
        Locale temporary = Locale.getDefault();
        if (temporary == null) {
            temporary = new Locale("ru", "RU", "utf-8");
        } else if (temporary.getLanguage().equals("ru")) {
            temporary = new Locale("ru", "RU", "utf-8");
        } else if (temporary.getLanguage().equals("en")) {
            temporary = new Locale("en", "US", "utf-8");
        }
        else{
            temporary = new Locale("ru", "RU", "ANSI");
        }
        
        return temporary;
    }

    static void Init() {
        setLocale(getStartLocale());
    }

    static public String getString(String name) {
        try {
            messages = ResourceBundle.getBundle(resourceName, locale);

            return messages.getString(name);
        } catch (Exception ex) {
            return "Fail, lol!";
        }

    }
}
