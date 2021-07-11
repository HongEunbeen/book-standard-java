# 9장 java.lang패키지와 유용한 클래스

- java.lang 패키지는 자바프로그래밍에 가장 기본이 되는 클래스를 포함하고 있기에 import 문 없이도 사용할 수 있다.

# Object 클래스

- Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 멤버들은 모든 클래스에서 바로 사용 가능하다.

- Object 클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있다.
    - protected Object clone()
    - public boolean equals(Object obj)
    - protected void finalize()
    - public Class getClass()
    - public int hasCode()
    - public String toString()
    - public void notify()
    - public void nofityAll()
    - public void wait()
    - public void wait(long timeout)
    - public void wait(long timeout, int nanos)

### equlas(Object obj)

- 매개변수로 객체의 참조변수를 받아 비교해 결과를 boolean으로 알려준다.

    ```java
    public boolean equals(Object obj){
    	return (this == obj);
    }
    ```

- 두 개의 참조변수가 같은 객체를 참조하고 있는지, 즉 참조변수에 저장된 값(주소값)이 같은지를 판단하는 기능밖에 할 수 없다.

    → 참조 변수의 주소값을 같은지 판단만 하지 참조 변수가 가리키는 객체가 같은지는 알 수 없다.

- 참조 변수가 가리키고 있는 객체의 value가 같은지 확인하기 위해선 equals 메서드를 오버라이드 해야 한다.

    ```java
    public boolean equals(Object obj){
    	if(obj != null && obj instanceof Person){
    		return id == ((Person)obj).id;
    	}
    	else{
    			return false;
    	}
    }
    ```

    - String클래스에서 역시 Object 클래스의 equals를 오버라이딩해서 String 인스턴스가 갖는 문자열 값을 비교하도록 되어있다.

        → String, Date, File, wapper 클래스들도 다 오버라이딩 되어있음

        → StringBuffer 클래스는 오버라이딩 되어 있지 않음!

### hashCode()

- 해싱 기법에 사용되는 해시함수를 구현한 것이다.

    → 해싱 :  데이터 관리 기법 중의 하나로 다량의 데이터를 저장하고 검색하는 데 유용하다.

    → 해시함수 : 찾고자하는 값을 입력하면 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.

- 32bit JVM : 서로 다른 두 객체는 결코 같은 해시코드르르 가질 수 없음
- 64bit JVM : 8 byte 주소값으로 해시코드(4byte)를 만들기 때문에 해시코드가 중복될 수 있음

- 만약, 클래스의 인스턴스변수 값으로 객체의 같고 다름을 판단해야 하는 경우라면 equals 메서드와 함께 오버라이딩 해주어야 한다.

    → 같은 객체라면 hashCode() 호출 시 결과값인 해시코드가 같아야 한다.

    ```java
    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode());

    System.out.println(System.identityHashCode(str1));
    System.out.println(System.identityHashCode(str2));
    ```

    → String 클래스는 hashCode 오버라이딩 해서 같은 값이 나오지만 System.identityHashCode() 는 Object클래스의 hashCode 메서드처럼 객체의 주소값으로 해시코드 생성하기에 모든 객체에 대해 항상 다른 해시코드값을 반환할 것을 보장한다.

### toString()

- 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의

- 인스턴스의 정보 제공 : 인스턴스 변수에 저장된 값들을 문자열로 표현

    → 만약, toString()을 오버라디이 하지 않고 호출한다면 클래스이름에 16진수의 해시코드 값 얻는다.

    ```java
    public String toString(){
    	return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }
    ```

    - String 클래스 toString() : String 인스턴스가 갖고 있는 문자열 반환하도록 오버라이딩

        ```java
        String str = "KOREA";

        System.out.println(str);//KOREA
        System.out.println(str.toString());//KOREA
        ```

    - Date 클래스 toString() : Date 인스턴스가 갖고 있는 날짜와 시간을 문자열로 반환하도록 오버라이딩

        ```java
        java.util.Date today = new java.util.Date();

        System.out.println(today);//Fri Oct 23 21:21:21 KST 2021
        System.out.println(today.toString());//Fri Oct 23 21:21:21 KST 2021
        ```

