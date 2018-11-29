package javaNormal.thread;

import common.Hero;

public class KillThread extends Thread{
    private Hero hero1 ;
    private Hero hero2 ;

    public KillThread(Hero h1, Hero h2){
        this.hero1 = h1;
        this.hero2 = h2;
    }

    public void run(){
        while(!hero2.isDead()){
            hero1.attack(hero2);
        }
    }
}
