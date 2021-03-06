# 11장 컬렉션 프레임웍

# 컬렉션 프레임웍(Collections Framework)

- 데이터 군을 저장하는 클래스들을 표준화한 설계
    - 컬렉션 : 다수의 데이터, 데이트 그룹
    - 프레임웍 : 표준화된 프로그램이 방식
- `JDK1.2`부터 컬렉션 클래스가 추가되면서 컬렉션 클래스드를 표준화된 방식으로 다룰 수 있도록 체계화 되었다.

- 인터페이스와 다영성을 이용한 객체지향적 설계를 통해 표준화되어 있기에 사용법을 익히기에 편리 및 재사용성이 높은 코드 작성 가능

## 컬렉션 프레임웍의 핵심 인터페이스

- 컬렉션데이터 그룹을 컬렉션을 다루느느데 필요한 기능을 가진 3개의 인터페이스를 정의

    ![../../resources/image/image_11_0.png](../../resources/image/image_11_0.png)

    - `List`
        - 순서가 있는 데이터의 집합
        - 중복 허용
        - `ArrayList` `LinkedList` `Stack` `Vector`
    - `Set`
        - 순서를 유지하지 않은 데이터의 집합
        - 중복 허용하지 않음
        - `HashSet` `TreeSet`
    - `Map`
        - 키와 값의 쌍으로 이루어진 데이터의 집합으로 순서를 유지하지 않음
        - 키는 중복 허용X 값을 중복 허용O
        - `HashMap` `TreeMap` `Hashtable` `Properties`
    - `Collection`

        → `List`와 `Set`을 구현한 클래스들은 서로 공통부분이 많아 공통 부분을 다시 뽑아 `Collection`인터페이스를 정의

- 컬렉션 프레임웍의 모든 컬렉션 클래스들은 `List` `Set` `Map` 중 하나를 구현하고 있다.
    - `Vector` `Stack` 등 같은 클래스들은 컬렉션 프레임웍이 만들저지기 전 존재하던 것이기에 컬렉션 프레임웍의 명명법을 따르지 않는다.
    (기존의 컬렉션 클래스들은 호환을 위해 남겨두었지만 사용하지 않는것을 추천)

### Collection 인터페이스

- 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등 컬렉션을 다루는데 가장 기본적인 메서드들을 정의하고 있다

### List 인터페이스

- 중복을 허용하면서 저장순서가 유지되는 컬렉션을 구현하는데 사용된다.

    ![../../resources/image/image_11_1.png](../../resources/image/image_11_1.png)

### Set 인터페이스

- 중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스를 구현한다.

    ![../../resources/image/image_11_2.png](../../resources/image/image_11_2.png)

### Map 인터페이스

- 키와 값을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용한다.
    - `Map`인터페이스에서 키 : 중복 허용하지 않기 때문에 `Set` 타입 반환
    - `Map`인터페이스에서 값 : 중복 허용으로 `Collection` 타입 반환
- 중복된 키와 값을 저장하면 기존의 값은 없어지고 마지막에 저장된 값이 남게된다.

    ![../../resources/image/image_11_3.png](../../resources/image/image_11_3.png)

### Map.Entry 인터페이스

- `Map` 인터페이스의 내부 인터페이스로 `Map`에 저장되는 key-value쌍을 다루기 위해 내부적으로 `Entry`인터페이스를 정의해 놓았다.
- 보다 객체지향적으로 설계하도록 유도한것으로 `Map` 인터페이스를 구현하는 클래스에서는 `Map.Entry` 인터페이스도 함께 구현해야 한다.

```java
public interface Map{
	public static interface Entry{}
}
```

## ArrayList

- 기존의 `Vector`를 개선한 것으로 `Vector`와 구현원리와 기능적인 측면에서 동일하다고 할 수 있다.
- `Object`배열을 이용해 데이터를 순차적으로 저장한다.
- `Object`배열에 순서대로 저장되며 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음 저장된다.

    ```java
    public class ArrayList extends AbstractList implements List ..{
    	transient Object[] elementData;//Object 배열
    }
    ```

