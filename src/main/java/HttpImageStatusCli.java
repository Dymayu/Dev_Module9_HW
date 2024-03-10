import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){

        try(Scanner scanner = new Scanner(System.in)){

            boolean userInputCorrect = false;
            int enteredCode = 0;

            while(!userInputCorrect){
                System.out.println("Enter HTTP status code:");
                if (!scanner.hasNextInt()){
                    System.out.println("Please enter a valid number!");
                    scanner.next(); // Consume invalid input to prevent infinite loop
                }else {
                    enteredCode = scanner.nextInt();
                    userInputCorrect = true;
                    HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();
                    hsid.downloadStatusImage(enteredCode);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
