# 12장 지네릭스, 열거형, 애너테이션

## 지네릭스(Generics)

- 지네릭스는 다양한 타입의객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크해주는 기능

```
지네릭스의 장점
1. 타입 안정성을 제공한다.
2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해진다.
```

→ 다룰 객체의 타입을 미리 명시해줌으로써 번거로운 형변환을 줄여준다.

### 선언

- 클래스, 메서드에 선언 가능
- `T`는 타입 변수로 기호의 종류만 다를 뿐 임의의 참조형 타입을 의미한다.
- 지네릭이 도입되기 이전의 코드와 호환을 위해, 지네릭 클래스인데도 예전의 방식으로 객체를 생성하는 것이 허용된다.

### 용어

```
Box<T> 지네릭 클래스, 'T의 Box' 또는 'T Box'라고 읽는다.
T 타입 변수 또는 타입 매개변수.(T는 타입문자)
Box 원시타입(raw type)
```

- `Box<String> b = new Box<String>();`
    - `Box<String>`  : 지네릭 타입 호출
    - `String` : 대입된 타입(매개변수화된 타입, 대입된 타입)
    
    → 컴파일 후 `Box<String>`과 `Box<Integer>`는 이들의 원시 타입인 `Box`로 변경되며 지네릭 타입이 제거된다.
    

### 제한

- 모든 객체에 대해 동일하게 동작해야 하는 `static` 멤버에 타입 변수 `T`를 사용할 수 없다.
    
    → `T`는 인스턴스 변수로 간주되고 `static` 멤버는 인스턴스변수를 참조할 수 없다.
    
    → `static` 멤버는 타입 변수에 지정된 타입, 즉 대입된 타입의 종류에 관계없이 동일한 것이어야 하기 때문
    
- 지네릭 타입의 배열을 생성하는 것도 허용되지 않는다.
    
    → `new` 연산자는 컴파일 시점에 타입 `T`가 뭔지 정확히 알아야 하지만 지네릭 타입은 어떤 타입이 될지 전혀 알 수 없다.
    
    → `new` 연산자 대신 `Reflection API`의 `newInstance()`와 같이 동적으로 객체를 생성하는 메서드로 배열을 생성하거나, `Object`배열을 생성해 복사한 다음 형변환하는 방법등을 사용
    
- `instanceof`연산자도 `new`연산자와 같은 이유로 `T`를 피연산자로 사용할 수 없다.

### 객체 생성과 사용

- 참조변수와 생성자에 대입된 타입(매개변수화된 타입)이 일치해야 한다.
- 두 지네릭 클래스의 타입이 상속관계에 있고, 대입된 타입이 같은 것은 괜찮다.
- JDK1.7 부터는 추정이 가능한 경우 타입을 생략할 수 있게 되었다.

### 제한된 지네릭 클래스

- 지네릭 타입에 `extends`를 사용하면, 특정 타입의 자손들만 대입할 수 있게 제한할 수 있다.
    
    → `class Box<T extends Fruit> { ... }`
    
- 클래스가 아니라 인터페이스를 구현해야 한다는 제약이 필요하다면, 이때도 `extends`를 사용
    
    → `implements`를 사용하지 않는다!
    
- `X`의 자손이면서 `Z`인터페이스도 구현해야 한다면 `&`기호로 연결한다.
    
    → `class Box<T extends X & Z> { ... }`
    

### 와일드 카드

- 지네릭 타입이 다른 것만으로는 오버로딩이 성립되지 않는다.
    
    → 지네릭 타입은 컴파일러가 컴파일할 때만 사용하고 제거해버리기에 메서드 중복 정의가 발생한다.
    
    → 이를 해결하기 위해 와일드 카드가 생겨났다.
    
- 와일드 카드는 어떠한 타입도 될 수 있다.
    
    → `?`를 사용하면 `Object`타입과 다를게 없으므로, `extends` `super`로 상한, 하한을 제한할 수 있다.
    

```
<? extends T> 와일드 카드의 상한 제한. T와 그 자손들만 가능
<? super T> 와일드 카드의 하한 제한. T와 그 조상들만 가능
<?> 제한 없음. 모든 타입이 가능. <? extends Object>와 동일
```