- 생성자에 길이를 지정하지 않으면 크기가 10인 리스트를 생성한다.

    ```java
    ArrayList list = new ArrayList();
    //길이가 10인 배열 생성
    ```

- 생성할때 저장할 요소의 개수를 고여해 실제 저장할 개수보다 약간 여유있는 크기로 하는 것이 좋다.
    - 더 많은 객체를 저장할 시 자동적으로 크기가 늘어나지만 처리 시간이 많이 소요된다.
    - 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는데는 효율이 좋지만, 용량을 변경해야 할 때는 새로운 배열을 생성한 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사해야하기 때무넹 상당히 효율이 떨어진다는 단점이 있다.

## LinkedList

- 배열의 단점을 보완하기 위해서 고안된 자료구조로 배열은 모든 데이터가 연속적으로 존재하지만 링크드 리스트는 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성되어 있다.
    - 배열처럼 데이터를 이동하기 위해 복사하는 과정이 없기에 처리속도가 매우 빠르다.

    ```
    배열의 단점
    1. 크기를 변경할 수 없다.
    	- 크기를 변경할 수 없으므로 새로운 배열을 생성해 데이터 복사
    	- 실행속도를 향상 시키기 위해 충분히 큰 크기의 배열 생성으로 메모리 낭비
    2. 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다.
    	- 차례대로 데이터를 추가하고 마지막에서부터 데이터를 삭제하는것은 빠르지만
    	- 배열의 중간에 데이터를 추가하려면, 빈자리를 만들기 위해 다른 데이터들을 복사해서 이동해야 한다.
    ```

- 각 요소들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성되어 있다.

- 링크드 리스트는 이동방향이 단 방향이기에 다음 요소에 대한 접근은 쉽지만 이전 요소에 대한 접근은 어렵다

    → 이를 보완하기 위해 더블 링크드 리스트가 나왔다.

- 더블 링크드 리스트는 단순히 링크드 리스트에 참조변수를 하나 더 추가하여 다음 요소에 대한 참조뿐 아니라 이전 요소에 대한 참조가 가능하도록 한다.

    ```java
    class Node{
    	Node next; // 다음 요소의 주소 저장
    	Node previous; //이전 요소의 주소 저장
    	Obejct obj; //데이터 저장
    }
    ```

- 더블 써큘러 링크드 리스트는 더블 링크드 리스트의 접근성을 보다 향상시킨 것으로 단순히 더블 링크드 리스트의 첫 번째 요소와 마지막 요소를 서로 연결시킨 것이다.

- 실제로 `LinkedList` 클래스는 단점인 낮은 접근성을 높이기 위해 링크드 리스트가 아닌 더블 링크드 리스트로 구현되어 있다.

### LinkedList VS ArrayList

- `ArrayList`

    → 읽기 : 빠르다

    → 중간 데이터 추가/삭제 : 느리다.

    → 순차적인 추가삭제는 더 빠르지만 비효율적인 메모리를 사용한다.

- `LinkedList`

    → 읽기 : 느리다.

    → 중간 데이터 추가/삭제 : 빠르다.

    → 데이터가 많을수록 접근성이 떨어진다.

- 순차적으로 추가/삭제하는 경우에는 `ArrayList`가 더 빠르다
- 중간 데이터를 추가/삭제하는 경우에는 `LinkedList`가 더 빠르다.

- `ArrayList`는 배열을 사용하기에 배열은 각 요소들이 연속적으로 메모리상에 존재하기에 간단한 계산으로 요소의 주소를 얻어 저장된 데이터 곧바로 읽을 수 있음
- `LinkedList`는 불연속적으로 위치한 각 요소들이 서로 연결된 것으로 데이터를 차례대로 따라가야만 저장된 데이터 읽을 수 있다

    → 즉, 저장해야 하는 데이터의 개수가 많아질수록 데이터를 읽어오는 시간이 길어진다.

- 컬렉션 클래스들은 서로 변환이 가능한 셍성자를 제공하므로 작업하기 전 데이터 저장시에는 `ArrayList`를 사용한 다음, 작업할 때는 `LinkedList`에 데이터를 옮겨 작업 시 좋은 효율을 얻을 수 있다.

## Stack과 Queue

