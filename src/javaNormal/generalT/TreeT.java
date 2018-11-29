package javaNormal.generalT;

import java.util.ArrayList;
import java.util.List;

public class TreeT<T> {
    public TreeT<T> leftNode;
    public TreeT<T> rightNode;
    public T value;

    public void add(T t){
        if (null != value) {
            if((Integer)t <= (Integer)value){
                if(null == leftNode){
                    leftNode = new TreeT<T>();
                }
                leftNode.add(t);
            }
            if((Integer)t > (Integer)value){
                if(null == rightNode){
                    rightNode = new TreeT<T>();
                }
                rightNode.add(t);
            }
        } else {
            this.value = t;
        }
    }

    public List<T> sort(){
        List<T> list = new ArrayList<T>();
        if ((leftNode == null)) {
        } else {
            list.addAll(leftNode.sort());
        }
        list.add(value);
        if(null != rightNode){
            list.addAll(rightNode.sort());
        }
        return list;
    }

    public static void main(String[] args) {
        TreeT<Integer> tree = new TreeT<>();
        for(int i = 0; i < 100; i++){
            tree.add((int)(Math.random()*100));
        }
        System.out.println(tree.sort());
    }
}
