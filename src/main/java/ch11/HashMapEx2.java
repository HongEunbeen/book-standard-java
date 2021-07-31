package ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("aaa", new Integer(100));
        map.put("bbb", new Integer(100));
        map.put("ccc", new Integer(80));
        map.put("ddd", new Integer(90));

        Set set =  map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet();
        System.out.println(set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while(it.hasNext()){
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("총점 : " + total);
    }
}
