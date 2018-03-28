
import java.time.LocalDateTime;
import java.util.HashMap;


public class Main {



    public static void  main(String[] args) {

        String message;
        String encrypted;



            message = args[0];
            System.out.println("Message you have passed: "+ message);


           encrypted =  encrypt(message);

           System.out.println("Encrypted message " + encrypted);



    }

    public static String encrypt(String encmessage) {

        String decrypted_message = encmessage;
        HashMap hashes = new HashMap();
        hashes = Constants.kody();

        LocalDateTime timenow = LocalDateTime.now();

        Integer day = timenow.getDayOfMonth();
        Integer month = timenow.getMonthValue();
        Integer year = timenow.getYear();
        Integer hour = timenow.getHour();
        Integer minute = timenow.getMinute();
        Integer seconds = timenow.getSecond();
        Integer controlSum = day+month+year+hour+minute+seconds;

        String[] array = decrypted_message.split("");

        StringBuilder encMess = new StringBuilder();

        encMess.append("");
        String[] encryptedArray = new String[array.length];
        for (int i=0; i<array.length; i++){

            Integer encryptedValue;


            encryptedValue = Integer.parseInt(hashes.get(array[i]).toString()) * controlSum;

            encryptedArray[i] = encryptedValue.toString()+":";
            encMess.append(encryptedArray[i]);
        }

        String encrypted_message = encMess.toString();
        System.out.println("Klucz do odkodowania " + controlSum);
return encrypted_message;
    }
}