- `Stack` : `ArrayList`와 같은 배열기반의 컬렉션 클래스 적합
- `Queue` : `LinkedList`로 구현하는 것이 적합

    → 데이터를 꺼낼 때 항상 첫 번째 저장된 데이터를 삭제하므로 데이터의 추가/삭제가 쉬운 LinkedList로 구현이 적합

### 스택과 큐의 활용

```
스택 : 수식계산, 수식괄효검사, 워드포르세서의 undo/redo, 웹브라우저의 뒤로/앞으로
큐 : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
```

### PriorityQueue

- `Queue`의 구현체 중의 하나로, 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다는 특징이 있다.
- `null`은 저장할 수 없다.
- 저장공간으로 배열을 사용하며, 각 요소를 힙 자료구조의 형태로 저장한다.

    → 자료 구조 `heap`은 JVM의 `heap`과 이름만 같고 다른 것이다.

- 숫자뿐만 아니라 객체를 저장할 수 있는데 그럴 경우 각 객체의 크기를 비교할 방법을 제공해야 한다.

    → `Number`의 자손들은 자체적으로 숫자를 비교하는 방법을 정의하고 있기 때문에 비교 방법을 지정해주지 않아도 된다.

- 참조 변수를 출력하면 `PrioirtyQueue`가 내부적으로 가지고 있는 배열의 내용이 출력된다.

    → 저장한 순서와 다르게 저장되어 있는데 힙의 자료구조 형태여서 그렇다.

### Deque(Double - Ended Queue)

- `Queue`의 변형으로 한 쪽 끝으로만 추가/삭제 할 수 있는 `Queue`와 달리, `Deque`(덱)은 양쪽 긑에 추가/삭제가 가능하다.
- `Deque`의 조상은 `Queue`이다.

## Iterator, ListIterator, Enumeration

- 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스
    - `Iterator`
    - `ListIterator` : `Iterator`의 기능을 향상 시킨 것
    - `Enumeration` : `Iterator`의 구버전

### Iterator

- 컬렉션 프레임워에서는 컬렉션에 저장된 요소 읽어오는 방법을 표준화

    → 컬렉션에 저장된 각 요소에 접근하는 기능 가진 `Iterator` 인터페이스 정의

    → `Collection` 인터페이스에는 `Interator`를 반환하는 `iterator()` 메서드 정의
    (`List`와 `Set`구현하는 컬렉션은 `iterator()`가 각 컬렉션의 특징에 알맞게 작성된다.)

- 컬렉션 클래스에 대해 `iterator()`를 호출해 `Interator`을 얻은 다음 반복문(주로 `while`)를 사용해 컬렉션 클래스의 요소들을 읽어 올 수 있다.

- `Map` 인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하기에 `iterator()`를 직접 호출할 수 없다.

    → `keySet()` `entrySet()` 메서드를 통해 키와 값을 각각 따로 `Set`의 형태로 얻어 온 후에 다시 `iterator()`를 호출하는 방식으로 `Iterator`을 얻을 수 있음

    ```java
    Map map = new HashMap();

    Iterator it = map.entrySet().iterator();
    //Set eset = map.entrySet();
    //Iterator it = eset.iterator();
    ```

- `List`는 순서를 유지하기에 `Iterator`를 이용해 읽어 온 결과 역시 저장순서와 동일
- `Set`은 각 요소간 순서 유지되지 않기에 `Iterator`를 이용해 저장된 요소 읽어와도 저장된 순서와 동일 X

### ListIterator와 Enumeration

```
Enumertaion : Iterator의 구버전
							(컬렉션 프레임웍 만들어지기 이전에 사용으로 호환위해 남겨져 있음)
ListIterator : Iterator를 상속받아 양방향 조회기능 추가(List를 구현한 경우만 사용 가능)
							 (Iterator은 단방향, ListIterator은 양방향)
```

- `Iterator`는 단방향으로만 이동하기에 컬렉션의 마지막 요소에 다다르면 더 이상 사용할 수 없지만 ListIterator는 양방향으로 이동하기 때문에 각 요소가느이 이동이 자유롭다.

    → 이동하기 전 반드시 `hasNext()` `hasPrevious()`를 호출해 이동할 수 있는지 확인 필요

