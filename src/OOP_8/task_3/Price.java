package OOP_8.task_3;

import java.util.Scanner;

public class Price {
    private String product;
    private String shop;
    private double cost;
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getShop() {
        return shop;
    }
    public void setShop(String shop) {
        this.shop = shop;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return  "product= " + product + ", shop= " + shop + ", cost= " + cost;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Price[] prices = new Price[2];
        boolean check = false;
        String shop;
        Price temp;
        int j = 1;
        for (int i = 0; i < prices.length; i++) {
            prices[i] = new Price();
        }
        for (Price price : prices) {
            System.out.println("Введите название " + j + " товара:");
            price.setProduct(sc.nextLine());
            System.out.println("Введите название " + j + " магазина:");
            price.setShop(sc.nextLine());
            System.out.println("Введите стоимость " + j + " товара:");
            price.setCost(sc.nextDouble());
            sc.nextLine();
            j++;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k < prices.length; k++) {
                if(prices[k].getShop().compareToIgnoreCase(prices[k - 1].getShop()) < 0){
                    temp = prices[k];
                    prices[k] = prices[k - 1];
                    prices[k - 1] = temp;
                }
            }
        }
        for (Price price : prices) {
            System.out.println(price);
        }
        System.out.println("Введите название магазина для вывода товаров:");
        shop = sc.nextLine();
        for (Price price : prices) {
            if (price.getShop().equals(shop)) {
                System.out.println(price);
                check = true;
            }
        }
        try {
            if (!check) {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Такого магазина нет!");
        }
    }
}
