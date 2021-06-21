package ch07;

class Product{
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        this.bonusPoint = (int)(this.price/10.0);
    }
}

class Tv1 extends Product{
    Tv1(){
        super(100);
    }

    public String toString(){return "Tv";}
}

class Computer extends Product{
    Computer(){
        super(200);
    }

    public String toString(){return "Computer";}
}

class Buyer{
    int money = 1000;
    int bonusPoint = 0;
    Product[] item = new Product[10];
    int i = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 불건을 살 수 없습니다."); return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++] = p;
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary(){
        int sum = 0;
        String itemList = "";

        for(int i=0; i < item.length; i++){
            if(item[i] == null) break;
            sum += item[i].price;
            itemList += item[i] + ", ";
        }

        System.out.println("현재까지 총 결제 액은 : " + sum);
        System.out.println("현재까지 구매한 제품은 : " + itemList);
    }
}

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Computer());
        b.buy(new Tv1());

        b.summary();
    }
}
