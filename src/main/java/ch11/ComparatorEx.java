package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

    }
}

class Descending implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
       if(o1 instanceof Comparable && o2 instanceof Comparable){
           //Object 타입으로 받기때문에 CompareTo()를 호출하기 위해 Comparable로 형변환한다.
           Comparable c1 = (Comparable) o1;
           Comparable c2 = (Comparable) o2;
           return c1.compareTo(c2) * -1;//-1 곱해서 기본 정렬방식의 역으로 진행
       }
       return -1;
    }
}