→ 지네릭 클래스와 달리 와일드 카드에는 `&` 사용 불가

- 주의할 점은 `<?>` 는 `<? extends Object>`를 줄여쓴 것이며, `<>` 안에 생략된 타입은 `?` 가 아닌 `Object`이다
    
    ```java
    Optional<?> EMPTY = new Optional<>(); // 성공.
    Optional<?> EMPTY = new Optional<?>(); // 에러. 미확인 타입의 객체는 생성불가
    Optional<?> EMPTY = new Optional<Obejct>(); // 성공. 첫번째 코드와 동일
    
    //예를 들면
    class Box<T extends Fruit>
    Box<?> b = new Box<>();
    Box<?> b = new Box<Fruit>(); // 위의 코드와 동일하다.
    ```
    

### 지네릭 메서드

- 메서드의 선언부에 지네릭 타입이 선언된 메서드를 지네릭 메서드라고 한다.
- 지네릭 타입의 선언 위치는 반환 타입 바로 앞이다.
- 지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드에 정의된 타입 매개변수는 전혀 별개의 것
- 지네릭 메서드는 지네릭 클래스가 아닌 클래스에도 정의될 수 있다.
- 메서드를 호출할 때는 타입 변수에 타입을 대입해야 하지만 컴파일러가 타입을 추정할 수 있기에 생략 가능
    
    ```java
    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    Juicer.<Fruit>mackJuice(fruitBox);
    
    //생략 버전
    Juicer.mackJuice(fruitBox);
    this.mackJuice(fruitBox);
    
    //생략 불가 버전
    <Fruit>mackJuice(fruitBox);
    ```
    
    - 주의할 점 : 대입된 타입을 생략할 수 없는 경우에는 참조변수나 클래스의 이름을 생략할 수 없다
        
        → 같은 클래스 내의 멤버들끼리는  `this.` 나 `클래스이름.` 을 생략하고 메서드 이름만을 호출 가능하지만, 대입된 타입이 존재할 시 반드시 써줘야 한다.(단지 기술적인 이유에 의한 규칙)
        
- `static` 멤버에는 타입 매개변수를 사용할 수 없지만, 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능

```java
class Main {
	static<T> void sort(List<T> list, Comparator<? super T> c{
		...
	}
}
```

→ 메서드 내에서만 지역적으로 사용될 것이므로 메서드가 `static`이건 아니건 상관X

→ 같은 이유로 내부 클래스에 선언된 타입 문자가 외부 클래스의 타입 문자와 같아도 구별될 수 있다.

### 지네릭 타입의 형변환

- 지네릭 타입과 넌지네릭(원시타입) 간의 형변환은 항상 가능하다
    
    → 다만, 경고 발생
    
    ```java
    Box box = null;
    Box<Object> box2 = null;
    
    //경고만 발생할 뿐 형변환 가능
    box = (Box) box2;//지네릭 타입 -> 원시 타입
    box2 = (Box<Object>)box;//원시 타입 -> 지네릭 타입
    ```
    
- 대입된 타입이 다른 지네릭 타입 간에는 형변환이 불가능하다
    
    ```java
    Box<String> box = null;
    Box<Object> box2 = null;
    
    //형변환 불가능 에러발생
    box = (Box<String>) box2;
    box2 = (Box<Object>) box;
    ```
    
- 와일드카드 지네릭 타입과 지네릭 타입간의 형변환은 가능하다.
(지네릭 메서드의 매개변수에 다형성 적용 가능)
    
    → 다만, 확인되지 않은 형변환이라는 경고 발생
    
    ```java
    Box<? extends Object> wBox = new Box<String>();
    ```
    
