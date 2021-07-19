//L.18 4Sum
//Two pointer
//O(n^3) time O(n) space
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length-3) {
                int j = i + 1;
                while (j < nums.length-2) {
                    
                        int sum = target - nums[i] - nums[j];
                        int left = j + 1;
                        int right = nums.length-1;
                        while (left < right) {
                            if (nums[left] + nums[right] == sum) {
                                List<Integer> quadruplet = new ArrayList<>();
                                quadruplet.addAll(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                res.add(quadruplet);
                                left += 1;
                                while (left < right && nums[left] == nums[left-1]) {
                                    left += 1;
                                }
                            } else if (nums[left] + nums[right] < sum) {
                                left += 1;
                            } else {
                                right -= 1;
                            }
                        }
                        j += 1;
                        while (j < nums.length && nums[j] == nums[j-1]) {
                            j += 1;
                        }
                    
                }
            i += 1;
            while (i < nums.length && nums[i] == nums[i-1]) {
                i += 1;
            }
            
        }
        return res;
    }
}

//HashSet
//O(n^3) time O(n) space
public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
}
public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
        return res;
    if (k == 2)
        return twoSum(nums, target, start);
    for (int i = start; i < nums.length; ++i)
        if (i == start || nums[i - 1] != nums[i])
            for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(set);
            }
    return res;
}
public List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> s = new HashSet<>();
    for (int i = start; i < nums.length; ++i) {
        if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
            if (s.contains(target - nums[i]))
                res.add(Arrays.asList(target - nums[i], nums[i]));
        s.add(nums[i]);
    }
    return res;
}