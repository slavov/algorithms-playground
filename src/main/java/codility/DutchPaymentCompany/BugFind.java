package codility.DutchPaymentCompany;

import java.util.ArrayList;

public class BugFind {

    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<>();
        var solution = solution(N - 1, K - 1);
        for (String p : solution) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        //bug was here
        int prefSize = Math.min(result.size(), K <= 0 ? result.size() : K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }


// How I was trying to find a bug

    public static void main(String[] args) {
        BugFind s = new BugFind();
        //s.solution(5,0);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 100; j++) {

                var result = s.solution(i, j);
                //if (!m(result, j)) {
                System.out.println("i = " + i + " j = " + j);
                for(String fs : result) {
                    System.out.print(fs + ", ");
                }
                System.out.println();
                System.out.println("--------------");
            }
        }
    }

    static boolean m(String[] str, int n) {
        if(str.length > n) {
            return false;
        }
        if (!isSorted(str, str.length)) {
            return false;
        }
        if (containsDub(str)) {
            return false;
        }
        return true;
    }

    static private boolean containsDub(String[] str) {
        for (String s : str) {
            if (s.contains("aa") || s.contains("bb") || s.contains("cc"))
                return true;
        }
        return false;
    }

    static boolean isSorted(String[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }
}
