package javaNormal.lambda;

import common.Hero;
import common.HeroChecher;

import java.util.ArrayList;
import java.util.List;

public class HelloLambda {
    public static void main(String[] args) {
        List<Hero> heroes = initHero(10);
        System.out.println("heroes:\n"+heroes);

        filter(heroes, h -> h.hp > 500 && h.damage < 50);
        System.out.println("__________________");
        filter2(heroes, h1-> h1.hp < 500);

    }

    private static void filter(List<Hero> heros, HeroChecher checker) {
        for (Hero hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }

    private static void filter2(List<Hero> heros, HeroChecher checker) {
        List<Hero> hs = initHero(20);
        for (Hero hero : hs) {
            if (checker.test(hero) )
                System.out.print(hero);
        }
    }

    public static List<Hero> initHero(int num){
        List<Hero> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            list.add(new Hero("Hero "+i));
        }
        return list;
    }
}
