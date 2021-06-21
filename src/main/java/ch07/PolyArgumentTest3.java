package ch07;

import java.util.Vector;

class Buyer1{
    int money = 1000;
    int bonusPoint = 0;
    Vector item = new Vector();

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액 부족 "); return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item.add(p);
        System.out.println(p + "을 구입함");
    }

    void refund(Product p){
        if(item.remove(p)){
            money += p.price;
            bonusPoint -= bonusPoint;
            System.out.println(p + "을 반품함");
        }
        else{
            System.out.println("구입하신 제품 중 해당 제품 미 존재");
        }
    }

    void summary(){
        int sum = 0;
        String itemList = "";

        if(item.isEmpty()){
            System.out.println("구입한 제품 없음"); return;
        }

        for(int i=0; i < item.size(); i++){
            Product p = (Product) item.get(i);
            sum += p.price;
            itemList += (i == 0) ? p :  ", " + p;
        }
    }
}
public class PolyArgumentTest3 {
    public static void main(String[] args) {

    }
}
