package nl.omniex.omniexshopping.utils;

public class StringUtils {

    public static String cleanUrl(String url){
        String cleanedUrl = url.replaceAll("\\\\", "");
        return cleanedUrl;
    }
}