- 정리
    
    → `Optional<Object>`를 직접적으로 `Optional<String>`으로 형변환 불가능
    
    → `Optional<Object>`를 와일드 카드가 포함된 지네릭 타입으로 형변환 후 `Optional<String>`으로 형변환 가능(확인되지 않은 타입으로 형변환 경고 발생)
    
    ```java
    Optional<Object> -> Optional<T> // 형변환 불가
    Optional<Object> -> Optional<?> -> Optional<T> // 형변환 가능 (경고발생)
    ```
    
    → 와일드 카드가 사용된 지네릭 타입끼리도 형변환 가능(미확정 타입으로 형변환 경고 발생)
    
    ```java
    FruitBox<? extends Object> objBox = null;
    FruitBox<? extends String> strBox = null;
    
    strBox = (FruitBox<? extends String>)objBox;
    objBox = (FruitBox<? extends Object>)strBox;
    //와일드 카드는 타입이 확정된 타입이 아니므로 컴파일러는 미확정 타입으로 형변환하는 것이라고 경고
    ```
    

### 지네릭 타입의 제거

- 컴파일러는 지네릭 타입을 이용해서...
    - 소스파일 체크
    - 필요한 곳에 형변환을 넣어줌
    - 지네릭 타입 제거
- 컴파일된 파일(`.class`)에는 지네릭 타입에 대한 정보가 없다.
(지네릭 이전의 코드와의 호환성을 위해서)
- 지네릭 타입의 제거 과정
    1. 지네릭 타입의 경계를 제거
        
        → `<T>` 라면 `Object`로 치환되고 클래스 옆의 선언은 제거됨
        
    2. 지네릭 타입을 제거한 후 타입이 일치하지 않으면, 형변환을 추가

## 열거형(enums)

- 서로 관련된 상수를 편리하게 선언하기 위한 것
- 여러 상수를 정의할 때 사용하면 유용
- JDK1.5부터 새로 추가되었으며 C언어의 열거형보다 더 향상된 것으로 '`타입에 안전한 열거형`'이라 함
    
    → 열거형이 갖는 값뿐만 아닌 타입도 관리하기에 논리적인 오류 줄임
    
    → 실제 값이 같아도 타입이 다르면 컴파일 에러 발생
    
- 상수의 값이 바뀌면, 해당 상수를 참조하는 모든 소스 다시 컴파일 해댜 하지만, 열거형 상수 사용시, 기존의 소스 다시 컴파일 할 필요 없음

### 열거형의 정의와 사용

```java
//정의 방법
enum 열겨형 이름 { 상수명1, 상수명2, ... }

//사용 방법
class Unit {
	int x, y;
	Direction dir; //열겨형을 인스턴스 변수로 선언
	
	void init(){
		dir = Direction.EAST;
	}
}
```

- 정의 방법 : 괄호 안에 상수의 이름 나열
- 사용 방법
    - '열거형.상수명'으로 클래스의 `static` 변수를 참조하는 것과 동일
    - 열거형 상수간의 비교는 `==` 사용(`equals()`가 아닌 `==` 비교는 빠른 성능 제공 의미)
    - 동등 비교 연산자를 제외한 비교 연산자는 `compareTo()`로 사용(`<` `>` 사용 불가)
- 출력 방법
    - `values()` : 열거형의 모든 상수를 배열에 담아 반환하며 컴파일러가 자동으로 추가
    - `valuesOf()` : 열거형 상수의 이름으로 문자열 상수에 대한 참조 얻을 수 있으며 컴파일러가 자동으로 추가
        
        ```java
        static E values()
        static E valueOf()
        ```
        
    - `ordinal()` : 모든 열거형의 조상인 `java.lang.Enum`클래스에 정의된것으로 정의된 순서(0부터)를 정수로 반환

### 열거형에 멤버 추가하기

- 열거형 상수의 값이 불연속적인 경우 ordianl()은 사용하지 말고 열거형 상수의 이름 옆에 원하는 값을 함께 적어주면 됨(여러개 가능)
    
    ```java
    enum Direction { 
    	EAST(1), SOUTH(2), WEST(3), NORTH(4); //세미콜론 주의
    
    	private final int value; // 정수를 저장할 인스턴스 변수 추가
    	Direction(int value){this.value = value;}
    
    	public int getValue(){return value;}
    }
    ```
    
    - 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가해 주어야 함
        
        → 여러개 지정 시 그에 맞는 인스턴스 변수, 생성자 등 새로 추가해주어야 함
        
    - 순서 주의(열거형 상수 모두 정의 후 다른 멤버들 추가)
