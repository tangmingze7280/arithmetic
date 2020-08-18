package lru;

/**
 * @program: arithmetic
 * @description:
 * @author: tmz
 * @date: 2020-08-18 09:41
 **/
public abstract class LRU<K,V> {
    public  void remove(LRUNode lruNode,K key){
        //ignore
    }
    protected class LRUNode{
        K key;
        V value;
        LRUNode preNode;
        LRUNode sufferNdoe;
        public LRUNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public V put(K k,V v){
        return v;
    }
    public V get(K k){
        return null;
    }
    public  void remove(K key){
        //ignore
    }

}
