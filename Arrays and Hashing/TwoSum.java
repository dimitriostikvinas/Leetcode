import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n ; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        
        return new int[]{}; 
    }

    public static void main(String[] args) {
		int[] nums = {2,7,11,15};
        int target = 9;
        int[] indices = twoSum(nums, target);
        for (int num : indices) {
            System.out.print(num + " ");
        }
	}

}
