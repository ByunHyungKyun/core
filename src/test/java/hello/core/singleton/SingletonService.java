package hello.core.singleton;

import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;

public class SingletonService {

    private static final  SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //외부에서 생성하지 목하게 private으로 설정하여 막는다 --> 아주 종요!
    private  SingletonService (){

    }


    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