## Arrays

- `Arrays` 클래스에는 배열을 다루는데 유용한 메서드가 정의되어 있다.

### 배열의 복사 : copyOf() copyOfRange()

- `copyOf()` : 배열 전체를 복사해 새로운 배열 만들어 반환
- `copyOfRange()` : 배열의 일부를 복사해 새로운 배열 만들어 반환

### 배열 채우기 : fill() setAll()

- `fill()` : 배열의 모든 요소를 지정된 값으로 채운다.
- `setAll()` : 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다.

    → 함수형 인터페이스를 구현한 객체를 매개변수로 지정하던가 람다식을 지정해야 한다.

### 배열의 정렬과 검색 : sort() binarySearch()

- `sort()` : 배열을 정렬할 때 사용한다.
- `binarySearch()` : 배열에 저장된 요소를 검색할 때 사용한다.

    → 배열에서 지정된 값이 저장된 위치(`index`)를 찾아 반환한다.(정렬된 상태여야 올바른 결과)

    → 검색한 결과 값이 여러개면 위치는 랜덤으로 반환된다.

### 배열의 비교와 출력 : equals() toString()

- `equals()` : 두 배열에 저장된 모든 요소를 비교해 같으면 `true`, 다르면 `false` 반환

    → 일차원 배열에서만 사용가능

    → 다차원 배열에는 `deepEpuals()` 사용해 비교(다차원 배열 `equals`로 비교시 주소값 비교하는 꼴)

- `toString()` : 배열의 모든 요소를 문자열로 편하게 출력

    → 일차원 배열에서만 사용가능

    → 다차원 배열에는 `deepToString()` 사용해 출력(배열의 모든 요소를 재귀적으로 접근해 문자열 구성)

### 배열을 List로 변환 : asList(Object o)

- `asList()` : 배열을 `List`에 담아 반환

    → 매개변수 타입이 가변인수로 배열 생성 없이 저장할 요소들만 나열 가능

    → `asList()` 가 반환한 `List`의 크기는 변경이 불가하다(추가,삭제 불가능)

    ```java
    List list = new ArrayList(Arrays.asList(1,2,3,4,5));
    //이렇게 하면 변경할 수 있는 List를 얻을 수 있다.
    ```

### parallelXXX() spliterator() stream()

- `parallelXXX()` : 보다 빠른 결과를 얻기 위해 여러 쓰레드가 작업을 나누어 처리한다.
- `spliterator()` : 여러 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 `Spliterator` 반환
- `stream()` : 컬렉션을 스트림으로 변환

## Comparator와 Comparable

- `Comparator`와 `Comparable`은 모두 인터페이스로 컬렉션을 정렬하는데 필요한 메서드를 정의하고 있다.

- `Comparable`을 구현하는 클래스들은 같은 타입의 인스턴스끼리 비교할 수 있는 클래스들을 오름차순으로 정렬되도록 구현되어 있다.

    → `Arrays.sort()` 도 `Character`클래스의 `Comparable`의 구현에 의해 정렬되는 것이다.

```
Comparable : 기본 정렬기준을 구혀나흔ㄴ데 사용
Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용
```

- `Comparable`
    - 구현할 클래스들이 기본저그올 오름차순으로 정렬되어 있음
    - `java.lang`패키지
    - `compareTo()`

        → 비교하는 두 객체가 같으면 `0` 비교하는 값보다 작으면 `음수`, 크면 `양수` 반환

- Comparator
    - 내림차순 정렬, 다른 기준에 의해서 정렬시 `Comparator`을 구현해 정렬기준 제공가능
    - `java.util`패키지
    - `compare()`

        → 선언 평태와 이름이 다를뿐 `compareTo()`와 두 객체를 비교한다는 같은 기능을 목적으로 고안된 것

## HashSet

- `Set`인터페이스를 구현한 가장 대표적인 컬렉션으로 `Set`인터페이스의 특징을 따른다.
- `HashSet`에 이미 저장되어 있는 요소와 중복된 요소를 추가시 메서드는 `false`를 반환한다.
- 저장순서를 유지하고자 하면 `LinkedHashSet`를 사용하면 된다.
- 인스턴스의 값이 같아도 타입이 다르면 다르다고 인식한다.

