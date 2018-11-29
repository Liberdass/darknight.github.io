package javaNormal.generalT;

import common.Hero;

import java.util.List;

public class TestExtendsT {
    public static void print(List<? extends Hero> heroes){
        for(Hero hero : heroes){
            System.out.println(hero);
        }
    }
}
