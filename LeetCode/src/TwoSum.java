import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (d == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSumHashMap(int[] nums, int target) {

        int[] result = new int[2];
        //define hashmap to save key(array element), value(index) pairs
        Map<Integer, Integer> previousMap = new HashMap<>();

        //construct map and generate result array
        for (int i = 0; i < nums.length; i++) {
            //get the diff between target number and current array element
            int diff = target - nums[i];
            //if diff value is already existing in previousMap, then info is enough to generate result array and break
            if (previousMap.containsKey(diff)) {
                result[0] = previousMap.get(diff);
                result[1] = i;
                return result;
            }
            //if it reaches here, then means no results have been generated, just add new entry into the hashmap
            if (!previousMap.containsKey(nums[i])) {
                previousMap.put(nums[i], i);
            }

        }
        return result;
    }

    public int[] twoSumHeadTailPointer(int[] nums, int target) {

        int[] result = new int[2];
        int l = 0;
        int r = nums.length - 1;
        nums = Arrays.stream(nums).sorted().toArray();

        while (r > l) {
            int sum = nums[l] + nums[r];

            if (sum == target) {
                result[0] = l;
                result[1] = r;
                return result;
            }

            if (sum > target) {
                r--;
            }

            if (sum < target) {
                l++;
            }
        }

        return result;
    }

    public static void main (String[] args) {
        TwoSum ts = new TwoSum();
//        int[] nums = new int[] {2, 7, 11, 15};
//        ts.twoSumHeadTailPointer(new int[] {2, 7, 11, 15}, 9);
        ts.twoSumHeadTailPointer(new int[] {3, 2, 4}, 6);
    }
}
