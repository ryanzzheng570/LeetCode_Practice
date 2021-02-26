import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
    //#1
    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.*/

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for(int i=0; i<nums.length; i++) {
            //Get the difference between target and one of the nums in the array
            int complement = target - nums[i];
            //If the map contains the nums meaning the other number has been found
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No values were found");
    }

    public static void main(String[] args) {
        System.out.println("Input Array [2, 7, 11, 15], Target: 9");
        System.out.println("Output:" + Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }
}
