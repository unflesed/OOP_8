package OOP_8.task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker {
    private String name;
    private String position;
    private int year;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "name= " + name + ", position= " + position + ", year=" + year;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker[] workers = new Worker[5];
        Worker temp;
        int years;
        int j = 1;
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker();
        }
        for (Worker worker : workers) {
            System.out.println("Введите фамилию и инициалы " + j + " работника:");
            worker.setName(sc.nextLine());
            System.out.println("Введите должность " + j + " работника:");
            worker.setPosition(sc.nextLine());
            System.out.println("Введите год поступления на работу " + j + " работника:");
            try {
                worker.setYear(sc.nextInt());
            }catch (InputMismatchException inputMismatchException){
                System.out.println("Вы ввели данные неверного типа!");
            }
            sc.nextLine();
            j++;
        }
        for (int i = 0; i < workers.length; i++) {
            for (int k = 1; k < workers.length; k++) {
                if(workers[k].getName().compareToIgnoreCase(workers[k - 1].getName()) < 0){
                    temp = workers[k];
                    workers[k] = workers[k - 1];
                    workers[k - 1] = temp;
                }
            }
        }
        for (Worker worker : workers) {
            try {
                if (worker.getYear() < 1950 || worker.getYear() > 2021) {
                   throw new Exception("Вы ввели неверный год");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " работнику " + worker.getName());
            }
            System.out.println(worker);
        }
        System.out.println("Введите стаж для вывода работников с превышающим стажем:");
        years = sc.nextInt();
        for (Worker worker : workers) {
            if (years < 2021 - worker.getYear()) {
                System.out.println("Работник с превышающим стажем: " + worker.getName());
            }
        }
    }
}
