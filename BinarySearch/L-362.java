//L.362 Design Hit Counter
//Binary Search + ArrayList
//O(logn) for getHits(), O(n) space
class HitCounter {

    /** Initialize your data structure here. */
    private List<Integer> myHitRecords;
    public HitCounter() {
        this.myHitRecords = new ArrayList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.myHitRecords.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int timeToFind = timestamp - 300 + 1;
        if (this.myHitRecords.size() == 0) {
            return 0;
        }
        int leftBound = this.binarySearchLeft(timeToFind);
        if (leftBound == -1) {
            return 0;
        }
        int rightBound = this.binarySearchRight(timestamp);
        if (rightBound == -1) {
            return this.myHitRecords.size() - leftBound;
        }
        if (rightBound == 0) {
            return 0;
        }
        return rightBound - leftBound + 1;
    }
    
    private int binarySearchLeft(int timestamp) {
        if (timestamp < this.myHitRecords.get(0)) {
            return 0;
        }
        if (timestamp > this.myHitRecords.get(this.myHitRecords.size() - 1)) {
            return -1;
        }
        int left = 0;
        int right = this.myHitRecords.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (this.myHitRecords.get(mid) >= timestamp) {
                right = mid;
            } else if (this.myHitRecords.get(mid) < timestamp) {
                left = mid + 1;
            }
        }
        if (this.myHitRecords.get(left) >= timestamp) {
            return left;
        }
        if (this.myHitRecords.get(right) >= timestamp) {
            return right;
        }
        if (this.myHitRecords.get(right) < timestamp) {
            return right + 1;
        }
        return -1;
    }
    
    private int binarySearchRight(int timestamp) {
        if (timestamp < this.myHitRecords.get(0)) {
            return 0;
        }
        if (timestamp > this.myHitRecords.get(this.myHitRecords.size() - 1)) {
            return -1;
        }
        int left = 0;
        int right = this.myHitRecords.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (this.myHitRecords.get(mid) == timestamp) {
                left = mid;
            } else if (this.myHitRecords.get(mid) < timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (this.myHitRecords.get(right) >= timestamp) {
            return right;
        }
        if (this.myHitRecords.get(left) >= timestamp) {
            return left;
        }
        if (this.myHitRecords.get(right) < timestamp) {
            return right + 1;
        }
        return -1;
    }
}

//Queue (Solution from Leetcode)
//O(n) time for getHits(), O(n) space
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
class HitCounter {
    private Queue<Integer> hits; 

    /** Initialize your data structure here. */
    public HitCounter() {
        this.hits = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if (diff >= 300) this.hits.remove();
            else break;
        }
        return this.hits.size();
    }
}