import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение :");
        String exp = scan.nextLine();
        calc(exp);

    }
    public static void calc(String exp) {

        String[] dat = exp.split(" ");
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*",};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
         if (dat.length==1) {
            try {
                throw new IOException();
            }catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
            return;
        }
        if (converter.isRoman(dat[0]) == converter.isRoman(dat[2])) {
            int a, b;
            boolean isRoman = converter.isRoman(dat[0]);
            if (isRoman) {
                a = converter.romanToInt(dat[0]);
                b = converter.romanToInt(dat[2]);
                if (a < 0 || a > 10 || b < 0 || b > 10) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("throws Exception // Введите римское число в прделах от I до X");
                    }
                    return;
                }
            } else{
                a = Integer.valueOf((dat[0]));
                b = Integer.valueOf(dat[2]);
                if (dat.length>3){
                    try {
                        throw new IOException();
                    }catch (IOException e) {
                        System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                    return;
                }
                if (a < 0 || a > 10 || b < 0 || b > 10) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("throws Exception // Введите число в предлах от 1 до 10");
                    }
                    return;
                }}
                    int result;
                    switch (actions[actionIndex]) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        default:
                            result = a / b;
                            break;

                    }
                    if (isRoman) {
                        System.out.println(converter.intToRoman(result));
                    } else {
                        System.out.println(result);
                    }
            }else{
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }
        }
}}