- 열거형에 새로운 생성자가 추가되어도 열거형의 객체를 생성할 수는 없음
    
    ```java
    Direction d = new Direction(1); //에러
    ```
    
    - 열거형의 생성자는 제어자가 묵시적으로 `private`이기 때문
- 열거형에 추상 메서드 추가 가능
    - 각 상수별로 값이 다를 경우 열거형에 추상 메서드를 선언하면 각 열거형 상수가 추상 메서드를 반드시 구현해야 함
    - `public abstract class Enum<E extends Enum<E>>` 은 추상메서드!

### 열거형의 이해

- 열거형은 내부적으로 상수 하나하나가 객체
    
    ```java
    enum Direction{EAST, SOUTH, WEST, NORTH}
    
    //위 eunm을 클래스로 정의한 것
    class Dirction{
    	static final Diretion EAST = new Direction("EAST");
    	static final Diretion SOUTH = new Direction("SOUTH");
    	static final Diretion WEST = new Direction("WEST");
    	static final Diretion NORTH = new Direction("NORTH");
    	
    	private String name;
    
    	private Direction(String name){
    		this.name = name;
    	}
    }
    ```
    
    → `static` 상수의 값은 객체의 주소이고 이 값은 변하지 않으니 `==` 비교가 가능한 것
    

## 애너테이션(annotation)

- 소스코드에 대한 무서를 따로 만들기보다 소스코드와 문서를 하나의 파일로 관리하는것이 편리하다는 생각해 주석을 달고 소스코드의 주석으로 부터 HTML문서를 생성해내는 프로그램(javadoc.exe) 사용했는데 이 기능을 응용한 것
- 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것
- 주석(compoennet)처럼 프로그래밍 언어에 영향을 미치지 않으면서 다른 프로그램에게 유용한 정보 제공 가능
    
    ```java
    @Test
    publci void method(){...}
    ```
    
    → 메서드를 테스트해야 한다는 것을 테스트 프로그램에 알리는 역할만 할 뿐, 메서드가 포함된 프로그램 자체에 영향 X (주석처럼 존재하지 않는 것이나 다름 없음)
    
- 애너테이션의 뜻은 주석, 주해, 메모
- 모든 프로그램에게 의미가 있는 것이 아닌, 해당 프로그램에 미리 정의된 종류와 형식으로 작성해야 의미 존재
    
    → `@Test`는 테스트 프로그램에게만 의미있는 정보
    
- JDK에서 기본 제공 하는 것과 다른 프로그램에서 제공하는 것 존재
    
    → 어느 것이든 그저 약속되 형식으로 정보를 제공하기만 하면 된다
    
    - JDK에서 제공하는 표준 애너테이션 : 주로 컴파일러에게 유용한 정보
    - 새로운 애너테이션 정의하는 메타 애너테이션

### 표준 애너테이션

1.  `@Override`
    - 역할 : 조상의 메서드를 오버라이딩하는 것이라는 걸 컴파일러에게 알려줌
    - 메서드 앞에만 붙일 수 있음
    - 오버라이딩 시 필수는 아니지만 알아내기 어려운 실수를 미연에 방지해주기에 반드시 사용하기
2. `@Deprecated`
    - 역할 : 대상이 다른 것으로 대체되었으니 더 이상 사용하지 않을 것을 권한다는 의미
    - JDK가 발전하면서 더 이상 사용되지 않는 필드나 메서드가 발생했는데 함부로 삭제할 수 없어 사용
    - 굳이 기존의 것을 사용하겠다면 말리지는 못하지만 가능하다면 이 애너테이션이 붙은 것들은 사용하지 않아야 함(강제성은 없음)
    - 사용시 컴파일 시 메시지
