package com.mz.test.spring01;

import com.mz.test.spring01.bean.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author on 9/24/19
 */
public class MyApplication {

    public static void main(String args[]) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "performer.xml");

        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();
    }

}
