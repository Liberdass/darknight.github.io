package javaNormal.thread.synchronizedTest;

public interface MyStack<T> {
    public void pull();
    public void push(T t);
    public T peek();
}
