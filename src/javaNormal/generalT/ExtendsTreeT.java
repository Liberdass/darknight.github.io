package javaNormal.generalT;

import common.Hero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExtendsTreeT <T extends Comparable> {
    public ExtendsTreeT<T> leftNode;
    public ExtendsTreeT<T> rightNode;
    public T value;

    public void add(T t){
        if(null == value){
            this.value = t;
        }else {
            if(t.compareTo(value) == 1){ //这里调用compare
                if(null == leftNode){
                    leftNode = new ExtendsTreeT<T>();
                }
                leftNode.add(t);
            }
            if(t.compareTo(value) == -1){
                if(null == rightNode){
                    rightNode = new ExtendsTreeT<T>();
                }
                rightNode.add(t);
            }
        }
    }

    public List<T> sort(){
        List<T> list = new ArrayList<T>();
        if(null != leftNode){
            list.addAll(leftNode.sort());
        }
        list.add(value);
        if(null != rightNode){
            list.addAll(rightNode.sort());
        }
        return list;
    }

    public static void main(String[] args) {
        ExtendsTreeT<Hero> treeT = new ExtendsTreeT<>();
        for(int i = 0;i < 10; i++){
            treeT.add(new Hero("Hero "+i));
        }
        System.out.println(treeT.sort());
    }
}
