// https://www.jiuzhang.com/problem/lfu-cache/

public class LFU Cache {

	// use three hashmap
	
	HashMap<Integer, Integer> values;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, List<Integer>> frequency;
	int CAP;
	int minFreq;
	
	public LFUCache(int capacity) {
		CAP = capacity;
		values = new HashMap<>();
		counts = new HashMap<>();
		frequency = new HashMap<>();
		frequency.put(1, new ArrayList<>());
	}
	
	public void set(int key, int value) {
		if (values.containsKey(key)) {
			values.put(key, value);
			get(key);
			return;
		}
		if (values.size() >= CAP) {
			int lowkey = frequency.get(minFreq).get(0);
			frequency.get(minFreq).remove(Integer.valueOf(lowkey));
			values.remove(lowkey);
		}
		values.put(key, value);
		minFreq = 1;
		counts.put(key, 1);
		frequency.get(1).add(key);
	}
	
	public int get(int key) {
		if (!values.containsKey(key)) {
			return -1;
		}
		
		int freq = counts.get(key);
		frequency.get(freq).remove(Integer.valueOf(key));
		
		if (freq == minFreq && frequency.get(freq).size() == 0) {
			minFreq++;
		}
		counts.put(key, freq + 1);
		if (frequency.get(freq + 1) == null) {
			frequency.put(freq + 1, new ArrayList<>());
		}
		frequency.get(freq + 1).add(key);
		return values.get(key);
	}

}
