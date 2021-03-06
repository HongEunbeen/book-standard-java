# 5장 배열

- 컴파일러는 `index`를 넘어가는 실수를 걸러주지 못한다

    → 배열의 `index`로 변수를 많이 사용하는데 변수의 값은 실행 시에 대입되므로 컴파일러는 이 값의 범위를 확인하지 못한다

    → 무사히 컴파일을 마쳤더라도 실행 시 에러가 발생할 수 있다.

- 배열의 길이는 `int` 범위의 양의 정수(0 포함)이여도 가능하다.-

    ```java
    int[] arr = new int[0];
    ```

- 자바에서는 JVM이 모든 배열의 길이를 별도로 관리한다.

    → `배열이름.length` 통해서 배열 길이에 대한 정보를 얻을 수 있다.

    → 배열이름.length 는 상수이다. (생성된 배열의 길이 변경할 수 없다)

    - 변경하는 방법은 더 큰 배열 새로 생성, 기존 배열의 내용을 새로운 배열에 복사하는 방법이 있다.

- 배열은 생성과 동시에 자동적으로 자신의 타입에 해당하는 기본값으로 초기화 된다.

- 메서드를 호출 시에는 `new 타입[]` 생략이 불가하다.

    ```java
    int add(int[] arr){...}
    //int add({a,b,c}) {...} 오류
    int add(new int[] {1,2,3}){...}
    ```

- `Arrays.toString(배열이름)` 배열의 모든 요소를 문자열로 반환한다.

    ```java
    int arr[] iArr = new arr[]();
    System.out.println(iArr);
    ```

    → 배열을 가리키는 참조 변수 `iArr` 값이 출력된다.

    → 예외로 `char` 배열은 각 요소가 구분자 없이 그대로 출력된다.

- 배열의 복사
    - `for`문 사용

        → 배열 요소 하나하나에 접근해 복사

    - `System.arraycopy()` 사용

        → 지정된 범위의 값들을 한 번에 통째로 복사

        → 각 요소들이 연속적으로 저장된 배열의 특성을 이용

- `String` 배열의 변수의 기본값은 `null`

    ```java
    String[] arr1 = {"a", "b" ,"c"};
    String[] arr2 = new String[]();
    arr2[0] = "a";
    arr2[1] = new String("B");
    ```

- `char` 배열이 아닌 `String` 배열을 사용해 문자열을 처리하는 이유

    → `String` 클래스가 `char` 배열에 여러가지 기능(메서드)을 추가확장한 것이기 때문

    → 객체 지향 언어 이전 : 데이터 기능 분리

    → 객체 지향 언어 : 데이터와 기능 하나의 클래스로(서로 관련된 것들끼리 데이터와 기능 구분X)

- 커맨드 라인에 매개변수를 입력하지 않으면 크기가 0인 배열이 생성된다.

    →`args`의 `length`가 `0`이 될 수 없다면 JVM이 입력된 매개변수가 없을 시 `null`을 주게되고 `main`에서 `args ! = null` 구문을 추가해야 한다.

    ```java
    public static void main (String[] args) {
    	...
    }
    ```

- 다차원 배열은 메모리의 용량이 허용하는 한, 차원의 제한은 없다.

    ```java
    int[][] arr = {{1,2,3}, {4,5,6}};
    ```

- 2차원 이상의 다차원 배열 생성 시 전체 배열 차수 중 마지막 차수의 길이를 지정하지 않고 추후에 각기 다른 길이의 배열로 지정할 수 있다.