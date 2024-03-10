import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {

        try{
            String urlCompiled = "https://http.cat/" + code + ".jpg";
            URL url = new URL(urlCompiled);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            if (responseCode==404){
                throw new FileNotFoundException(String.format("File with code %s not found!", code));
            }else {
                return urlCompiled;
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        return "no picture found";
    }

    public static void main(String[] args) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String getURL = checker.getStatusImage(333);
        System.out.println("getURL = " + getURL);

    }
}
