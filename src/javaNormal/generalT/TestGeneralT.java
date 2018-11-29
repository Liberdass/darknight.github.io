package javaNormal.generalT;

import common.APHero;
import common.Hero;
import common.Item;

import java.util.ArrayList;
import java.util.List;

/** 如果希望只取出，不插入，就使用? extends Hero
 如果希望只插入，不取出，就使用? super Hero
 如果希望，又能插入，又能取出，就不要用通配符？*/
public class TestGeneralT {
    public static void main(String[] args) {
        ArrayList<APHero> apHeroes = new ArrayList<>();
        apHeroes.add(new APHero());

        //? extends Hero 表示这是一个Hero泛型的子类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero
        //heroes 不能add东西，所以只好指向别的list，因为即使new出这个对象不能添加内容;
//        List<? extends Hero> heroes = new ArrayList<>();
        List<? extends Hero> heroes = apHeroes;
        //这一句也会报错，编译错误，因为heroes的泛型 有可能是APHero
//        heroes.add(new ADHero());
        Hero h = apHeroes.get(0);

        //? super Hero 表示 heroList的泛型是Hero或者其父类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是Object
        //所以就可以插入Hero
        List<? super Hero> heroOrObjects = new ArrayList<>();
        heroOrObjects.add(new Hero("LZL"));
        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object强转Hero会失败
        //下面第一句会报错，第二句不会;
//        Hero h2 = heroOrObjects.get(0);
        Object o = heroOrObjects.get(0);


        //?泛型通配符，表示任意泛型
        ArrayList<?> generalList = apHeroes;

        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o2 = generalList.get(0);

        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
//        generalList.add(new Item()); //编译错误 因为?代表任意泛型，很有可能不是Item
//        generalList.add(new Hero()); //编译错误 因为?代表任意泛型，很有可能不是Hero
//        generalList.add(new APHero()); //编译错误  因为?代表任意泛型，很有可能不是APHero
    }
}
