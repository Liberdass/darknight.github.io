package javaNormal.thread.synchronizedTest;

import common.Hero;

public class DeadLock {
    public static void main(String[] args) {
        Hero karthus = new Hero("死歌");
        Hero teemo = new Hero("提莫");
        Hero lee = new Hero("李青");

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                synchronized(karthus){
                    System.out.println("死歌:"+karthus);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("开始占领提莫");
                    synchronized (teemo){
                        System.out.println("占领了提莫");
                    }
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                synchronized(teemo){
                    System.out.println("提莫:"+teemo);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("开始占领李青");
                    synchronized (lee){
                        System.out.println("占领了李青");
                    }
                }
            }
        };
        thread2.start();

        Thread thread3 = new Thread(){
            @Override
            public void run(){
                synchronized(lee){
                    System.out.println("李青:"+lee);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("开始占领死歌");
                    synchronized (karthus){
                        System.out.println("占领了死歌");
                    }
                }
            }
        };
        thread3.start();

        Thread timeThread = new Thread(){
            @Override
            public void run(){
                int i = 0;
                while (true){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("时间过去了"+ ++i + "秒");
                }
            }
        };
        timeThread.setDaemon(true);
        timeThread.start();
    }
}