3. `@FunctionallInterface`
    - 역할 : 함수형 인터페이스 선언시 컴파일러가 올바르게 선언했는지 확인하고, 잘못된 경우 에러 발생
    
    ```java
    @FunctionallInterface
    public interface Runnable{
    	public abstract void run(); // 추상 메서드
    }
    ```
    
    - 필수는 아니지만 실수 방지 위해 반드시 사용
4. `@SuppressWarnings`
    - 역할 : 컴파일러가 보여주는 경고메시지가 묵인해야 하는 경우 나타나지 않게 억제함
    - 해당 대상에만 애너테이션을 붙여서 경고의 억제범위를 최소화하는 것이 좋음
    - 억제할 수 있는 메시지는 여러 종류 존재
        - `deprecation` : `@Deprecation` 붙은 대상을 사용해 발생하는 경고
        - `unchecked` : 지네릭스로 타입을 지정하지 않았을 경우 발생하는 경고
        - `rawtypes` : 지네릭스를 사용하지 않아 발생하는 경고
        - `varargs` : 가변인자의 타입이 지네릭 타입일 때 발생하는 경고
    - 억제하려는 경고 메시지를 애너테이션의 뒤에 괄호 안에 문자열로 지정
        
        ```java
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList<>();
        list.add(obj); //여기서 경고 발생하지만 경고 억제
        
        //둥 이상일 경우 배열처럼 괄호 이용해 추가
        //@SuppressWarnings({"unchecked", "varargs"})
        ```
        
5. `@SafeVarargs`
    - 역할 :  메서드에 선언된 가변인자의 타입이 `non-reifiable` 타입일 경우 발생하는 `unchecked` 경고 억제
        
        → reifiable : 컴파일 후에도 제거되지 않는 카입
        
         → non-reifiable : 컴파일 후에 제거되는 타입
        
    - `static`이나 `final`이 붙은 메서드와 생성자에만 붙일 수 있음
        
        → 오버라이딩될 수 있는 메서드에는 사용할 수 없다
        
    - 메서드 선언 시 사용하면 메서드를 호출하는 곳에서 발생하는 경고도 억제
        
        → `@SuppressWarnings("unchecked")` 사용 시 메서드 호출되는 곳에도 애너테이션 사용
        
    - `@SuppressWarnings("varargs")` 를 같이 사용함
        
        → `@SafeVarargs`로 '`unchecked`' 경고는 억제할 수 있지만 '`varargs`'경고는 억제할 수 없기 때문이다.
        
        ```java
        @SafeVarargs // 'unchecked' 경고를 억제한다
        @SuppressWarnings("varargs") // 'varargs' 경고를 억제한다
        public static <T> List<T> asList(T... a){
        	return new ArrayList<>(a);
        }
        ```
        

### 메타 애너테이션

- 애너테이션을 위한 애너테이션
- 애너테이션에 붙이는 애너테이션으로 애너테이션을 정의할 때 적용대상이나 유지기간등을 지정하는데 사용
- `java.lang.annotation` 패키지에 포함되어 있음

1. `@Target`
    - 애너테이션이 적용가능한 대상을 지정하는데 사용
    
    ```java
    @Target({FIELD, TYPE, TYPE_USE})
    public @interface MyAnnotation(}
    
    @MyAnnotation // 적용대상 : type
    class MyClass{
    	@MyAnnotation // 적용 대상 : field
    	int i;
    
    	@MyAnnotation // 적용 대상 : type_use
    	MyClass mc;
    }
    ```
    
    → `ANNOTATION_TYPE` : 애너테이션
    
    → `CONSTRUCTOR` : 생성자
    
    → `FIELD` : 필드(멤버변수, enum 상수)
    
    - 기본형에 사용
    
    → `LOCAL_VARABLE` : 지역변수
    
    → `METHOD` : 메서드
    
    → `PACKAGE` : 패키지
    
    → `PARAMETER` : 매개변수
    
    → `TYPE` : 타입(클래스, 인터페이스, enum)
    
    → `TYPE_PAREMETER` : 타입 매개변수
    
    → `TYPE_USE` : 타입이 사용되는 모든 곳
    
    - 참조형에 사용
