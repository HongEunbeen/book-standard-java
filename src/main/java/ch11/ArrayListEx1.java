package ch11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);

        list.add(new Integer(5));
        list.add(new Integer(4));
        list.add(new Integer(2));
        list.add(new Integer(0));
        list.add(new Integer(1));
        list.add(new Integer(3));

        ArrayList list2 = new ArrayList(list.subList(1, 4));
        print(list ,list2);

        //Collections.sort()를 이용해 정렬한다.
        Collections.sort(list);
        Collections.sort(list2);
        print(list, list2);

        //list가 list2의 모든 요소를 포함하고 있을 때만 True
        System.out.println(list.containsAll(list2));

        //add(Object obj)를 이용해서 새로운 객체 저장
        list2.add("B");
        list2.add("C");

        //set(int index, Object obj)를 이용해 다른 객체로 변경
        list2.add(3,"A");
        print(list, list2);

        list2.add(3,"AA");
        print(list, list2);

        //retainAll에 의해 list에 변화
        System.out.println(list.retainAll(list2));
        print(list, list2);

        //list2와의 공통요소 이외에는 모두 삭제
        for(int i=list2.size()-1; i >= 0; i--){
            if(list.contains(list2.get(i))) list.remove(i);
        }
        print(list, list2);
    }

    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
