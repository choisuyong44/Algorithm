import java.io.*;
import java.util.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        int maxLen = 0;
        int firstIdx = -1, secondIdx = -1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String a = words.get(i);
                String b = words.get(j);
                int len = commonPrefixLength(a, b);
                if (len > maxLen) {
                    maxLen = len;
                    firstIdx = i;
                    secondIdx = j;
                }
            }
        }

        System.out.println(words.get(firstIdx));
        System.out.println(words.get(secondIdx));
    }

    private static int commonPrefixLength(String a, String b) {
        int len = 0;
        while (len < a.length() && len < b.length() && a.charAt(len) == b.charAt(len)) {
            len++;
        }
        return len;
    }
}