import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopkFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()) {
            result[i++] = Objects.requireNonNull(minHeap.poll()).getKey();
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Example 1: " + Arrays.toString(topKFrequent(nums1, k1)));

        // Example 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Example 2: " + Arrays.toString(topKFrequent(nums2, k2)));
    }
}
