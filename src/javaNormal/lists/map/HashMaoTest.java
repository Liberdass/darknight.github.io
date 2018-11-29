package javaNormal.lists.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaoTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>(10);
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(3,3);
        for (Object o : hashMap.keySet()) {
            System.out.println(o + " " + hashMap.get(o));
        }

        Iterator mapit = hashMap.entrySet().iterator();
        System.out.println(hashMap.entrySet());
        while (mapit.hasNext()){
            Map.Entry<Object,Object> mapEntry = (Map.Entry<Object, Object>) mapit.next();
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }
    }
}
