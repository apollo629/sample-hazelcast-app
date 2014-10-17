package net.apollo;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        HazelcastInstance hi = Hazelcast.newHazelcastInstance();
        HazelcastInstance hi2 = Hazelcast.newHazelcastInstance();

        Map<Integer,String> map = hi.getMap("a");
        IdGenerator gen = hi.getIdGenerator("gen");
        for(int i = 0; i < 10; i++) {
            map.put(i, "stuff " + i);
        }

        Map<Integer,String> map2 = hi2.getMap("a");
        for(Map.Entry entry : map2.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "   Value: " + entry.getValue());
        }

        System.exit(0);
    }
}
