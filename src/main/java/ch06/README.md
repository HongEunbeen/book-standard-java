# 6장 객체지향 프로그래밍1

- 실제 세계와 유사한 가상 세계를 컴퓨터 속에 구현하고자 객체지향은 탄생하게 되었다

- 실제 세계는 사물들로 이루어져 있으며, 발생하는 모든 사건들은 사물간의 상호 작용이 발생한다.

- 객체지향 언어로 코드 간에 서로 관계를 맺어줌으로써 유기적으로 프로그램을 구성하는 것이 가능해졌다.

- 객체지향의 장점
    - 코드의 재사용성이 높다
    → 새로운 코드를 작성할 떄 기존의 코드를 이용해 쉽게 작성할 수 있다.
    - 코드의 관리가 용이하다
    → 코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.
    - 신뢰성이 높은 프로그래밍을 가능하게 한다
    → 제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.

```
클래스의 정의 : 클래스란 객체를 정의해 놓은 것이다.
클래스의 용도 : 클래스는 객체를 생성하는데 사용된다.

객체의 정의 : 실제로 존재하는것, 사물 또는 개념
객체의 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름

유형의 객체 : 책상, 의자, 자동차, TV와 같은 사물
무형의 객체 : 수학공식, 프로그램 에러와 같은 논리나 개념
```

- 프로그래밍 관점에서 객체란 클래스에 정의도니 내용대로 메모리에 생성된 것

- 클래스를 잘 만들어 놓으면 객체 생성 고민 할 필요 없다
→ JDK에서 유용한 클래스 기본적으로 제공해준다.

- 객체는 속성과 기능의 집합로 이를 객체의 멤버라고 부른다.
(일반적으로 객체는 다수의 속성과 다수의 기능을 갖는다)
    - 속성(`property`)

        → 멤버변수(`member variable`)

        → 특성(`attribute`)

        → 필드(`field`)

        → 상태(`state`)

    - 기능(`function`)

        → 메서드(`method`)

        → 함수(`function`)

        → 행위(`behavior`)

- 클래스로부터 인스턴스를 생성하는 방법 여러가지 존재

    → 일반적인 방법 

    ```
    클래스명 변수명;
    변수명 = new 클래스명();
    ```

- 인스턴스는 참조 변수를 통해서만 다룰 수 있으며, 참조변수의 타입을 인스턴스의 타입과 일치해야 한다.

- 객체 배열은 참조변수들을 하나로 묶은 참조 변수 배열이다.

- 클래스는 프로그래밍적인 관점에서 `데이터와 함수의 결합`, `사용자정의 타입`으로 볼 수 있다.

- 프로그래밍 언어에서 데이터 처리를 위한 데이터 저장 형태 발전 과정

    `변수` → `배열` → `구조체` → `클래스`

    1. 변수 : 하나의 데이터를 저장할 수 있는 공간
    2. 배열 : 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
    3. 구조체 : 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
    4. 클래스 : 데이터와 함수의 결합(구조체 + 함수)

    → 그동안 데이터와 함수 관계없는 것처럼 따로 처리했지만 함수는 데이터를 가지고 작업하기에 둘은 관계가 깊다.

- 데이터와 함수의 관계를 하나의 클래스에 정의하여 함께 다룰 수 있게 했다.

    → C언어 : 문자열을 문자의 배열로 다룸

    → JAVA 언어 : `String`이라는 클래스로 문자열 다룸
    (클래스로 정의한 이유는 문자열과 문자열을 다루는데 필요한 함수들을 함께 묶기 위해서)
    (실제 `String` 클래스 내부에는 문자형 배열이 선언되어 있고 필요한 함수들이 정의되어 있다.)

- 사용자 정의 타입이란 언어에서 제공하는 자료형외에 프로그래머가 서로 관련된 변수들을 묶어서 하나의 타입으로 새로 추가하는 것을 말한다.
→ 자바에서는 클래스가 사용자 정의 타입이다.

- 객체지향언어에서는 제어자와 메서드를 이용해서 조건들을 코드에 쉽게 반영할 수 있다.

# 변수

```java
class Variables{
	int iv;//인스턴수 변수
	static int cv;//클래스 변수(공유변수, static 변수)

	void method()
	{
		int lv = 0;//지역 변수
	}
}
```