## TreeSet

- 이진 검색 트리라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스이다.
- `Set`인터페이스를 구현했으므로 중복된 데이터의 저장을 허용하지 않으며 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.
- 정렬, 검색, 범위검색에 높은 성능을 보이는 자료구조로 `TreeSet`은 이진 검색 트리의 성능을 향상시킨 '레드-블랙 트리'로 구현되어 있다.
- 이진 검색 트리
    - 부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드
    - 부모노드의 오른쪽에는 부노드의 값보다 큰 값의 자식노드

    → 결국, 왼쪽 마지막 레벨이 제일 작은 값이 되고 오른쪽 마지막 레벨의 값이 제일 큰 값이 된다.

- 컴퓨너는 자동으로 값을 비교하지 못하기 때문에 `TreeSet`에 저장되는 객체가 `Comparable`을 구현하던가, `TreeSet`에게 `Comparator`를 제공해 두 객체를 비교할 방법을 알려줘야 한다.

    → 그렇지 않으면, `TreeSet`에 객체를 저장할 때 예외 발생

- `TreeSet`은 정렬된 상태를 유지하기에 단일 값 검색 범위 검색이 매우 빠르다.
- 트리는 데이터를 순차적으로 저장하는 것이 아닌 저장위치를 찾아 저장/삭제하고 삭제의 경우 트리의 일부를 재구성해야 하므로 링크드 리스크보다 데이터의 추가/삭제의 시간이 더 걸린다.

```
이진 검색 트리는
- 모든 노드는 최대 두 개의 자식노드를 가질 수 있다.
- 왼쪽 자식노드의 값은 부모노드의 값보다 작고 오른쪽자식노드의 값은 부모노드의 값보다 커야한다.
- 노드의 추가 삭제에 시간이 걸린다.(순차적으로 저장하지 않으므로)
- 검색(범위검색)과 정렬에 유리하다.
- 중복된 값을 저장하지 못한다.
```

- 문자열의 경우 정렬순서는 문자의 코드값 기준

    → 오름차순 : 공백, 숫자, 대문자, 소문자 순

## HashMap과 Hashtable

- `Hashtable`보다 새로운 버전인 `HashMap`을 사용할 것을 권장한다.
- `HashMap`은 `Map`을 구현했으므로 `Map`의 특징, 키와 값을 묶어서 하나의 데이터(`entry`)로 저장한다는 특징을 갖는다.
- 해싱을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어 뛰어난 성능을 보인다.
- `HashMap`은 `Entry`라는 내부 클래스를 정의

    → `Entry` 타입의 배열을 선언(키와 값은 별개의 값이 아니기에 하나의 클래스로 정의해 하나의 배열로)

    → 테이브 무결성적인 측면에서 바람직

    → 키와 값을 각각 `Object` 타입으로 저장하기에 어떠한 객체도 저장할 수 있지만 키는 주로 `String`으로 통일한다.

    ```
    키 : 컬렉션 내의 키 중에서 유일해야 한다.
    값 : 키와 달리 데이터의 중복을 허용한다.
    ```

- `HashMap`은 중복을 허용한다.
- `HashMap`의 값은 `Object` 타입이기에 `HashMap`을 저장해 하나의 키에 다시 복수의 데이터를 저장 가능
- 중복된 `Key`의 값을 넣을 경우 값은 덮어씌어진다.
- 한정된 범위 내에 있는 순차적인 값들의 빈도수는 배열을 이용하지만, 한정되지 않은 범위의 비순차적인 값들의 빈도수는 `HashMap`을 이용해서 구할 수 있다.

### 해싱과 해시함수

- 해싱 : 해시함수를 이용해 데이터를 해시테이블에 저장하고 검색하는 기법
- 해시함수 : 데이터가 저장되어 있는 곳을 알려 주기에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
- 해싱의 구현한 컬렉션 클래스

    → `HashSet`

    → `HashMap`

    → `Hashtable`

