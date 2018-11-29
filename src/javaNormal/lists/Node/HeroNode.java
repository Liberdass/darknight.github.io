package javaNormal.lists.Node;

import common.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero hero;

    public void add(Hero h) {
        if (null == hero){
            this.hero = h;
        }else {
            if(h.hp <= hero.hp){
                if(null == leftNode){
                    leftNode = new HeroNode();
                }
                leftNode.add(h);
            }
            if(h.hp > hero.hp){
                if(null == rightNode){
                    rightNode = new HeroNode();
                }
                rightNode.add(h);
            }
        }
    }

    public List<Hero> hpLowToHighSort(){
        List<Hero> list = new ArrayList<>();
        if(null != leftNode){
            list.addAll(leftNode.hpLowToHighSort());
        }
        list.add(hero);
        if(null != rightNode){
            list.addAll(rightNode.hpLowToHighSort());
        }
        return list;
    }

    public static void main(String[] args) {
        HeroNode root = new HeroNode();
        Hero[] heroes = new Hero[10];
        for(int i = 0; i < heroes.length; i++){
            heroes[i] = new Hero("Hero "+i);
            root.add(heroes[i]);
        }
        System.out.println(root.hpLowToHighSort());
    }
}
