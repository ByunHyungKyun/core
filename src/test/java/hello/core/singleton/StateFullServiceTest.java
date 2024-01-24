package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    void statefullServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFullService stateFullService1 = ac.getBean(StateFullService.class);
        StateFullService stateFullService2 = ac.getBean(StateFullService.class);

        //ThreadA : A사요자가 10000원 주문
        int user1 = stateFullService1.order("userA",10000);

        //ThreadA : B사요자가 20000원 주문
        int user2 = stateFullService2.order("userB",20000);

        //ThreadA: 사용자a 주문금액 조회
        //int price = stateFullService1.getPrice();
        System.out.println("price = " + user1);

    //    Assertions.assertThat(stateFullService1.getPrice()).isEqualTo(20000);

    }
    static class TestConfig{
        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }
    }

}