## Easy Array Problems:
Solutions to all the easy problems can be found at [EasyArrayProblems.java](EasyArrayProblems.java)
#### 1. [Largest Element in Array](https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array)
* Approach:
    * Traverse the array and keep track of the largest element.
* TC = O(N) & SC = O(1)

#### 2. [Second Largest](https://practice.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest)
Approach:
* Bruteforce:
    * Sort the array and return the first from the end (second largest) that is not equal to the last element (largest)
    * TC = O(Nlog(N)) & SC = O(1)
* Optimal:
    * Keep track of largest
    * Traverse the array and change largest and secondLargest based on the element you encounter.
    * TC = O(N) & SC = O(1)

#### 3. [Check if array is sorted](https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-an-array-is-sorted)
* Approach:
    * Traverse the array and compare the element with the next element and then decide
* TC = O(N) & SC = (1)

#### 4. [Remove duplicate elements from sorted Array](https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicate-elements-from-sorted-array)
Approach:
* Bruteforce:
    * Unique elements? Use hashset. Also want to preserve the insertion order? Use LinkedHashSet.
    * TC = O(N) & SC = O(N)
* Optimal:
    * Use 2 pointers, one is used to traverse the array and other is incremented and assigned with the first one.
    * Keep increment count whenever you get distinct elements.
    * TC = O(N) & SC = O(1)

#### 5. [Left Rotate an Array by One](https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278)
* Approach:
    * Store the first element and keep shifting each element by one left.
    * Place the stored element at the last.
* TC = O(N) & SC = O(1)

#### 6. [Left Rotate an Array by D Places](https://practice.geeksforgeeks.org/problems/reversal-algorithm5340/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reversal-algorithm)
Approach:
* Bruteforce:
    * Repeat the "Left Rotate an array by one" for D times
    * TC = O(N^2) & SC =  O(1)
* Better:
    * Create a duplicate array
    * Copy the contents from D to N-1 to the duplicate array, then
    * Copy the contents from 0 to D-1 to the duplicate array
    * TC = O(N) & SC = O(N)
* Optimal:
    * This is a trick that can be observed
    * Reverse the sub-array from 0 to D-1
    * Reverse the sub-array from D to N-1
    * Reverse the complete array
    * TC = O(N) & SC = O(1)

#### 7. [Move all zeroes to end of array](https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=move-all-zeroes-to-end-of-array)
Approach:
* Bruteforce:
    * Create a duplicate array
    * Traverse the original array and push all non zero elements on to the duplicate array.
    * Fill the remaining elements with zeroes
    * TC = O(N) & SC = O(N)
* Optimal:
    * Use 2 Pointers, One will keep track of zeroes, Other will keep track of non-zeroes
    * Swap the contents of both if the first has non-zero and second has zero
    * TC = O(N) & SC = O(1)

#### 8. [Searching an element in a sorted array](https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win)
* Approach:
    * Simple linear search
* TC = O(N) & SC = O(1)

#### 9. [Union of Two Sorted Arrays](https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays)
* Approach:
    * Use 2 pointers, one for the first array and other for the second
    * Compare the contents of both the array, Add the one which is lower
    * Remember to not add the element which is already present
* TC = O(n+m) & SC = O(n+m)

#### 10. [Missing number](https://practice.geeksforgeeks.org/problems/missing-number4257/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=missing-number)
Approach:
* Bruteforce
    * Traverse the array and check if all natural numbers are present.
    * If a number is absent return it
    * TC = O(N^2) & SC = O(1)
* Better
    * Use a HashMap to count the occurrence of the numbers
    * A key that has 0 value is our answer
    * TC = O(N) & SC = O(N)
* Optimal
    * Find the summation of N natural numbers
    * Find the summation of the entire array
    * Subtract the second from first
    * TC = O(N) & SC = O(1)

#### 11. [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)
* Approach:
    * Basic Implementation: Keep track of consecutive ones and return the max
* TC = O(N) & SC = O(1)

#### 12. [Single Number](https://leetcode.com/problems/single-number/)
Approach:
* Bruteforce:
    * Sort the array and check from left to right which element appears only once
    * TC = O(Nlog(N)) & SC = O(log(N))
* Better:
    * Use HashMap to keep count of numbers
    * TC = O(N) & SC = O(N)
* Optimal:
    * Use XOR (^) operator. X^X = 0 and X^0 = X
    * TC = O(N) & SC = O(1)

#### 13. [Longest Sub-Array with Sum K](https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k)
Approach:
* Bruteforce:
    * Calculate sum of all subarrays and keep a track of longest sub-array with sum K.
    * TC = O(N^2) & SC = O(1)
* Optimal:
    * Use a HashMap<Sum, Index> to keep track of sum and index at which the sum occurs.
    * If sum == K then max = i+1
    * If sum-K exists in hashMap then max = Math.max(max, hashMap.getValue(sum-K))
    * TC = O(N) & SC = O(N)

#### 14. [Longest Subarray With Sum K - Only Positives and Zeroes](https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf)
Approach: <mark>Not all test cases are passing. TCs passed - 10/11</mark>
* Optimal:
    * The above-mentioned approaches will also work but is not an optimal solution if the array contains only positive and zeroes
    * Use 2 Pointer approach to get an optimal result. (Sliding Window)
    * Increment left pointer and subtract a[left] if sum is greater than k
    * Increment right pointer and add a[right] if sum is less than k
    * TC = O(N) & SC = O(1)