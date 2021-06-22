//L.852 Peak Index In A Mountain Array
//O(log n) time O(1) space
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peakIndex = 0;
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            peakIndex = (low + high) / 2;
            if (arr[peakIndex] > arr[peakIndex-1] && arr[peakIndex] > arr[peakIndex+1]) {
                break;
            } else if (arr[peakIndex] < arr[peakIndex+1]) {
                low = peakIndex + 1;
            } else {
                high = peakIndex;
            }
        }
        return peakIndex;
    }
}