- 해싱은 배열과 링크드 리스트의 조합의 자료구조를 사용한다.

    ![../../resources/image/image_11_4.png](../../resources/image/image_11_4.png)
    - 저장할 데이터의 키를 해시함수에 넣으면 배열의 한 요소를 얻게 되고, 다시 그곳에 연결되어 있는 링크드 리스트에 저장하게 된다.
- 해시코드를 얻는 과정

    ![../../resources/image/image_11_5.png](../../resources/image/image_11_5.png)

    1. 검색하고자 하는 값의 키로 해시함수 호출
    2. 해시함수의 계산결과(해시코드)로 해당 값이 저장되어 있는 링크드 리스트 찾음
    3. 링크드 리스트에서 검색한 키와 일치하는 데이터 찾는다.

- 링크드 리스트는 검색에 불리한 자료구조로 링크드 리스트의 크기가 커질수록 검색속도가 떨어지게 된다.
- 배열은 배열의 크기가 커져도, 원하는 요소가 몇 번째에 있는 지만 알면 빠르게 원하는 값을 찾을 수 있다.

    ```
    배열의 인덱스가 N인 요소의 주소 = 배열의 시작주소 + type의 size*n
    ```

- 하나의 링크드 리스트에 최소한의 데이터만 저장되어야 성능이 좋아진다.

    → 저장될 데이터의 크기를 고려해 `HashMap`의 크기를 적절하게 지정

    → 해시함수가 서로 다른 키에 대해 중복된 해시코드의 반환을 최소화

- 해싱을 구현하는 과정에서 제일 중요한 것은 해시함수의 알고리즘이다.

    → `Object`클래스에 정의된 `hashCode()`는 객체의 주소를 이용하는 알고리즘으로 해시코드를 만들어 내기에 모든 객체애 대해 `hashCode()`를 호출한 결과가 서로 유일한 훌륭한 방법이여서 해시함수로 많이 사용한다.

- `String`의 경우 `hashCode()`를 오버라이딩해 문자열의 내용으로 해시코드를 만들기 때문에 다른 String 인스턴스라도 같은 내용의 문자열이라면 `hashCode()`를 호출하면 같은 해시코드를 얻는다.!

- `HashMap`, `HashSet`은 두 객체에 대해 `equals()`로 비교한 결과과 `true`인 동시에 `hashCode()`의 반환값이 같아야 같은 객체로 인식한다.

    →  `HashMap`, `HashSet`에서 사용할 새로운 클래스를 정의시 `equals()`를 재정의 오버라이딩 해야 한다면 `hashCode()`도 같이 재정의해 `equals()`의 결과가 `true`인 두 객체의 `hashCode()`의 결과값이 항상 같도록 해주어야 한다.

    → 만약, 오버라이딩을 하지 않을시 `equals()`의 호출결과는 `true`지만 해시코드가 서로 다르다고 인식해 따로 저장된다.

## TreeMap

- 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장한다.
- 검색과 정렬에 적합한 컬렉션 클래스
- 검색에 관한 대부분의 경우 `HashMap`이 `TreeMap`보다 더 뛰어나므로 `HashMap`을 사용하는 것이 좋지만 범위검색, 정렬이 필요한 경우는 `TreeMap`을 사용한다.

## Properties

- `HashMap`의 구 버전인 `Hashtable`을 상송받아 구현한것으로 키와 값을 `Object`의 형태로 저장하는데 비해 `String`의 형태로 저장하는 보다 단순화된 컬렉션 클래스이다.
- 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다.

    → 간단한 입출력은 `Properites`를 활용하면 몇 줄의 코드로 쉽게 해결될 수 있다.

- `setProperty()`

    ```java
    Object setProperty(String key, String value)
    ```

    → 기존에 같은 키로 저장된 값이 있는 경우 값을 `Object`로 반환

- `getProperty()`

    ```java
    String getProperty(String key)
    String getProperty(String key, String defaultValue)
    ```

    → 읽어오려는 키가 존재하지 않으면 지정된 기본값을 반환

- `System` 클래스의 `getPropteries()`를 호출하면 시스템과 관련된 속성이 저장된 `Properties`를 가져올 수 있다.

## Collections

