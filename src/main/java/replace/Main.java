package replace;

import lru.LRUCache;

public class Main {
    public static void main(String[] args) {
        LRUCache<String,String> a  = new LRUCache<String, String>(2);
        for (String key:new String[]{"1","2","3","4","5","6"}) {
            a.put(key,key);
            System.out.println(a);
            a.get("3");
            System.out.println(a);
        }
        System.out.println(a);
    }
}
