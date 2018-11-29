package javaNormal.thread.synchronizedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynConllectionTest {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = Collections.synchronizedList(list1);
    }
}
