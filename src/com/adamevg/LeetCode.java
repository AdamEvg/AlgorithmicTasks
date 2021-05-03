package com.adamevg;


import java.util.*;

public class LeetCode {

    //    Input: nums = [3,2,2,3], val = 3
//    Output: 2, nums = [2,2]
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        int i = 0;
        while (i < N) {
            if (nums[i] == val) {
                nums[i] = nums[N - 1];
                N--;
            } else {
                i++;
            }
        }
        return N;
    }

    //    Input: nums = [1,1,2]
//    Output: 2, nums = [1,2]
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[len] != nums[j]) {
                len++;
                nums[len] = nums[j];
            }
        }
        return ++len;
    }

    //    Input: s = "()[]{}"
//    Output: true
//    Input: s = "(]"
//    Output: false
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '{' || character == '[' || character == '(') {
                stack.push(character);
            } else if (!stack.isEmpty() && character == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && character == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && character == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }


    //    Input: x = 121
//    Output: true
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int newX = 0;
            int nX = x;
            while (x != 0) {
                newX = newX * 10 + x % 10;
                x = x / 10;
            }
            return nX == newX;
        }
    }


    //    Input: strs = ["flower","flow","flight"]
//    Output: "fl"
//    Input: strs = ["dog","racecar","car"]
//    Output: ""
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder();
        if (strs.length == 0) {
            return longestPrefix.toString();
        }
        char[] compareWord = strs[0].toCharArray();
        int currentIndex = 0;
        for (char compareSymbol : compareWord) {
            for (int i = 1; i < strs.length; i++) {
                String currentWord = strs[i];
                char currentSymbol;
                if (currentIndex < currentWord.length()) {
                    currentSymbol = currentWord.charAt(currentIndex);
                } else {
                    return longestPrefix.toString();
                }
                if (compareSymbol != currentSymbol) {
                    return longestPrefix.toString();
                }
            }
            currentIndex++;
            longestPrefix.append(compareSymbol);
        }

        return longestPrefix.toString();
    }

    //    Input: n = 19
//    Output: true
    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        Set<Integer> containerOfDigits = new HashSet<>();
        while (!containerOfDigits.contains(n)) {
            containerOfDigits.add(n);
            n = getSquareOfDigits(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSquareOfDigits(int n) {
        int total = 0;
        while (n > 0) {
            total += (n % 10) * (n % 10);
            n /= 10;
        }
        return total;
    }

//    Input: 38
//    Output: 2
//    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//    Since 2 has only one digit, return it.

    /*    public int addDigits(int num) {
            if (num == 0) return 0;
            return num % 9==0? 9: num%9;
        }*/
    public int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }
        num = getSumOfDigit(num);
        return addDigits(num);
    }

    public int getSumOfDigit(int n) {
        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        return total;
    }

    //    Input: [4,2,5,7]
//    Output: [4,5,2,7]
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        return A;
    }

    //    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //    Input: nums = [0,1,2,4,5,7]
    //    Output: ["0->2","4->5","7"]
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int currentElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] - nums[i] != 1) {
                if (nums[i] != currentElement) list.add(currentElement + "->" + nums[i]);
                else list.add(Integer.toString(currentElement));
                if (i != nums.length - 1) currentElement = nums[i + 1];
            }
        }
        return list;
    }

    //Reverse linked list
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

}