- `Arrays`가 배열과 관련된 메서드를 제공하는 것처럼, `Collections`는 컬렉션과 관련된 메서드를 제공

    → `java.util.Collection` 인터페이스

    → `java.util.Collections` 클래스

### 컬렉션의 동기화

- 멀티 쓰레드 환경에서는 데이터의 일관성을 유지하기 위해 공유되는 객체에 동기화가 필요하다.

    → 구버전(JDK1.2 이전)클래스(`Vector`, `Hashtable`)는 자체적으로 동기화 처리가 되어 있지만 멀티쓰레드 환경이 아닌 경우에는 불필요한 기능으로 성능을 떨어뜨리는 요인이 된다.

    →JDK 1.2 이후의 컬렉션은 동기화를 자체적으로 처리하지 않고 필요한 경우에만 `Collections`클래스의 동기화 메서드를 이용해 동기화 처리 가능하도록 변경되었다.

- `Collections` 클래스에는 동기화 메서드를 제공하고 있으므로, 동기화 필요시 사용

    ```java
    static Collection synchronizedCollection(Collection c)
    static List synchronizedList(List list)
    static Set synchronizedSet(Set s)
    static Map synchronizedMap(Map m)
    static SortedSet synchronizedSortedSet(SortedSet s)
    static SortedMap synchronizedSortedMap(SortedMap m)
    ```

- 사용방법

    ```java
    List syncList = Collections.synchronizedList(new ArrayList(...));
    ```

### 변경불가 컬렉션 만들기

- 컬렉션에 저장된 데이터를 보호하기 위해 컬렉션을 변경할 수 없게 즉, 읽기 전용으로 만들수 있다.

    ```java
    static Collection unmodifialbeCollection(Collection c)
    //List, Set, Map, NavigableSet, SortedSet, NavigableMap, SortedMap
    ```

### 싱글톤 컬렉션 만들기

- 단 하나의 객체만을 저장하는 컬렉션을 만들고 싶을 때 사용하는 메서드

    → 매개변수로 저장할 요소를 지정하면, 해당 요소를 저장하는 컬렉션을 반환하고 반환된 컬렉션은 변경할 수 없다.

    ```java
    static List singletonList(Object o)
    static Set singleton(Object o)
    static Map singletonMap(Object key, Object value)
    ```

### 한 종류의 객체만 저장하는 컬렉션 만들기

- 한 종류의 객체를 저장하며, 컬렉션에 지정된 종류의 객체만 저장할 수 있도록 제한하는 메서드,

    ```java
    static Collection checkekdCollection(Collection c, Class type)
    //List, Set, Map, Queue, NavigableSet, SortedSet, NavigableMap, SortedMap
    ```

    → 두 번재 매개변수에 저장할 객체의 클래스 지정

- 지네릭스로 간단히 처리 가능하지만 지네릭스는 JDK1.5이후에 도입되어서 이전에 작성된 코드를 사용할 때에는 메서드들이 필요하다.

## 정리 & 요약

![../../resources/image/image_11_6.png](../../resources/image/image_11_6.png)
- `ArrayList`

    → 배열기반

    → 데이터 추가/삭제에 불리

    → 순차적인 추가/삭제는 제일 빠름

    → 임의의 요소에 대한 접근성 뛰어남

- `LinkedList`

    → 연결기반 

    →데이터 추가/삭제에 유리

    ->임의의 요소에 대한 접근성이 좋지 않음

- `HashMap`

    → 배열과 연결이 결합된 형태

    → 추가, 삭제, 검색, 접근성이 모두 뛰어남

    → 검색에는 최고성능을 보임

- `TreeMap`

    → 연결기반

    → 정렬과 검색(특히 범위 검색)에 적합

     → 검색성능은 `HashMap`보다 떨어짐

- `Stack`

    → `Vector`를 상속받아 구현

- `Queue`

    → `LinkedList`가 `Queue`인터페이스를 구현

- `Properties`

    → `Hashtable`을 상속받아 구현

- `HashSet`

    → `HashMap`을 이용해 구현

- `TreeSet`

    → `TreeMap`을 이용해서 구현

- `LinkedHashMap` & `LinkedHashSet`

    → `HashMap`과 `HashSet`에 저장순서유지기능을 추가