- toString()은 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환하여 반환하도록 오버라이딩 되는게 일반적이다.

     →오버라이딩 시 주의할 점은 Object 클래스에 정의된 toString()은 public 이기에 오버라이딩 시 접근 제어자를 반드시 public 으로 해주어야 한다.
    (조상에 정의된 메서드르르 자손에서 오버라디이 시 접근범위 제한됨)

### clone()

- 자신을 복제하여 새로운 인스턴스를 생성하는 일을 한다.

    → 작업이전의 값이 보존되므로 작업에 실패 시 복원에 도움된다.

- Object 클래스에 정의된 Clone()은 단순히 인스턴스변수의 값만 복사한다.(얕은 복사)

    → 배열의 경우 clone 메서드를 오버라이딩해 새로운 배열 생성 후 배열의 내용 복사 필요

- clone()을 사용하기 위한 전제 조건
    - Cloneable 인터페이스를 구현한 클래스
    (인터페이스를 구현하지 않은 클래스 내에서 호출되면 예외 발생)

        → Clonable 인터페이스를 구현한 클래스의 인스턴스만 clone()을 통한 복제 가능

        → 이유는 인스턴스 데이터 보호하기 위해서
        (인터페이스가 구현되어 있으면 클래스 작성자가 복제를 허용한다는 뜻!)

    - clone() 오버라이딩시 접근 제어자 public으로 변경

        → clone()은 protected이기 때문에 상속관계가 없는 다른 클래스에서 clone을 호출가능

### 공변 반환타입

- JDK1.5부터 추가되었고 오버라이딩 시 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것

- 공변 반환타입 사용 방법
    1. 반환 타입을 자식 타입으로 선언
    2. 자식 타입으로 형변화해서 return

- 사용하면 조상의 타입이 아닌 실제로 반환되는 자손 객체의 타입으로 반환가능해 번거로운 형변환이 줄어든다.

- 배열 복사
    - 배열도 객체이기 때문에 Object 클래스 상속 받고 Cloneable 인터페이스와 Serializable 인터페이스가 구현되어 있다.

### 얕은 복사와 깊은 복사

### getClass()

- 자신이 속한 클래스의 Class 객체를 반환하는 메서드

    → Class 객체는 이름이 Class인 클래스의 객체

    ```java
    public final class Class implements ... { //Class 클래스
    	...
    }
    ```

- 클래스 객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 조재한다.

    → 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 자동으로 생성

    → 클래스 로더는 실행 시 필요한 클래스를 동적으로 메모리에 로드하는 역할

    → 즉, 파일 형태로 저장되어 있는 클래스를 읽어서 Class 클래스에 정의된 형식으로 변환하는 것으로 클래스 파일을 읽어 사용하기 편한 형태로 저장해 놓은 것이 클래스 객체이다.

### Class객체를 얻는 방법

- 클래스의 정보가 필요할 때 Class 객체에 대한 참조를 얻어와야 하는데 방법 여러개 존재

    → 생성된 객체로부터 얻는 방법

    ```java
    Class obj = new Card().getClass();
    ```

    → 클래스 리터럴로 부터 얻는 방법

    ```java
    Class obj = Card.class;
    ```

    → 클래스 이름으로 부터 얻는 방법

    ```java
    Class obj = Class.forName("Card");
    ```

- 클래스 객체를 사용하면 클래스에 정의된 멤버의 이름이나 개수 등, 클래스에 대한 모든 정보를 얻을 수 있기에 Class 객체를 통해 객체를 생성하고 메서드를 호출하는 등 보다 동적인 코드 작성 가능

# String 클래스

- 자바에서는 문자열을 위한 클래스를 제공한다.

### 변경 불가능한 클래스

- 문자열을 저장하기 위해 문자형 배열 참조변수를 인스턴스 변수로 정의

    ```java
    public final class String implements java.io.Serializable, Comparable {
    	private char[] value;
    	...
    }
    ```

    → 인스턴스 생성 시 생성자의 매개변수로 받는 문자열이 이 인스턴스 변수에 문자형 배열로 저장된다.

- 문자열간의 결합이나 추출 등 문자열을 다루는 작업은 기존 인스턴스 내의 문자열이 바뀌는 것이 아닌 새로운 문자열이 담긴 인스턴스가 생성된다.

    → String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경은 불가한다.

### 문자열의 비교

