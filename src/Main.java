import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static ArrayBlockingQueue abqA = new ArrayBlockingQueue(100);
    public static ArrayBlockingQueue abqB = new ArrayBlockingQueue(100);
    public static ArrayBlockingQueue abqC = new ArrayBlockingQueue(100);

    public static void main(String[] args) {

        new Thread(() -> {
            String s3 = generateText("abc", 3);
            int x = 0;
            for (int i = 0; i < s3.length(); i++) {
                if (s3.charAt(i) == 'a') {
                    x++;
                }
            }
            abqA.offer(x);
        }).start();

        new Thread(() -> {
            String s3 = generateText("abc", 3);
            int x = 0;
            for (int i = 0; i < s3.length(); i++) {
                if (s3.charAt(i) == 'b') {
                    x++;
                }
            }
            abqB.offer(x);
        }).start();

        new Thread(() -> {
            String s3 = generateText("abc", 3);
            int x = 0;
            for (int i = 0; i < s3.length(); i++) {
                if (s3.charAt(i) == 'c') {
                    x++;
                }
            }
            abqC.offer(x);
        }).start();

        System.out.println(abqA);
        System.out.println(abqB);
        System.out.println(abqC);
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
