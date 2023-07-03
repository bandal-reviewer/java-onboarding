package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] denominations = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = countDenominations(money, denominations);

        // 배열을 이용해서 메모리 최적화
        return Arrays.asList(result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7], result[8]);

    }
    // 돈의 액수를 화폐 단위별로 변환하여 개수를 계산하는 함수
    private static int[] countDenominations(int money, int[] denominations) {
        int[] result = new int[denominations.length];

        for (int i = 0; i < denominations.length; i++) {
            result[i] = money / denominations[i]; // 화폐 개수 계산
            money %= denominations[i]; // 나머지 돈 계산
        }

        return result;
    }
}