- 문자열을 만드는 방법은 두 가지

    → 문자열 리터럴을 지정하는 방법

    ```java
    String str = "abc";
    ```

    - 문자열 리터럴은 클래스가 메모리에 로드될 때 자동적으로 미리 생성되기에 이미 존재한다면 재사용한다.

    → String 클래스의 생성자를 사용해서 만드는 방법

    ```java
    String str = new String("abc");
    ```

    new 연산자에 의해 메모리 할당이 이루어진기에 항상 새로운 Stringd 인스턴스가 생성된다.

### 문자열 리터럴

- 자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된다.

    → 이때, 같은 내용의 문자열 리터럴은 한 번만 저장됨

    → 문자열 리터럴도 String 인스턴스이고, 한 번 생성하면 내용을 변경할 수 없으니 하나의 인스턴스로 공유하면 된다.

- 클래스 파일에는 소스파일에 포함된 모든 리터럴의 목록이 있고 해당 클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 이 리커러러의 목록에 있는 리터럴들이 JVM에 있는 상수 저장소(constant pool)에 저장된다.

### 빈 문자열

- char 형 배열도 길이가 0인 배열을 생성할 수 있고, 이 배열은 내부적으로 빈 문자열을 가지고 있다.

    → 하지만 char형 변수에는 반드시 하나의 문자를 지정해야 한다...

- 변수 선언 시 기본값으로 초기화 되지만 String은 참조형 타입의 기본값인 null보다는 빈 문자열로, char 형은 기본값인 'u\0000' 대신 공백으로 초기화 하는 것이 보통이다.

### join()과 StringJoiner

- join() : 여러 문자열 사이에 구분자를 넣어서 결합

### 유니코드의 보충문자

- 문자를 다루는 메서드에서 매개변수 타입이 char int 가 혼합되는 이유는 확장된 유니코드를 다루기 위해서이다.

- 유니코드는 원리 2byte로 16비트 문자체계인데 30비트로 확장하게 되면서 하나의 문자를 char타입으로 다루지 못하고, int 타입으로 다루게 되었다.

- 확장에 의해 새로 추가된 문자들을 보충 문자라고 하고 String 클래스의 메서드 중에서 보충 문자 지원하는 하는 것이 있고 지원하지 않는 것이 있는데 구별하는 방법은 매개변수가 int 인 것들은 지원한다.

### 문자 인코딩 변환

- getBytes(String charsetName)를 사용하면, 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다.

- 자바는 UTF-16을 사용

    → 문자열 리터럴에 포함되는 문자들은 OS의 인코드를 사용

### 기본형 값을 String으로 변환

- 성능은 valueOf()가 더 좋지만, 빈 문자열을 더하는 방법이 간단 편리하기에 성능향상이 필요한 경우에만 valueOf()를 사용하자.

    ```java
    int i = 100;
    String str = i + "";
    String str1 = String.valueOf(i);
    ```

### String을 기본형 값으로 변환

- 메서드의 이름을 통일하기 위해 valueOf()가 나중에 추가되었다.

    → valueOf()

    → parseXXX()

→ 이 둘은 반환타입만 다르지 같은 메서드이다.

- parseInt(), parseFloat()같은 메서드는 문자열에 공백 또는 문자가 포함되어 있으면 변환시 예외가 발생할 수 있다.

    → 문자열을 숫자로 변환하는 과정에서 예외가 발생하기 쉽기 때문에 주의를 기울여야  한고, 예외가 발생했을 때으 처리를 적절히 해주어야 한다.

# StringBuffer클래스와 StringBuilder클래스

- StringBuffer는 내부적으로 문자열 편집을 위한 버퍼를 가지고 있으며, StringBuffer 인스턴스를 생성할 때 그 크기를 지정할 수 있다.

    → 편집할 문자열의 길이를 고려해  버퍼의 길이를 충분히 잡아주는 것이 중요
    (편집 중인 문자열이 버퍼의 길이를 넘어가면 버퍼의 길이를 느려주는 작업이 추가로 수행되어야 한다.!)

### StringBuffer의 생성자

- char형의 배열이 생성되고 이 배열은 문자열을 저장하고 편집하기 위한 공간으로 사용된다.

    ```java
    public StringBuffer(int length){
    	value = new char[length];
    	shared = false;
    }

    public StringBuffer(){
    	this(16);
    	//버퍼의 크기를 지정하지 않으면 버퍼의 크기는 16으로 지정된다.
    }

    public StringBuffer(String str){
    	this(str.length() + 16 );
    	append(str);
    }
    ```

