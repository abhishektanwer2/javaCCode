package practiseother;

import java.util.ArrayList;
import java.util.Arrays;

public class YoungTablue {
    public static void main(String[] args) {
        int[] young = {9, 16, 3, 2, 4, 8, 5, 14, 12};
        int[][] young_t = new int[4][4];
        ArrayList<Integer> young_sorted = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Arrays.fill(young_t[i], Integer.MAX_VALUE);

        }
        System.out.println(" Inserting all elements");

        for (int i = 0; i < young.length; i++) {
            insert_key(young_t, young_t.length - 1, young_t[0].length - 1, young[i]);

        }
        displayAll(young_t);
        System.out.println("elment search 12:" + searchelement(young_t, 12));
        System.out.println("minimum element:" + extract_min(young_t));
        displayAll(young_t);

        System.out.println("Sorted list after removal one element");
        sortelement(young_sorted, young_t, young.length);
        young_sorted.stream().forEach(System.out::println);

    }

    public static void displayAll(int[][] young_t) {
        System.out.println("***********************");
        System.out.println("ALL elements");
        for (int i = 0; i < young_t.length; i++) {
            for (int j = 0; j < young_t[0].length; j++) {
                System.out.print(young_t[i][j] == Integer.MAX_VALUE ? "infinity " : young_t[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("***********************");
    }

    public static void insert_key(int[][] young_t, int i, int j, int key) {
        int x, y, max, temp;

        if (young_t[i][j] < key) {
            System.out.println("No more insertions possible. Or the tableau is full");
            return;
        }
        young_t[i][j] = key;
        x = i;
        y = j;
        max = Integer.MAX_VALUE;

        while ((i > 0 || j > 0) && (max > young_t[i][j])) {
            temp = young_t[x][y];
            young_t[x][y] = young_t[i][j];
            young_t[i][j] = temp;
            i = x;
            j = y;

            if (i - 1 >= 0 && young_t[i][j] < young_t[i - 1][j]) {
                x = i - 1;
                y = j;
            }

            if (j - 1 >= 0 && young_t[x][y] < young_t[i][j - 1]) {
                x = i;
                y = j - 1;
            }
            max = young_t[x][y];
        }
    }

    public static void youngify(int[][] young_t, int i, int j, int m, int n) {
        int x, y;

        x = i;
        y = j;
        int temp;
        if (i + 1 < m) {
            if (young_t[i][j] > young_t[i + 1][j]) {
                x = i + 1;
                y = j;
            }
        }

        if (j + 1 < n) {
            if (young_t[x][y] > young_t[i][j + 1]) {
                x = i;
                y = j + 1;
            }
        }

        if (x != i || y != j) {
            temp = young_t[x][y];
            young_t[x][y] = young_t[i][j];
            young_t[i][j] = temp;
            youngify(young_t, x, y, m, n);
        }
    }

    public static int extract_min(int[][] young_t) {
        int x = young_t[0][0];
        young_t[0][0] = Integer.MAX_VALUE;
        youngify(young_t, 0, 0, 4, 4);
        return x;
    }

    public static boolean searchelement(int[][] young_t, int key) {

        int i = 0, j = young_t[0].length - 1;
        while (i < young_t.length && j >= 0) {
            if (young_t[i][j] < key) {
                i++;
            } else if (young_t[i][j] > key) {
                j--;
            } else {
                System.out.println(key + ": element found ");
                return true;
            }
        }
        System.out.println(key + ": element not found ");
        return false;
    }

    public static void sortelement(ArrayList<Integer> young_sorted, int[][] young_t, int len) {
        for (int i = 0; i < len; i++) {
            Integer min = extract_min(young_t);
            if (min != Integer.MAX_VALUE) {
                young_sorted.add(min);
            }

        }
    }


}
