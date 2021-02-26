package com.yy.android.lib.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TestClass {
    // public static void main(String[] args) {
    //     // ListNode node0 = new ListNode(0);
    //     // ListNode node1 = new ListNode(1);
    //     // ListNode node2 = new ListNode(2);
    //     // ListNode node3 = new ListNode(3);
    //     // ListNode node4 = new ListNode(4);
    //     // ListNode node5 = new ListNode(5);
    //     // node0.next =node1;
    //     // node1.next =node2;
    //     // node2.next =node3;
    //     // node3.next =node4;
    //     // node4.next =node5;
    //     // node0 = reverseList(node0);
    //     // while (node0 != null) {
    //     //     System.out.println(node0.val);
    //     //     node0 = node0.next;
    //     // }
    //
    //     // LRUCache lruCache = new LRUCache(2);
    //     // System.out.println(lruCache.get(2));
    //     // lruCache.put(2,6);
    //     // System.out.println(lruCache.get(1));
    //     // lruCache.put(1,5);
    //     // lruCache.put(1,2);
    //     // System.out.println(lruCache.get(1));
    //     // System.out.println(lruCache.get(2));
    //     // System.out.println(lengthOfLongestSubstring("pwwkew"));
    //     // System.out.println(romanToInt("MCMXCIV"));
    //     String[] s = new String[]{"flower","flow","flight"};
    //     // String[] s = new String[]{"dog","racecar","car"};
    //     System.out.println(longestCommonPrefix(s));
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{i, maps.get(target - nums[i])};
            }
            maps.put(nums[i], i);
        }
        return null;
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.add(')');
            } else if (c == '[') {
                stack.add(']');
            } else if (c == '{') {
                stack.add('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //
    // }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, sum + nums[i]);
            if (sum + nums[i] < 0) {
                sum = 0;
            } else {
                sum += nums[i];
            }
        }

        return 0;
    }

    // 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    // 输出: 4
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode cur = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        head.next = null;
        return cur;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = new ListNode(0, res);
        while (l1 != null || l2 != null) {
            if (l2 == null) {
                res.next = l1;
                break;
            }
            if (l1 == null) {
                res.next = l2;
                break;
            }
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        return head.next.next;
    }

    public static String decodeString(String s) {
        String res = "";
        char[] cs = s.toCharArray();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '[') {
                a.add(i);
            } else if (cs[i] == ']') {
                b.add(i);
            }
        }
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {

        }
        return res;
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i < n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a + b;
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] cs = strings[i].toCharArray();
            for (int j = 0; j < cs.length / 2; j++) {
                char c = cs[j];
                cs[j] = cs[cs.length - j - 1];
                cs[cs.length - j - 1] = c;
            }
            strings[i] = String.valueOf(cs);
        }
        String res = "";
        StringBuilder sb = new StringBuilder(res);
        sb.reverse();

        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
            if (i != strings.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    // [-2,1,-3,4,-1,2,1,-5,4]

    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int sum = nums[0] > 0 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, sum + nums[i]);
            if (sum + nums[i] < 0) {
                sum = 0;
            } else {
                sum += nums[i];
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        String res = "";
        char[] cs = s.toCharArray();
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            String temp = String.valueOf(cs[i]);
            if (res.contains(temp)) {
                max = Math.max(max, res.length());
                int length = res.indexOf(temp);
                res = res.substring(length + 1);
                res += temp;
            } else {
                res += temp;
            }
        }
        max = Math.max(max, res.length());
        return max;
    }

    public int reverse(int x) {
        int abs = Math.abs(x);
        int res = 0;
        while (abs > 0) {
            int a = abs % 10;
            abs = abs / 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + a;
        }
        return x < 0 ? -res : res;
    }
    // 输入: "MCMXCIV"
    // 输出: 1994
    // 解释: M = 1000, CM = 900, XC = 90, IV = 4.
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000

    public static int romanToInt(String s) {
        s = s.replaceAll("IV","A");
        s = s.replaceAll("IX","B");
        s = s.replaceAll("XL","E");
        s = s.replaceAll("XC","F");
        s = s.replaceAll("CD","G");
        s = s.replaceAll("CM","H");
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':res+= 1000;break;
                case 'D':res+= 500;break;
                case 'C':res+= 100;break;
                case 'L':res+= 50;break;
                case 'X':res+= 10;break;
                case 'V':res+= 5;break;
                case 'I':res+= 1;break;
                case 'A':res+= 4;break;
                case 'B':res+= 9;break;
                case 'E':res+= 40;break;
                case 'F':res+= 90;break;
                case 'G':res+= 400;break;
                case 'H':res+= 900;break;
            }
        }
        return res;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        while (true) {
            boolean finish = false;
            if (i >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    finish = true;
                    break;
                }
                char cj = strs[j].charAt(i);
                if (cj != c) {
                    finish = true;
                    break;
                }
            }
            if (finish)
                break;
            i++;
        }
        return strs[0].substring(0,i);
    }

    public static boolean test(ListNode head) {
        if (head == null) return false;
        List<ListNode> buk = new ArrayList<>();
        while (head.next!=null) {
            if (buk.contains(head.next)) {
                return true;
            }
            buk.add(head);
            head = head.next;
        }
        return false;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i =0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
        }
        ans[0] = deque.peekFirst();
        int idx = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i-k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
            ans[idx++] = deque.peekFirst();
        }
        return ans;
    }


    public static void main(String[] args) {
        // int[] nums = new int[]{1,-1};
        // int[] res = maxSlidingWindow(nums,1);
        // for (int i = 0; i < res.length; i++) {
        //     System.out.println(res[i]);
        // }
        int[][] grid = new int[][]{
                {5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1},{1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0},{2,8,3,3, 1,6,1,4,9,0,9,2,3,3,3,8,4},
                {3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9},{3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4},{8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1},
                {7,1,0,4,7,8,4,6,4,2,1,3,7, 8,3,5,4},{3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7},{8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4},
                {3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4},{5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6},{5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7},
                {9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9},{7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8}};

        // int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1,}};

        System.out.println(minPathSum(grid));
    }

    // public static Map<Integer,Integer> map = new HashMap<>();
    // public static int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     return test(grid,m-1,n-1);
    // }
    //
    // public static int test(int[][] grid, int m, int n) {
    //     if (map.containsKey(m * grid[0].length + n)) {
    //         return map.get(m * grid[0].length + n);
    //     }
    //     if (m == 0 && n == 0) {
    //         return grid[m][n];
    //     }
    //     if (m == 0) {
    //         return grid[m][n] + test(grid, m, n - 1);
    //     }
    //     if (n == 0) {
    //         return grid[m][n] + test(grid, m - 1, n);
    //     }
    //     int res =
    //      Math.min(grid[m][n] + test(grid, m - 1, n), grid[m][n] + test(grid, m, n - 1));
    //     map.put(m * grid[0].length + n,res);
    //     return res;
    // }
    // public static Map<Integer,Integer> map = new HashMap<>();
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                grid[i][j] += test(grid,i,j);
            }
        }
        return grid[m-1][n-1];
    }

    private static Integer test(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i == 0) {
            return grid[i][j-1];
        }
        if (j == 0) {
            return grid[i-1][j];
        }
        return Math.min(grid[i][j - 1], grid[i - 1][j]);
    }

    // public static int minPathSum(int[][] grid) {
    //     for (int i = 0; i < grid.length; i++) {
    //         for ( int j = 0; j < grid[0].length; j++) {
    //             grid[i][j] += Math.min(i > 0 ? grid[i-1][j] :Integer.MAX_VALUE,j > 0 ? grid[i][j-1]:Integer.MAX_VALUE);
    //         }
    //     }
    //     return grid[grid.length-1][grid[0].length-1];
    // }

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int len = 1;
        for (int i =1; i < nums.length; i++) {
            if (test(res,nums[i],len)) {
                res[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    private boolean test(int[] res, int num,int len) {
        for (int i = 0; i < len; i++) {
            if (num < res[i]) {
                res[i] = num;
                return false;
            }
        }
        return true;
    }


}