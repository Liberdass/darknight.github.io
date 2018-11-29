package common;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.Serializable;

public class Hero implements Serializable, Comparable<Hero> {
    private long versionUID = 1L;
    public String name;
    public float hp;
    public float hpGrow;
    public float damage;

    public Hero() {
        int[] nums = new int[2];
        System.out.println(nums.length);
    }

    public Hero(String name) {
        double rand = Math.random();
        this.name = name;
        this.damage = (float) (1 - rand) * 20 + 40;
        hp = (float) (450 + rand * 150);
    }

    //回血
    public synchronized void recover() {
        while (true) {
            if (hp < 150) {
                hp = hp + 1;
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "加了血，血量当前为" + hp);
        }
    }

    //掉血
    public synchronized void hurt() {
        while (true) {
            if (hp > 1) {
                hp = hp - 1;
            } else {
                this.notify();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "扣了血，血量当前为" + hp);
        }
    }

    public void attack(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead())
            System.out.println(h.name + "死了！");
    }

    public void adugen() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++)
                    System.out.println("捞捞拳阿多跟 第" + i + "发");
            }
        };
        thread.start();
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

    public boolean damageCheck(Hero hero) {
        if (hero.damage > 50)
            return true;
        else
            return false;
    }

    public void test(int i) {
    }

    public int test(String i) {
        return Integer.parseInt(i);
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if (hp < anotherHero.hp)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return name + ": hp " + hp + ",damage " + damage + "\n";
    }
}
