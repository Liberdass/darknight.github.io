package javaNormal.thread.adugen;

import common.Hero;

public class TestThread {
    public static void main(String[] args) {
        Hero gareen = new Hero("盖伦");
        Hero teemo = new Hero("提莫");
        Hero lucky = new Hero("赏金");
        Hero lee = new Hero("李青");
        Hero karthus = new Hero("死歌");
        Hero luxy = new Hero("拉克丝");

        System.out.println(gareen+""+teemo+lucky+lee+karthus+luxy);

//        KillThread killThread1 = new KillThread(gareen,teemo);
//        killThread1.setPriority(Thread.NORM_PRIORITY);
//        killThread1.setDaemon(true);
//        killThread1.start();
//        Battle battle = new Battle(lucky,lee);
//        new Thread(battle).start();
//        Thread thread = new Thread(){
//            @Override
//            public void run(){
//                while (!luxy.isDead()){
//                    Thread.yield();
//                    karthus.attack(luxy);
//                }
//            }
//        };
//        thread.setPriority(Thread.NORM_PRIORITY);
//        thread.setDaemon(true);
//        thread.start();
        Hero util = new Hero();
        try {
            while (true) {
                util.adugen();
                System.out.println("集气1秒");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
