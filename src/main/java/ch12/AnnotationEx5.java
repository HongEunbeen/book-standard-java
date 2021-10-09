package ch12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("llll") // 유효하지 않은 애너테이션은 무시됨
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101", hhmmss="235050"))
public class AnnotationEx5 {
    public static void main(String[] args) {
        Class<AnnotationEx5> cls = AnnotationEx5.class;

        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);

        //AnnotationEx5 에 적용된 모든 애너테이션 가져옴
        Annotation[] annoArr = cls.getAnnotation();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FINAL;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
    String yymmdd();
    String hhmmss();
}

enum TestType{FIRST, FINAL}