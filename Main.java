package kirill.exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = null;
        String sign = null;
        String second = null;
        try {
            first = scan.nextLine();
            valueCheck(first);
            sign = scan.nextLine();
            signCheck(sign);
            second = scan.nextLine();
            valueCheck(second);
            switch (sign){
                case "+":
                    System.out.println(Integer.parseInt(first) + Integer.parseInt(second));
                    break;
                case "-":
                    System.out.println(Integer.parseInt(first) - Integer.parseInt(second));
                    break;
                case "*":
                    System.out.println(Integer.parseInt(first) * Integer.parseInt(second));
                    break;
                case "/":
                    try {
                        checkByZero(second);
                        System.out.println(Integer.parseInt(first) / Integer.parseInt(second));
                        break;
                    }catch (ZeroCheck e){
                        e.Error();
                    }
            }
        }catch (ValueCheck e){
            e.Error();
        }
    }

    public static void valueCheck(String number) throws ValueCheck {
        boolean f = true;
        for (int i = 0; i < number.length(); i++) {
            if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9')){
                f = false;
                break;
            }
        }
        if(!f){
            throw new ValueCheck();
        }
    }

    public static void signCheck(String sign) throws ValueCheck {
        if(!sign.equals("+") && !sign.equals("-") && !sign.equals("*") && !sign.equals("/")){
            throw new ValueCheck();
        }
    }

    public static void checkByZero(String second) throws ZeroCheck {
        if(second.equals("0")){
            throw new ZeroCheck();
        }
    }
}
