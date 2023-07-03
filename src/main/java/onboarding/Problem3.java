package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            count += countClaps(i);
        }

        return count;
    }
    private static int countClaps(int num) {
        int count = 0;
        int current = num;

        while (current > 0) {
            int digit = current % 10;

            if (digit % 3 == 0 && digit != 0) {
                count++;
            }

            current /= 10;
        }

        return count;
    }
}