- 멤버 변수
    - 클래스 변수(`static`)
    - 인스턴스 변수
- 지역 변수
(멤버변수를 제외한 나머지)

![6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8004.heic](6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8004.heic)

→ 변수는 선언된 위치로 종류가 결정된다.

1. 인스턴스 변수(`instance variable`)
    - 클래스 영역에 선언
    - 클래스의 인스턴스를 생성할 때 만들어짐
    - 인스턴스 변수의 값 사용 위해 인스턴스 만들어야 함
    - 인스턴스마다 고유한 상태를 유지해야 하는 속성은 인스턴수 변수로 선언
2. 클래스 변수(`class variable`)
    - 클래스 영역에 `static` 붙여 선언
    - 클래스가 메모리에 로딩될때 생성되어 프로그램이 종료될때 까지 유지
    - 인스턴스를 생성하지 않고 언제라도 바로 사용할 수 있음
    - 인스턴스들이 공통적으로 값을 유지해야 하는 속성은 클래스 변수로 선언
    (모든 인스턴스가 공통된 저장공간을 공유)
3. 지역 변수(`local variable`)
    - 메서드 영역에 선언
    - 메서드 내에서만 사용하며 메서드가 종료되면 소멸
    - 블럭 내에 선언된 지역변수는 블럭 내에서만 사용가능

- 클래스 변수를 사용할 때는 인스턴스 변수와 구별가능하게 `클래스이름.클래스변수`의 형태로 사용하는 것이 좋다.

```
인스턴스 변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 
클래스 변수는 모든 인스턴스가 하나의 저자공간을 공유하므로, 항상 공통된 값을 갖는다.
```

# 메서드

- 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
- 기본적으로 수학의 함수와 유사
- 작업을 수행하는데 필요한 값만 넣고 원하는 결과 얻음
- 메서드 내부적으로 어떤 과정 거쳐 결과를 도출하는지 몰라도 된다.

- 메서드는 크게 선언부와 구현부로 이루어짐
    - 선언부 : 메서드 이름 매개변수 선언 반환타임
    → 작업을 수행하기 위해 어떤 값들 필요하고 작업의 결과로 어떤 타입 반환 정보 제공
    (변경사항이 발생하지 않도록 신중하게 작성 필요)
    - 구현부 : 메서드의 선언부 다음에 오는 괄호 부분
    → `return`문은 반환타입과 일치하거나 자동 형변환이 가능한 것이어야함

- 메서드 내에 선언된 변수들을 그 메서드 내에서만 사용할 수 있으므로 서로 다른 메서드라면 같은 이름의 변수를 선언해도 된다.

- `main` 메서드는 프로그램 실행 시 OS에 의해 자동적으로 호출된다.

- 메서드 호출

    ```
    메서드이름(값1,값2)
    ```

- 같은 클래스 내의 메서드끼리 참조 변수 사용않고 호출 가능

- `static` 메서드는 같은 클래스 내의 인스턴스 메서드 호출 불가

- 호출시 입력한 인자들은 메서드에 각각 복사(대입)되어 들어간다.

    ```java
    long add(int a, int b) { ... }
    ```

- `return`문은 현재 실행중인 메서드를 종료하고 호출한 메서드로 되돌아간다.
(반환값의 유무에 관계없이 모든 메서드는 적어도 하나의 `return`문을 가지지만 반환타입이 `void`라면 컴파일러가 자동으로 메서드 마지막에 `return;`을 삽입해준다.)

- 메서드 구현부를 작성할 때, 가장 먼저 매개변수의 값이 적잘한것인지 확인 필요
(매개변수의 유효성 검사 중요)

