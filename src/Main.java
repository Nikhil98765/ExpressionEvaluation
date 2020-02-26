import com.company.StringController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Scanner s = new Scanner(System.in);

        String expression = s.nextLine();

        StringController inputExpression = new StringController(expression);

        inputExpression.init();







    }
}
