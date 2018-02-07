import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWord(final String url) {
        return urlToString(url).split(" ").length;
    }

    private static int countOneWord(final String url, final char search) {
        int res = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == search) {
                res++;
        }
        return res;
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countWord("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countOneWord("http://erdani.com/tdpl/hamlet.txt","Hamlet"));
    }
}