- JVM의 메모리 구조

    응용프로그래밍 실행되면, JVM은 시스템으로부터 프로그램을 수행하는데 **필요한 메모리를 할당** 받고 JVM은 이 **메모리를 용도에 따라 여러 영역으로 나누어 관리**한다.

    ![6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8009.heic](6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8009.heic)

    주요 영역 3가지 존재

    1. 메서드 영역(`method area`) 
        - 프로그램 실행 중 클래스가 사용되면 JVM은 해당 클래스의 클래스 파일(*.class) 읽어서 분석
        - 클래스에 대한 정보(클래스 데이터) 이곳에 저장
        → 이 때, 클래스의 클래스 변수도 이 영역에 함께 생성된다.
    2. 힙(`heap`)
        - 인스턴스가 생성되는 공간
        - 생성되는 인스턴스는 모두 이 곳에 생성
        → 인스턴스 변수들이 생성된다.
    3. 호출스택(`call stack` 또는 `execution stack`)
        - 메서드의 작업에 필요한 메모리 공간을 제공
        - 메서드 호출 시, 호출스택에 호출된 메서드를 위한 메모리 할당
        (공간은 메서드가 작업을 수행하는 동안 지역변수들과 연산의 중간결과 등 저장하는데 사용)
        - 각 메서드들을 위한 메모리상의 작업공간을 서로 구별
        - 호출스택의 제일 상위에 위치하는 메서드가 현재 실행중인 메서드이며, 나머지는 대기 상태에 있게 된다.
        - 대기상태에 있던 호출한 메서드는 넘겨받은 반환값으로 수행을 계속 진행하게 된다.
        - 메서드 호출 순서

            → 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.

            → 메서드가 수행을 마치고 나면 사용했던 메모리를 반환하고 스택에서 제거된다.

            → 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.

            → 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.

            ![6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8011_2.heic](6%E1%84%8C%E1%85%A1%E1%86%BC%20%E1%84%80%E1%85%A2%E1%86%A8%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%B5%E1%84%92%E1%85%A3%E1%86%BC%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%84%86%E1%85%B5%E1%86%BC1%208023b746430944ffa22ab1021da9bf33/IMG_8011_2.heic)

- 메서드를 호출할 때 매개변수로 지정한 값들 메서드의 매개변수에 복사해 넘겨준다.

    → 기본형 : 기본현 값 복사

    → 참조형 : 인스턴스의 주소 복사

    ```
    기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.
    참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.
    ```

- 매개변수의 타입이 배열이면 참조형 매개변수이다.

- 메서드는 단 하나의 값만 반환할 수 있지만 참조형 매개변수의 성질을 이용하면 여러 개의 값을 반환받는 것과 같은 효과를 얻을 수 있다.

- 반환타입도 참조형으로 작성할 수 있다.

    → 모든 참조형 타입의 값은 '객체의 주소'로 반환타입이 참조형이라는 것은 메서드가 객체의 주소를 반환한다는 것을 의미한다.

    ```java
    static Data copy(Data d){
        Data tmp = new Data();
        tmp.x = d.x;

        return tmp;
    } 
    ```

    → 만약 반환을 안 해준다면 메서드가 종료되면서 객체의 참조가 사라지기에 이 객체를 사용할 방법이 없다.

- 호출된 메서드는 원래의 값이 아닌 복사된 값으로 작업하기 때문에 재귀호출 시 호출한 메서드와 관계없이 독립적인 작업수행이 가능하다.

- 재귀호출도 조건문이 필수적으로 따라다닌다.

- 반복문보다 재귀호출의 수행시간이 더 오래 걸린다.
(메서드를 호출하는 것은 매개변수 복사, 종류 후 복귀할 주소 저장 등 추가로 과정이 필요)

    → 그럼에도 사용하는 이유는 논리적 간결함때문이다.

- 재귀호출은 비효율적이므로 재귀 호출에 드는 비용보다 재귀호출의 간결하밍 주는 이득이 충분히 큰 경우에만 사용해야 한다

- 재귀 호출시 반환되는 값이 없다면 메서드가 종료되지 않아 스택에 계속 데이터만 쌓여가스택의 저장한계를 넘게 되고 `스택오버플로우 에러`를 발생시킨다.

    → 이 때문에 매개변수 유효성 검사가 중요하다

- `main` 메서드도 자기 자신을 호출하는 것이 가능하지만 아무런 조건 없이 계속 자기 자신을 다시 호출하기에 무한 호출에 빠진다.

- 인스턴스 메서드는 인스턴스 변수와 관련된 작업을 하는, 즉 메서드의 작업을 수행하는데 인스턴스 변수를 필요로 하는 메서드이다.

