package basicAlgorithmAndDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implement a load balancer for web servers. It provide the following functionality:
 * Add a new server to the cluster => add(server_id).
 * Remove a bad server from the cluster => remove(server_id).
 * Pick a server in the cluster randomly with equal probability => pick().
 * 
 * Example
 * At beginning, the cluster is empty => {}.
 * add(1)
 * add(2)
 * add(3)
 * pick()
 * >> 1         // the return value is random, it can be either 1, 2, or 3.
 * pick()
 * >> 2
 * pick()
 * >> 1
 * pick()
 * >> 3
 * remove(1)
 * pick()
 * >> 2
 * pick()
 * >> 3
 * pick()
 * >> 3
 */

public class LoadBalancer {
    private Map<Integer, Integer> map;
    private List<Integer> servers;
    public LoadBalancer() {
        // Initialize the data structure here
        map = new HashMap<>();
        servers = new ArrayList<>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        int size = servers.size();
        map.put(server_id, size);
        servers.add(server_id);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        int index = map.get(server_id);
        int size = servers.size();
        map.put(servers.get(size - 1), index);
        servers.set(index, servers.get(size - 1));
        servers.remove(size - 1);
        map.remove(server_id);
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        Random random = new Random();
        int size = servers.size();
        int index = Math.abs(random.nextInt()) % size;
        return servers.get(index);
    } 
}
