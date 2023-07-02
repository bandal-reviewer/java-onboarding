package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> invalidEmails = new HashSet<>(); // 중복된 이메일을 저장할 Set

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (hasDuplicateCharacters(nickname)) {
                invalidEmails.add(email); // 중복된 글자가 있을 경우 이메일을 추가
            }
        }

        return sortAndRemoveDuplicates(new ArrayList<>(invalidEmails));
    }
    private static boolean hasDuplicateCharacters(String nickname) {
        // 같은 글자가 연속적으로 포함되어 있는지 확인
        for (int i = 0; i < nickname.length() - 1; i++) {
            if (nickname.charAt(i) == nickname.charAt(i + 1)) {
                return true; // 중복된 글자가 있으면 true 반환
            }
        }
        return false; // 중복된 글자가 없으면 false 반환
    }

    private static List<String> sortAndRemoveDuplicates(List<String> emails) {
        emails.sort(null); // 이메일 목록을 오름차순으로 정렬
        List<String> result = new ArrayList<>();
        String prevEmail = null;

        for (String email : emails) {
            if (!email.equals(prevEmail)) {
                result.add(email); // 중복된 이메일 제거하고 결과 리스트에 추가
                prevEmail = email;
            }
        }

        return result;
    }

}
