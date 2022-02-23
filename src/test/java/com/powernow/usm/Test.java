package com.powernow.usm;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.0
 * @className Test
 * @description TODO
 * @date 2019-5-20 10:59
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = UsmKingdomImApplication.class)
public class Test {


    @org.junit.Test
    public void test(){

    }

    public static void main(String[] args) {
    }
}
