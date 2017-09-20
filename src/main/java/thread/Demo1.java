package thread;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by joffre on 2017/9/1.
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer i = 5;
        System.out.println(i.compareTo(26));


        int[] res = new int[3];
        Arrays.fill(res, 4);
        for (int j : res) {
            System.out.println("res = " + j);
        }


        Date date = new Date();
        System.out.println(date.getTime() + "---" + date.toString());
        System.out.printf("%tc\n", date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.JANUARY, 2);
        System.out.println(calendar.toString());


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        System.out.println("please enter string");
//        try {
//            do {
//                str = br.readLine();
//                System.out.println(str);
//            } while (!str.equals("end"));
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }


//        Scanner scanner = new Scanner(System.in);
//        double sum = 0;
//        while (scanner.hasNextDouble()) {
//            double x = scanner.nextDouble();
//            sum += x;
//        }
//        System.out.println(sum);


    }
}
