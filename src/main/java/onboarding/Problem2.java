package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        removeDuplicates(sb);

        return sb.toString();

    }
    private static void removeDuplicates(StringBuilder sb) {
        boolean removed = true;

        while (removed) {
            removed = false;
            int length = sb.length();
            int i = 0;

            while (i < length - 1) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    length -= 2;
                    removed = true;
                } else {
                    i++;
                }
            }
        }
    }



}