- 인스턴스와 관계없는 메서드를 클래스 메서드(`static method`)로 정의한다.
    1. 클래스 설계시 멤버 변수 중 모든 인스턴스에 공통으로 사용하는 것 `static`

        → 모든 인스턴스에서 같은 값 유지되어야 하는 변수는 클래스 변수로 정의

    2. 클래스 변수는 인스턴스를 생성하지 않아도 사용 가능

        → 클래스가 메모리에 올라갈 때 이미 자동적으로 생성된다.

    3. 클래스 메서드는 인스턴스 변수 사용 불가능

        → 인스턴스 생성없이 호출가능하므로 클래스 메서드가 호출되었을 때 인스턴스가 존재하지 않을 수 있음

        → 인스턴스 변수가 존재한다는 것은 `static` 변수가 이미 메모리에 존재하기에 반대의 경우에는 가능

    4. 메서드 내에서 인스턴스 변수 사용하지 않는다면 `static` 붙이는 것 고려

        → 메서드 호출시간이 짧아지므로 성능이 향상된다.

        → `static` 안 붙인 메서드는 실행 시 호출되어야 할 메서드르 찾는 과정이 추가적으로 필요하기에 시간 발생

    ```
    클래스의 멤버변수 중 모든 인스턴스에 공통된 값을 유지해야하는 것이 있는지 살펴 보고 있으면,
    static을 붙여준다.

    작성한 메서드 중에서 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에
    static을 붙일 것을 고려한다.(성능을 위해)
    ```

- 인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재하지만, 클래스 멤버가 존재하는 시저멩 인스턴스 멤버가 존재하지 않을 수 있기에 클래스 멤버가 인스턴스 멤버를 참조 호출하는 경우에는 인스턴스를 생성해야 한다.

- 클래스 멤버간의 참조 또는 호출은 문제가 없다.

- 인스턴스멤버간의 호출에는 아무런 문제가 없다
→ 하나의 인스턴스 멤버가 존재한다는 것은 인스턴스가 이미 생성되었다는 것을 의미하며, 다른 인스턴스멤버들도 모두 존재한다는 뜻이다.

# 오버로딩

- 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것

```
1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
```

→ 반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.

- 장점은 쉽게 예측이 가능하고 메서드의 이름을 절약할 수 있다.

- 가변인자란 메서드의 매개변수를 동적으로 지정해 줄 수 있는 기능이다.

    → 가변인자는 메서드 매개변수 마지막에 선언해야 한다.

- 가변인자를 가진 메서드를 호출할 때에는 인자의 개수를 가변적으로 줄 수 있고 인자가 아예 없어도 되고 배열도 인자가 될 수 있다.

    ```java
    String concatenate(String ...str){...}

    concatenate();
    concatenate("a", "b");
    concatenate(new String[]{"a", "b"});
    ```

- 가변인자는 내부적으로 배열을 이용해 가변인자가 선언되 메서드를 호출할 때마다 배열이 새로 생성된다.
→ 비효율이므로 꼭 필요한 경우에만 사용해야 한다.

- 매개변수 타입을 배열로 하면 반드시 인자를 지정하거나 `null`, 길이가 `0인 배열`로 넣어야 하지만 가변인자를 이용하면 인자를 생략할 수 있다.

    ```java
    String concatente(String[] str){...}

    concatente(new String[0]);
    concatente(null);//인자로 null을 지정
    concatente();//오류 발생
    ```

- 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋다

    → 가변인자를 선언한 메서드를 오버로딩하면, 메서드를 호출했을 때 구별되지 못하는 경우 발생

# 생성자

- 생성자도 메서드이기 떄문에 리턴값이 없다는 의미의 `void`를 붙여야 하지만 모든 생성자가 리턴값이 없으므로 `void`를 생략할 수 있게 되었다.

- 연산자 `new`가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.

    ```java
    Card c = new Card();
    ```

    1. 연산자 `new`에 의해 메모리(`heap`)에 `Card 클래스`의 인스턴스가 생성된다.
    2. 생성자 `Card()`가 호출되어 수행된다.
    3. 연산자 `new`의 결과로, 생성된 `Card`인스턴스 주소가 반환되어 참조변수 c에 저장된다.

    → 즉, `Card()` 가 생성자를 호출하는 것이다.

