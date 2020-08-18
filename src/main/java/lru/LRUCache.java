package lru;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * @program: arithmetic
 * @description: 最近最久未使用<p>
 *     思路：最近最久未使用 根据set 的先后顺序将
 *     数据存在链表中，当set一个新数据
 *     但是缓存超过capacity（容量）这时候要删除最久未使用的缓存之值
 *     基于LinkedHashMap
 * </p>
 * @author: tmz
 * @create: 2020-08-18 09:28
 */
@Data
public class LRUCache<K,V> extends LRU<K,V> {
    public static final int MAXIMUM_CAPACITY = 1<<30;
    private LinkedHashMap<K,V> cache;
    private final static StampedLock LOCK = new StampedLock();
    private int capacity;
    //默认 16 最大容量
    public LRUCache() {
        this(16);
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<K, V>(tableSizeFor(this.capacity),0.75f,true);
    }
    /**
     * @author tmz
     * @description  线程安全
     * @date 11:02 2020/8/18
     * @param v
     * @param k
     * @return V
     */
    @Override
    public V put(K k, V v) {
        long writeLock = LOCK.writeLock();
        V res =null;
       try {
           if(cache.size()==capacity){
               removeFirst();
           }
           res = cache.put(k, v);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           LOCK.unlockWrite(writeLock);
       }
       return res;
    }

    @Override
    public V get(K k) {
        return cache.get(k);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    /**
     * @deprecated <p>header 就是 LinkedHashMap的第一位\n
     *  因为我开起了 LinkedHashMap的 accessOrder 属性为true
     *  每次get他都会把 get的key放到linked的尾部
     * </p>
     *
     * @return
     */
    public V removeFirst(){
       if( null!=cache&&!cache.isEmpty()){
           Map.Entry<K, V> header = cache.entrySet().iterator().next();
           cache.remove(header.getKey());
           return header.getValue();
       }
       return null;
    }
    private static final int tableSizeFor(int cap) {
        int n = cap ;
//        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
