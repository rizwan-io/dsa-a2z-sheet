# Hard Array Questions

### [Majority Element II](https://leetcode.com/problems/majority-element-ii/)
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.  
Approach:
* Bruteforce:
  * Use a HashMap to store the count of each number.
  * Return the ones that appears more than n/3 times.
  * TC = O(N) & SC = O(N)
* Optimal:
  * Observation: the maximum number of elements that can occur (n/3) times is 2.
  * We will use an extended version of Moore's Voting Algorithm. (Same we used for N/2 Problem)
  * Take 2 elementsVariable & 2 countsVariable
  * Traverse the array 
    * if the element is equal to element1 then increment count1
    * else if element is equal to element2 then increment count2
    * else if count1 is 0 then increment the count and make element1 as the num
    * else if count2 is 0 then increment the count and make element2 as the num
    * else just decrement both the counters.
    * Now the count of element1 & element2 might be the greater than n/3, but we are not sure.
    * We will traverse the array again and check if element1 & 2 exists more than n/3 times.
  * TC = O(N) & SC = O(1)