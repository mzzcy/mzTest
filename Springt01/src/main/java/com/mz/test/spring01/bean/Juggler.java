package com.mz.test.spring01.bean;

/**
 * @author changyin.zhao on 9/24/19
 */
public class Juggler implements Performer {

    private int beanBags = 3;

    public Juggler() {

    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws Exception {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");

    }
}
