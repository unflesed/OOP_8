package practise.task_1;

import java.util.Scanner;

public class Calculator {
    int add(int a, int b){
        return a + b;
    }
    int sub(int a, int b){
        return a - b;
    }
    int mul(int a, int b){
        return a * b;
    }
    int div(int a, int b) throws ArithmeticException{
        return a / b;
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int choice;
        System.out.println("Введите числа над которыми желаете совершить операции: ");
        a = sc.nextInt();
        b = sc.nextInt();
        do {
            System.out.println("Сложение - 1");
            System.out.println("Вычитание - 2");
            System.out.println("Умножение - 3");
            System.out.println("Деление - 4");
            System.out.println("Выход - 5");
            choice = sc.nextInt();
            switch(choice) {
                case 1 : System.out.println(calculator.add(a, b));
                    break;
                case 2 : System.out.println(calculator.sub(a, b));
                    break;
                case 3 : System.out.println(calculator.mul(a, b));
                    break;
                case 4 : {
                    try {
                        System.out.println(calculator.div(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }while(choice != 5);
    }
}