- 버퍼의 크기가 문자열의 길이보다 작을 때는 내부적으로 버퍼의 크기를 증가시키는 작업이 수행된다.

    → 배열의 길이는 변경될 수 없으므로 새로운 길이의 배열을 생성한 후에 이전 배열의 값을 복사해야 한다.

- append()의 반환값이 StringBuffer()이기에 계속 문자열의 주소를 반환하고 append()를 호출하기에 변경이 가능하다.

### StringBuffer의 비교

- StringButter클래스는 equals메서드를 오버라디이 하지 않으므로 equals와 등가비교연산자의 결과값은 같다.

    → 하지만 toString()은 오버라이딩이 되어 있기에 StringBuffer인스턴스에 toString()을 호출하면 담고 잇는 문자열을 String으로 반환한다.

### StringBuilder란?

- StringBuffer는 멀티쓰레드에 안전하도록 동기화 되어 있지만 동기화가 StringBuffer의 성능을떨어뜨린다.

    → 멀티쓰레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 불필요하게 성능만 떨어뜨리게 된다.

- StringBuilder는 StringBuffer에서 쓰레드의 동기화만 뺀 클래스이다.

    →하지만 StringBuffer도 성능이 좋기때문에 성능향상이 반드시 필요한 경우를 제외하고 기존에 작성한 코드에서 StringBuffer를 Stringbuilder로 굳이 바꿀 필요는 없다.

# Math 클래스

- 기본적인 수학계산에 유용한 메서드로 구성되어 있고 생성자는 접근 제어자가 private이기에 다른 클래스에서 Math인스턴스를 생성할 수 없다.

    → 클래스 내에 인스턴스변수가 하나도 없어서 인스턴스를 생성할 필요가 없다.
    (Math클래스의 메서드는 모두 static이며, 상수는 두 개만 존재)

    ```java
    public static final double E = ; //자연로드의 밑
    public static final double PI = ;//원주율
    ```

- 예외를 발생시키는 메서드

    → 메서드 이름에 Exact가 포함된 메서드들은 정수형 연산간의 연산에서 발생할 수 있는 오버플로우를 감지하기 위한 것이다.

    → 연산자는 단지 결과를 반환할 뿐, 오버플로우의 발생여부에 대해 알려주지 않지만 메서드를 사용하면 예외를 발생시켜 준다.

- StrictMath클래스
    - Math 클래스는 최대한의 성능을 얻기 위해 JVM이 설치된 OS의 메서드를 호출해 사용
    (즉, OS에 의존적인 계산을 하고 있다.)

        → 부동소수점 계산의 경우 반올림의 처리방법이 OS 마다 다르다.

    - 이러한 차이를 없애기 위해 성능을 포기하고 어떤 OS에서 실행되어도 항상 같은 결과를 얻도록 Math클래스를 새로 작성한 것이 StraictMath클래스이다.

# 래퍼 클래스

- 객체지향 개념에서 모든 것은 객체로 다루어져야 하지만 높은 성능을 위해 자바에서는 8개의 기본형을 객체지향적임을 포기시켰다.

- 8개의 기본형을 대표하는 8개의 래퍼클래스가 존재하는데 이를 이용하면 기본형 값을 객체로 다룰 수 있다.

- 래퍼 클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값을 인자로 받는다.

    → 주의할 점은 생성자의 매개변수로 문자열을 제공할 때 각 자료형에 알맞는 문자열을 사용해야 한다.

- 래퍼 클래스들은 모두 equals()가 오버라이딩되어 있어 주소값이 아닌 객체가 가지고 있는 값을 비교한다.

- 오토박싱 & 언박싱

    → 자바 언어의 규칙이 바뀐게 아닌 컴파일러가 자도응로 변환하는 코드를 넣어주기 때문에 기본형과 참조형 간의 연산이 가능해졌다.

    - 오토박싱 : 기본형 값 ⇒ 래퍼 클래스
    - 언박싱 : 래퍼 클래스 ⇒ 기본형 값

    → ex) ArrayList에 숫자를 저장 및 꺼낼 때 변환X