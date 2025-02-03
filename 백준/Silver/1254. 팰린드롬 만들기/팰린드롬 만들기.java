import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int len;
    static String str;
    public static void main(String[] args) throws IOException {
        input();
        int add =0;
        for (int i = 0; i < len; i++) {
            if(isPalindrome(str.substring(i,len))) {
                add = i;
                break;
            }
        }
        System.out.println(len+add);
    }

    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
    }
}