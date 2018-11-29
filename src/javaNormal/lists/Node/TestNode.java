package javaNormal.lists.Node;

import java.util.ArrayList;
import java.util.List;

public class TestNode {
    public TestNode leftNode;
    public TestNode rightNode;
    public Object value;

    public void add(Object o){
        if(null == value){
            this.value = o;
        }else{
            if((Integer)o <= (Integer)value ){
                if(null == leftNode){
                    leftNode = new TestNode();
                }
                leftNode.add(o);
            }

            if((Integer)o > (Integer)value){
                if(null == rightNode){
                    rightNode = new TestNode();
                }
                rightNode.add(o);
            }
        }
    }

    public List<Object> sort(){
        List<Object> list = new ArrayList<>();
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
        TestNode root = new TestNode();
        int[] nums = new int[10];
        for (int i : nums){
            nums[i] = (int)(Math.random()*100);
            root.add(nums[i]);
        }
        System.out.println(root.sort());
    }
}