2. `@Retention`
    - 애너테이션이 유지되는 기간을 지정하는데 사용
    
    → `SOURCE` : 소스 파일에만 존재, 클래스 파일에는 존재하지 않음
    
    - 컴파일러가 사용하는 애너테이션의 유지정책
    - 컴파일러를 직접 작성할 것 아니면 필요없음
    
    → `CLASS` : 클래스 파일에 존재, 실행시에 사용 불가. 기본값
    
    - 컴파일러가 애너테이션의 정보를 클래스 파일에 저장할 수 있게 한다
    - 클래스 파일이 JVM에 로딩될 때는 애너테이션의 정보가 무시되어 실행 시에 정보를 얻을 수 없음
    - 기본값이지만 잘 사용하지 않음
    
    → `RUNTIME` : 클래스 파일에 존재, 실행시에 사용가능
    
    - 실행 시에 리플렉션을 통해 클래스 파일에 저장된 애너테이션의 정보를 읽어 처리 가능
3. `@Documented`
    - 애너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 함
    - 자바 기본 애너테이션 중 `@Override` `@SuppressWarning` 제외하고 모두 애너테이션 붙어있음
4. `@Inherited`
    - 애너테이션이 자손 클래스에 상속되도록 함
5. `@Repeatable`
    - 하나의 대상에 한 종류의 애너테이션을 붙이지만 이 애너테이션이 붙은 애너테이션은 여러 번 붙일 수 있다.
    - 같은 이름의 애너테이션이 여러 개가 하나의 대상에 적용되니 이 애너테이션을 하나로 묶어 다룰 수 있는 애터네이션도 추가로 정의해야 함
    
    ```java
     @interface ToDos { // 여러 개의 ToDo애너테이션을 담을 컴테이너 애너테이션 
    	ToDo[] value(); // 배열 타입의 요소를 value로 선언(이름 고정임!)
    }
    
    @Repeatable(ToDos.class)
    @interface ToDo { 
    	String value();
    }
    ```
    
6. `@Native`
    - 네이티브 메서드에 의해 참조되는 상수 필드에 붙이는 애너테이션
    - 네이티브 메서드 : JVM이 설치된 OS의 메서드(`Object`의 메서드들도 네이티브 메서드이다.)

### 애너테이션 타입 정의하기

- @ 기호를 붙이는 것을 제외하면 인터페이스를 정의하는 것과 동일
    
    ```java
    @interface 애너테이션 이름 { 
    	타입 요소이름(); // 애너테이션의 요소를 선언
    }
    ```
    
    → `@Override`는 애너테이션이고 `Override`는 애너테이션의 타입이다.
    
- 애너테이션의 요소 : 애네테이션 내에 선언된 메서드
    - 반환값이 있고 매개변수는 없는 추상 메서드의 형태를 가지고, 상속을 통해 구현하지 않아도 된다.
    - 애너테이션 적용 시 요소들의 값을 빠짐없이 지정해주어야 함(순서 상관x)
    - 각 요소는 기본값을 가질 수 있고, 기본값 존재 요소는 애너테이션 적용 시 지정 X 가능
    - 요소가 오직 하나이고 이름이 `value`인 경우, 애너테이션 적용 시 이름 생략 후 값만 명시 가능
    - 요소의 타입이 배열인 경우 괄호 사용해 여러 개의 값 지정
- `java.lang.annotation.Annotation` : 모든 애너테이션의 조상
    - 애너테이션은 상속이 허용되지 않음(명시적으로 extends 사용 불가)
    - Annotation은 애너테이션이 아닌 일반적인 인터페이스로 정의되어 있음
    - 모든 애터테이션 객체에 대해 메서드를 호출 가능
- 마커 애너테이션 : 요소가 하나도 정의되지 않은 애너테이션
    - 값을 지정할 필요가 없는 경우, 요소 정의 하지 않아도 됨
- 애너테이션 요소의 규칙
    
    ```
    - 요소의 타입은 기본형, String ,enum, 애너테이션, Class만 허용된다.
    - ()안에 매개변수를 선언할 수 없다.
    - 예외를 선언할 수 없다
    - 요소를 타입 매개변수로 정의할 수 없다.
    ```