package com.company;

import javax.print.DocFlavor;
import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.util.*;

public class leetcodetest {

    public static  void main(String[] args){
        String magazine="affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec";

StringBuilder stringbuilder=new StringBuilder();
stringbuilder.append(magazine);
        String ransomNote="bjaajgea";
        canConstruct(ransomNote,magazine);

    }
    public static boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int[] caps= new int[26];
        for (char c : ransom.toCharArray()) {
            int temp=caps[c-'a'];
            int index = magazine.indexOf(c, temp);


            if (index == -1)
                return false;
            int temp2=
            caps[c - 97] = index + 1;
        }
        return true;
    }
    public static int binarysearch(int l,int h,int n){
        int mid;
        mid=l+((h-l)/2);
        boolean result=isBadVersion(mid);
        if(l>=h){

            return l;

        }


        if(result==false){
          return   binarysearch(mid+1,h,n);
        }
        else{


            return    binarysearch(l, mid , n);

        }


    }

    private static boolean isBadVersion(int mid) {
        Boolean []arr={false,false,true,true,true};
        if(arr[mid]==true)return true;
        return false;
    }


    public static  void main14(String[] args){
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }


}

    public static void main13(String[] args) {

        int[] arr = {5, 7, 1, 2};
        TreeNode1 node = new TreeNode1(arr[0]);
        TreeNode1 temp = node;
        for (int i = 1; i < arr.length; i++) {
            addelement(node, arr[i]);
        }

       System.out.println( searchelementbst(temp,7));

        //printelement(com.extra.node);
        /* Breadth first Search
        Queue<TreeNode1> nodes = new LinkedList<>();
        nodes.add(com.extra.node);


       while (!nodes.isEmpty()) {
            TreeNode1 node1 = nodes.remove();
            System.out.println(node1.val);
            if (node1.left != null) {
                nodes.add(node1.left);
            }
            if (node1.right != null) {
                nodes.add(node1.right);
            }
        }*/

    }

    public static TreeNode1 addelement(TreeNode1 node, int val) {
        if (node == null) {
            return new TreeNode1(val);
        }
        if (val < node.val) {
            node.left = addelement(node.left, val);
        } else if (val > node.val) {
            node.right = addelement(node.right, val);

        } else {
            return node;
        }
        return node;

    }

    public static void printelement(TreeNode1 node) {
        if (node != null) {

            printelement(node.right);
            System.out.println(node.val);
            printelement(node.left);
        }


    }

    public static TreeNode1 searchelementbst(TreeNode1 root,int val){


        while(root!=null){
            if(root.val==val){
                return root;

            }
            if(root.val>val){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }


        return null;

    }



    public static void main12(String[] args) {
        int[] arr = {3, 4, 5, 7, 8, 9};

        System.out.println(binarySearchRecursive(9, arr, 0, arr.length - 1));

    }

    public static void main11(String[] args) {

        String s = "(*)))";
        System.out.println(checkValidString(s));

    }

    public static boolean checkValidString(String s) {
        int left = 0, rem = 0;
        for (char ch : s.toCharArray()) {
            left += ch == '(' ? 1 : -1;
            rem += ch != ')' ? 1 : -1;
            if (rem < 0) break;
            left = Math.max(left, 0);
        }
        return left == 0;
    }


    public static int binarySearchRecursive(int search, int[] array, int start, int end) {

        int middle = (start + end) / 2;

        if (end < start) {
            return -1;
        }


        if (search < array[middle]) {
            return binarySearchRecursive(search, array, start, middle - 1);
        }

        if (search > array[middle]) {
            return binarySearchRecursive(search, array, middle + 1, end);
        }

        if (search == array[middle]) {
            return middle;
        }

        return -1;
    }

    static boolean areParenbalanced(char chars[]) {
        Stack<Character> parerstack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(')
                parerstack.push(chars[i]);

            if (chars[i] == ')') {
                if (parerstack.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(parerstack.pop(), chars[i])) {
                    return false;
                }
            }


        }
        if (parerstack.isEmpty()) {
            return true;
        } else
            return false;
    }

    static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '*' && character2 == '(')
            return true;
        else if (character1 == '*' && character2 == ')')
            return true;

        else
            return false;
    }

    public static void main10(String[] args) {
        String s = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        StringBuilder snew = new StringBuilder();
        snew.append(s);

        for (int[] ints : shift) {
            if (ints[0] == 0) {

                snew.replace(0, snew.length(), leftshift(snew, ints[1]));
            } else {
                snew.replace(0, snew.length(), rightshift(snew, ints[1]));

            }

        }
        System.out.println(snew);
    }

    private static String rightshift(StringBuilder snew, int anInt) {
        return leftshift(snew, snew.length() - anInt);
    }

    private static String leftshift(StringBuilder snew, int anInt) {
        String ans = snew.substring(anInt) + snew.substring(0, anInt);
        return ans;
    }

    public static void main9(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String temp = input[0];
        for (int i = 1; i < input.length; i++) {

            //   System.out.println(input[i]);
            while (input[i].indexOf(temp) != 0) {
                temp = temp.substring(0, temp.length() - 1);

            }


        }
        System.out.println(temp);
        System.out.println(input[1].indexOf("ow"));

    }

    public static void main8(String[] args) {
        int[] arrnew = {9, 5, 8};
        Arrays.sort(arrnew);
        int sum = 0;
        int j = 0;
        int pointer = 1;
        for (int i = 0; i < arrnew.length; i++) {
            System.out.println(arrnew[i]);
            pointer = 1;
            j = 0;
            while (j != i + 1) {
                sum = sum + arrnew[arrnew.length - 1 - i + j] * pointer;
                j++;
                pointer++;
            }

        }
        System.out.println(sum);


    }

    public static void main1(String[] args) {
        int[] arr = {1, 1, 2, 2};
        Set<Integer> newset = new HashSet<>();
        int j = 0;
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            newset.add(arr[i]);
            if (i != j) {
                for (j = 0; j < arr.length; j++) {
                    if (arr[i] + 1 == arr[j]) {
                        count++;
                    }
                }
            }


        }
        for (int i = 0; i < arr.length; i++) {
            if (newset.contains(arr[i] + 1)) {
                count1++;
            }
            ;
        }

        System.out.println(count1);

    }

    public static void main2(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        int price = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > price) {
                profit = profit + prices[i] - price;

            }
            price = prices[i];
        }
        System.out.println(profit);

    }

    public static void main3(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        ArrayList<ArrayList<String>> finalresult = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            char[] chars = input[i].toCharArray();
            ArrayList<String> resulttemp = new ArrayList<>();

            Arrays.sort(chars);
            Map<String, ArrayList<String>> resulthash = new HashMap<>();
            String newchars = new String(chars);
            for (int j = 0; j < input.length; j++) {

                if (input[i].toCharArray().length == input[j].toCharArray().length) {
                    count = 0;
                    char[] chars1 = input[j].toCharArray();

                    Arrays.sort(chars1);
                    String newchars1 = new String(chars1);

                    if (newchars1.equals(newchars)) {
                        resulttemp.add(input[j]);

                    }

                }
            }

            finalresult.add(resulttemp);
        }

        for (int n = 0; n < finalresult.size(); n++) {
            System.out.println(finalresult.get(n));
        }
    }

    public static void main4(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        int i = m - 1;
        int j = n - 1;
        int right = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[right--] = nums1[i--];
            else
                nums1[right--] = nums2[j--];
        }
        while (j >= 0) {
            nums1[right--] = nums2[j--];
        }


    }

    public static void main5(String[] args) {
        String S = "xywrrmp";
        String T = "xywrrmu#p";

        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stack1 = new Stack<Character>();
        char[] temp = S.toCharArray();
        char[] temp1 = T.toCharArray();
        Scanner scan = new Scanner(System.in);
        double a = 4.0;
        int f = (int) (a);


        for (int i = 0; i < temp1.length; i++) {
            if (temp1[i] == '#') {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else
                stack1.push(temp[i]);

        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else
                stack.push(temp[i]);

        }

        for (Character character : stack) {
            System.out.println(character);
        }
        String tempstring = new String(stack.toString());
        String tempstring1 = new String(stack1.toString());
        if (tempstring.equals(tempstring1)) {
            System.out.println("true");
        }

    }

    public static void main6(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        m.push(0);
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());
    }

    public static void main7(String[] args) {
        Integer[] test = {2, 7, 4, 1, 8, 1};
        Arrays.sort(test, Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : test) {
            list.add(integer);
        }
        while (list.size() != 1) {
            list.sort(Collections.reverseOrder());
            Integer temp1 = list.get(0);
            Integer temp2 = list.get(1);
            if (temp1 == temp2) {
                list.remove(0);
                list.remove(0);
            } else if (temp1 != temp2) {
                int newtemp = temp1 - temp2;

                list.remove(0);
                list.remove(0);
                list.add(newtemp);
            }


        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(0);
        for (int i = 0; i < test.length; i++) {
            pq.add(test[i]);
        }
        for (Integer integer : pq) {
            System.out.println(integer);
        }

        pq.offer(5);
        pq.poll();
        for (Integer integer : pq) {
            System.out.println(integer);
        }

    }

    public static int sum(int i) {
        int sum2 = 0;
        if (i == 1 || i == 0) {
            return 1;
        }
        sum2 = i * sum(i - 1);
        return sum2;


    }

    public static String stringReverse(String word) {
        if (word.isEmpty()) {
            return word;
        } else {
            String substring = word.substring(1);
            String subSolution = stringReverse(substring);
            String Solution = subSolution + word.charAt(0);
            return Solution;
        }
    }

}



