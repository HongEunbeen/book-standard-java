# 4장 조건문과 반복문

- `Switch`문의 제약조건

    → 조건식 결과는 정수 또는 문자열이어야 한다.

    → case문의 값은 정수 상무낭 가능하며 중복은 허용하지 않는다.
    (ex. 문자 리터럴, 정수 상수 OK / 변수, 실수 X)

- 향상된 `for` 문

    ```java
    for(타입 변수명 : 배열 또는 컬렉션){
    	//반복할 문장
    }
    ```

    → 배열이나 컬렌션에 저장된 요소들을 읽어오는 용도로만 사용 가능

- 이름 붙은 반복문

    → 반복문에 이름을 붙여주고 `break` 문에 반복문 이름 지정하면 하나 이상의 반복문 벗어나기 가능

    → 중첩 반복문 앞에 이름을 붙이고 `break`문과 `continue` 문에 이름을 지정해 하나 이상의 반복문을 벗어나거나 반복을 건너 뛸 수 있다.

    ```java
    Loop1 : 
    for(int i=2; i <=9; i++){
      for(int j =1; j <=9; j++){
          if(j==5)
              break Loop1;
              //break;
              //continue Loop1;
              //continue ;
          System.out.println(i + "*" +j + "=" + i*j);
      }//end of for i
      System.out.println();
    }//end ot Loop1
    ```