- 컴파일 시 소스파일(`*.java`)의 클래스에 생성자가 없다면 컴팡일러가 제공하는 기본 생성자가 추가되어 컴파일 된다.

    → 반드시 클래스 내에 생성자가 하나도 없을때 만 자동으로 생성해준다.

- 같은 클래스의 멤버들간에 서로 호출할 수 있는 것처럼 생성자 간에도 호출 가능
    - 생성자의 이름으로 클래스이름 대신 `this` 사용
    - 한 생성자에서 다른 생성자 호출시 반드시 첫줄에서만 호출
    (초기화 작업도중 다른 생성자 호출 시 다른 생성자를 호출하기 이전의 초기화 작업 무의미해질 가능성 존재로!!)

    → 두 조건 만족해야 함

- 같은 클래스 내의 생성자들을 일반적으로 깊은 관계

    → 서로 호출하도록 하여 유기적으로 연결시 더 좋은 코드 얻을 수 있음

- `this`는 참조변수로 인스턴스 자신을 가리킴

    → 참조변수를 통해 인스턴스의 멤버에 접근할 수 있는 것처럼 `this`로 인스턴스변수에 접근 할 수 있다.

    → 생성자를 포함한 모든 인스턴스 메서드에는 자신이 관련된 인스턴스를 가리키는 참조변수 this가 지역변수로 숨겨진 채 존재
    (숨겨진 이유는 `static` 메서드는 인스턴스와 관련 없는 작업을 하기때문에 인스턴스 정보 필요 없음, 인스턴스 메서드는 인스턴스와 관련있기에 필요하지만!)

```
this : 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.
			 모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재한다.

this(), this(매개변수) : 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
```

- 하나의 클래스로부터 생성된 모든 인스턴스의 메서드와 클래스 변수는 서로 동일하다

    → 인스턴스간의 차이는, 인스턴스마다 각기 다른 값을 가질 수 있는 인스턴스 변수 뿐이다!

```
인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야 한다.

1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?
```

# 변수의 초기화

```
멤버변수(클래스변수와 인스턴스변수)와 배열의 초기화는 선택적이지만,
지역변수의 초기화는 필수적이다.
```

- 멤버변수 : 초기화를 하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화 이루어짐
- 지역변수 : 사용하기 전 반드시 초기화 필요

- 멤버변수의 초기화 방법
    1. 명시적 초기화(`explicit initialization`)
        - 변수를 선언과 동시에 초기화 하는것
        - 우선적으로 고려

        ```java
        class Car{
        	int door = 4;//기본형 변수의 초기화
        	Engine e = new Engine();//참조형 변수의 초기화
        }
        ```

    2. 생성자(`constructor`)
    3. 초기화 블럭(`initialization block`)

        ```
        클래스 초기화 블럭 : 클래스변수의 복잡한 초기화에 사용
        인스턴스 초기화 블럭 : 인스턴스변수의 복잡한 초기화에 사용
        ```

        - 클래스 초기화 블럭

            → 클래스가 메모리에 처음 로딩될 때 한 번만 수행

        - 인스턴스 초기화 블럭

            → 생성자와 같이 인스턴스를 생성할 때 마다 수행
            (생성자보다 먼저 수행 된다.)

        ```java
        class InitBlock {
        	static {/* 클래스 초기화 블럭*/}
        	{/*인스턴스 초기화 블럭*/}
        }
        ```

        - 클래스의 모든 생성자에 공통으로 수행되어야 하는 문장들이 있을 때 사용
        → 재사용성을 높이고 중복 제거로 객체재향프로그래밍 추구 목표 달성

- 멤버변수의 초기화 시기와 순서
    - 초기화 시점

        → 클래스 변수 : 클래스가 처음 로딩될 때 단 한 번 초기화

        → 인스턴스 변수 : 인스턴스가 생성될 대마다 각 인스턴스별로 초기화

    - 초기화 순서

        → 클래스 변수 : 기본값 ⇒ 명시적초기화 ⇒ 클래스 초기화 블럭

        → 인스턴스 변수 : 기본값 ⇒ 명시적초기화 ⇒ 인스턴스 초기화 블럭 ⇒ 생성자

- 클래스가 이미 메모리에 로딩되어 있다면 또 다시 로딩X

    → 초기화도 다시 수행X

    → 클래스 로딩 시기는 JVM 종류에 따라 다를 수 있다