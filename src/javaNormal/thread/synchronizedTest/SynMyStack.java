package javaNormal.thread.synchronizedTest;

import common.Hero;

import java.util.ArrayList;
import java.util.List;

public class SynMyStack<T> implements MyStack<T> {
    List<T> list = new ArrayList<>();

    @Override
    public synchronized void pull() {
        list.remove(list.size()-1);
    }

    @Override
    public synchronized void push(T t) {
        list.add(t);
    }

    @Override
    public synchronized T peek() {
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        SynMyStack<Hero> myStack = new SynMyStack<>();
        myStack.push(new Hero("盖伦"));
        System.out.println(myStack.peek());
        myStack.push(new Hero("死歌"));
        System.out.println(myStack.peek());
        myStack.pull();
        System.out.println(myStack.peek());
    }
}
