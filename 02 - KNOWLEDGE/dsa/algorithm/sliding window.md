


## [[Problem]]: Permutation in string (same as anagram in string)

[Permutation in String - LeetCode](https://leetcode.com/problems/permutation-in-string/?envType=study-plan&id=algorithm-i)

Given two strings `s1` and `s2`, return `true` _if_ `s2` _contains a permutation of_ `s1`_, or_ `false` _otherwise_.
In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.

**Example 1:**
**Input:** s1 = "ab", s2 = "eidbaooo"
**Output:** true
**Explanation:** s2 contains one permutation of s1 ("ba").

**Example 2:**
**Input:** s1 = "ab", s2 = "eidboaoo"
**Output:** false


### Intuition
So permutation of a string basically means just the reordering of the letters of the string. 
That means all the permutations of a string are just the [[anagrams]] of the string, with all the letters included, just in another way. 
And we have to find if such a substring exists in s2 which is a permutation of s1, which means we have to find a substring in s2 such that the frequency of the characters in that substring is same as the frequency of the characters in s1.

### Algorithm
1. maintain two hashtables for `s1`, `current` 
2. fill hashtable of `s1`
3. keep increasing the window
	count rightmost character in hashtable 2
    if window size == s1.size():
	    if map1 == map2 then finished with true
        otherwise discount leftmost element from current
        // avoid left-most elem become less than 0, in that case erase it
        increase l by one

## Implementation

C++
```cpp
bool checkInclusion(string s1, string s2) {
    int m=s1.size(), n=s2.size();
    unordered_map <char, int> s1map, current;
    for (char c: s1) s1map[c]++;

    for (int r=0, l=0; r<n; r++){
        current[s2[r]]++;

        if (r-l+1 == m) {
            if (s1map == current) return true;
            current[s2[l]]--;
            if (current[s2[l]] == 0) current.erase(s2[l]);
            l++;
        }
    }
    return false;
}
```
