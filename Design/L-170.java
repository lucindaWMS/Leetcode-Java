//L.170 Two Sum III Data Structure Design
//Hashtable
//O(1) time for add(), O(n) time for find(), O(n) space
//If using two pointer, the time complexity for find() is O(nlogn)
class TwoSum {
    
    List<Integer> myList;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.myList = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.myList.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < this.myList.size(); i++) {
            int complement = value - this.myList.get(i);
            if (this.map.containsKey(complement) && this.map.get(complement) != i) {
                return true;
            }
            this.map.put(this.myList.get(i), i);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */