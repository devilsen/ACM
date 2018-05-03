package week_1;

/**
 * @author dongsen
 * date: 2018/03/13 0013.
 */

public class InvertedTriangle {

    public static void main(String[] arg) {
        int num = 15;
        for (int i = num; i >= 1; i--) {
            int count = i + i -1;
//            System.out.println(count);

            StringBuilder builder = new StringBuilder();

            for (int k = 0; k < num - i; k++) {
                builder.append("   ");
            }

            for (int j = 0; j < count; j++) {
                builder.append(" # ");
            }

            System.out.println(builder.toString());
        }
    }

}
