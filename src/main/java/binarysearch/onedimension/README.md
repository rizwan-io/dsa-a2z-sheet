# Binary Search on One Dimension

### 1. [Binary Search](https://leetcode.com/problems/binary-search/)
Approach:
- Simple Binary Search Algorithm
- TC = O(logN) & SC = O(1)

### 2. [Lower Bound](https://www.codingninjas.com/studio/problems/lower-bound_8165382)
Approach:
* Simple Binary Search but while selecting the left part keep the index handy
* TC = O(logN) & SC = O(1)

### 3. [Upper Bound](https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf)
Approach:
* Same as above with minor modification
* TC = O(logN) & SC = O(1)

### 4. [Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)
Approach:
* Do Binary search and return if found, otherwise return low
* TC = O(logN) & SC = O(1)

### 5. [Ceil the Floor](https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf)


### 6. [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
Approach:
* First the first occurrence first then last.
* TC = O(logN) & SC = O(1)

### 7. [Number of occurrence](https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1)
Approach:
* lastOccurrence - firstOccurrence + 1
* TC = O(logN) & SC = O(1)

### 8. [Search in Rotated Sorted Array (Unique Elements)](https://leetcode.com/problems/search-in-rotated-sorted-array/)
Approach:
* Same as BS, One of the part either left or right would be sorted. 
* TC = O(logN) & SC = O(1)

### 9. [Search in Rotated Sorted Array II (Duplicate Elements)](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
Approach:
* The above logic won't work in the case arr[mid] = arr[low] = arr[high]. Because there is no way to find which part is sorted.
* In this case increment low and decrement high, Rest all are same as above
* TC = O(logN) & SC = O(1)
