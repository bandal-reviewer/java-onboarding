package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseString(word);
    }
    private static String reverseString(String str) {
        // 반대로 변환된 문자열을 저장할 변수
        String reversed = "";

        // 문자열을 앞에서부터 순회하면서 처리
        for (int i = 0; i < str.length(); i++) {
            // 현재 문자
            char ch = str.charAt(i);

            // 대문자인 경우
            if (Character.isUpperCase(ch)) {
                // 대문자를 반대로 변환하여 연결
                reversed += (char) ('Z' - (ch - 'A'));
            }
            // 소문자인 경우
            else if (Character.isLowerCase(ch)) {
                // 소문자를 반대로 변환하여 연결
                reversed += (char) ('z' - (ch - 'a'));
            }
            // 알파벳 외의 문자인 경우는 변환하지 않고 그대로 연결
            else {
                reversed += ch;
            }
        }

        // 반대로 변환된 문자열 반환
        return reversed;
    }
}
