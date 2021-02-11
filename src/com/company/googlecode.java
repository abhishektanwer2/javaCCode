package com.company;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;


public class googlecode {
    static List<Integer>[] graph;
    static boolean[] v;
    static boolean[] e;
    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr=new int[n];
        float[] arrnew=new float[n];
        for(int i=0;i<arr.length;i++ ){
            arr[i]=s.nextInt();
        }
        arrnew=calculatemodemean(arr);
        System.out.println("Mode="+(int)arrnew[0]);
        System.out.println("Mean="+(int)arrnew[1]);

    }
public static float[] calculatemodemean(int[]arr){
        int countmaxval=0;
        int maxcount=0;
        float[]arrnew=new float[2];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
            sum+=arr[i];
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;

                }
            }
            if(count>maxcount){
                maxcount=count;
                countmaxval=arr[i];
            }
        }

        arrnew[0]=countmaxval;
        arrnew[1]=sum/(float)arr.length;

return arrnew;
}
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    Stack<int[]>neigbhourstack=new Stack<>();

    public static void main(String[] args) {
    // Scanner s=new Scanner(System.in);
    // int num=s.nextInt();
ArrayList<Integer>arrayList=new ArrayList<Integer>();
arrayList.add(1);
arrayList.add(2);

     Integer[]arr={1,20,2,3,8};
        for (int i : arrayList.stream().mapToInt(value -> value).toArray()) {
            System.out.println(i);
        }



     int[]newar=new int[arr.length];
     HashMap<Integer,Integer>hash=new HashMap<>();
     List<Integer>newFiltered=Arrays.asList(arr);
     //Collections.sort(newFiltered,Integer::compareTo);
       Integer num= newFiltered.stream().max(Math::min).get();
      //  List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
Integer.compare(1,2);
       // List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
     /*   List<Integer>filtereddata=  newFiltered.stream().filter((Integer test)->{
        if(test>2)return true;
        else return false;
        }).collect(Collectors.toList());
       */

           //  System.arraycopy(arr,0, newar, 0, arr.length);
//HashMap<Integer,Integer>hash=new HashMap<>();
  //  StringBuilder snew=new StringBuilder();
     //System.out.print(findmaxdifference(arr));
int[]computearray={1,0,0,2,0,0,3,0,0};
       // int k = 9;

        // if array contains repeated elements,
        // sort the array to handle duplicate combinations
        // Arrays.sort(A);

        // process elements from left to right
      //  recur(computearray, "", 0, computearray.length, k);


    }
    public static void recur(int[] A, String out, int i, int n, int k) {
        // invalid input
        if (k > n) {
            return;
        }

        // base case: combination size is k
        if (k == 0) {
            System.out.println(out);
            return;
        }

        // start from next index till last index
        for (int j = i; j < n; j++) {
            // add current element A[j] to solution & recur for next index
            // (j+1) with one less element (k-1)
            recur(A, out + " " + (A[j]), j + 1, n, k - 1);

            // uncomment below code to handle duplicates
			/* while (j < n - 1 && A[j] == A[j + 1]) {
				 j++;
			}*/
        }
    }
    private static int findmaxdifference(int[] arr) {
        if(arr.length<=1)return 0;
        int maxdiff=arr[1]-arr[0];

        for(int i=0;i<arr.length;i++){
            int max=0;
          for(int j=i+1;j<arr.length;j++){

                  max=arr[j]-arr[i];
                  if(max>maxdiff){
                      maxdiff=max;

              }
          }
        }
        if (maxdiff<0)return 0;
        return maxdiff;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0,product=1, j=0;
        for(int i=0;i<nums.length;i++)
        {
            product=product*nums[i];
            while(product>=k)
            {
                product=product/nums[j];
                j++;
            }
            count+=i-j+1;

        }   if (k <= 1) return 0;



        return count;
    }



    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> listNew = new ArrayList<>();
        int[] numsnew = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsnew[nums[i] - 1] = nums[i];

        }
        for (int i = 0; i < numsnew.length; i++) {
            if (numsnew[i] == 0) {
                listNew.add(i + 1);

            }
        }
        return listNew;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int zeroes = 0;
        int zeroInd = -1;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) len++;

            else {
                if (zeroes == 0) {
                    zeroInd = i;
                    len++;
                    zeroes++;
                } else {
                    len = i - zeroInd;
                    zeroInd = i;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static int thirdMax(int[] nums) {
        Set<Integer> numset = new HashSet<>();


        for (int i = 0; i < 3; i++) {
            Integer currentMax = findmax(nums, numset);
            if (currentMax == null) {
                return Collections.max(numset);

            }
            numset.add(currentMax);

        }


        return Collections.min(numset);
    }

    private static int findmax(int[] nums, Set<Integer> numset) {
        Integer maximum = null;
        for (int num : nums) {
            if (numset.contains(num)) continue;
            else {
                if (maximum == null || num > maximum) {
                    maximum = num;
                }
            }
        }

        return maximum;
    }

    public static int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        int b = 0;
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];
        Arrays.sort(B, Comparator.comparingInt(a -> a % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;


    }

    public static void test() {
        for (int i = 0; i < 23; i++) {

            if ("hello".contains("hel")) System.out.println("passed");
        }
    }

    public static int findDuplicate(int[] nums) {
        int pointer1 = nums[0];
        int pointer2 = nums[0];
        do {
            pointer1 = nums[pointer1];
            pointer2 = nums[nums[pointer2]];

        } while (pointer1 != pointer2);

        pointer1 = nums[0];
        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }
        return pointer2;
    }

    public static int[][] kClosest(int[][] points, int K) {

        int N = points.length;
        int[] dist = new int[N];
        for (int i = 0; i < N; ++i)
            dist[i] = distance(points[i]);
        int[][] ans = new int[K][2];
        int t = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        if (!set.contains(1)) {
            set.add(1);

        }
        set.stream().findAny().get();
        set.stream().findFirst().get();
        set.toArray();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(dist);
        int distk = dist[K - 1];
        for (int i = 0; i < N; ++i)
            if (distance(points[i]) <= distk)
                ans[t++] = points[i];
        return ans;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                p++;
                nums[p] = nums[i];
            }
        }


        return p + 1;
    }

    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(cur, max);
        }
        return arr;
    }

    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];

    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        v = new boolean[numCourses];
        e = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!v[i]) {
                if (checkcycle(i)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean checkcycle(int u) {
        v[u] = true;
        for (Integer m : graph[u]) {
            if (!v[m]) {
                if (checkcycle(m)) {
                    return true;
                }
            } else if (!e[m]) {
                return true;
            }
        }

        e[u] = true;
        return false;
    }

    public static void duplicateZeros(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] == 0) {

                for (int i = arr.length - 1; i > j; i--) {

                    arr[i] = arr[i - 1];

                }
                j++;
            }
        }
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null
                || A.length == 0 || B.length == 0
        ) return 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = (A[i] == B[j]
                        ? dp[i + 1][j + 1] + 1
                        : Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }


        return dp[0][0];
    }

    public static String countAndSay(int n) {
        String str = "1";
        if (n <= 1) return str;
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int count = 1;
            for (int j = 1; j < str.length(); j++) {

                if (str.charAt(j) == str.charAt(j - 1)) {
                    count++;
                } else {
                    cur.append(count);
                    cur.append(str.charAt(j - 1));
                    count = 1;
                }
            }
            cur.append(count);
            cur.append(str.charAt(str.length() - 1));

            str = cur.toString();
        }

        return str;


    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int countnew = 0;
        if (heights.length <= 1) return 0;


        for (int i = 0; i < heights.length - 1; i++) {
            countnew = 0;
            for (int j = 0; j < heights.length - i - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    countnew++;
                }


            }
            if (countnew > 0) {
                count++;
            }
        }
        return count;
    }

    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        for (char ch : s.toCharArray()) {

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            pq.offer(entry);
        }
        char[] arr = new char[s.length()];


        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> entry = pq.poll();

            char ch = entry.getKey();

            for (int i = 0; i < entry.getValue(); i++) {

                arr[count++] = ch;
            }
        }
        return new String(arr);

    }

    public static int majorityElement(int[] nums) {
        int i = 0;
        int element = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i == 0) {
                element = nums[j];
                i = 1;
            } else if (element == nums[j]) {
                i = i + 1;
            } else {
                i = i - 1;
            }

        }
        return element;
    }


    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (hash.containsKey(temp)) {
                hash.put(temp, hash.get(temp) + 1);

            } else {
                hash.put(temp, 1);
            }
        }
        for (int j = 0; j < length; j++) {
            if (hash.get(s.charAt(j)) == 1) return j;
        }
        return -1;
    }

    public static boolean isPerfectSquare(int num) {
        int l = 0, r = num;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long product = (long) mid * mid;
            if (product > num) r = mid - 1;
            else if (product == num) return true;
            else l = mid + 1;
        }
        return false;
    }


}
