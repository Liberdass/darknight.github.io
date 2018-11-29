package javaNormal.thread.synchronizedTest;

import common.Hero;

public class WaitAndNotify {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 100f;

        Thread hurt = new Thread(){
            @Override
            public void run(){
                gareen.hurt();
            }
        };
        hurt.setPriority(Thread.MIN_PRIORITY);
        hurt.start();

        Thread recover = new Thread(){
            @Override
            public void run(){
                gareen.recover();
            }
        };
        recover.setPriority(Thread.MAX_PRIORITY);
        recover.start();
    }
}
