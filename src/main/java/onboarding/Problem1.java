package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 처리: 입력이 유효한지 확인
        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        // 각각의 점수 계산
        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        // 승패 결정
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }

    }
    // 유효한 입력인지 확인하는 메서드
    private static boolean isValidInput(List<Integer> arr) {
        if (arr.size() != 2) {
            return false;
        }
        int left = arr.get(0);
        int right = arr.get(1);
        if (left <= 0 || right <= 0 || right - left != 1) {
            return false;
        }
        return true;
    }
    // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해 가장 큰 수를 구하는 메서드
    private static int calculateScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftSum = calculateSum(leftPage);
        int rightSum = calculateSum(rightPage);

        int leftMultiply = calculateMultiply(leftPage);
        int rightMultiply = calculateMultiply(rightPage);

        return Math.max(leftSum, leftMultiply) + Math.max(rightSum, rightMultiply);
    }
    // 숫자의 각 자리 숫자를 곱하는 메서드
    // 각 자리 숫자의 곱을 계산하는 메서드
    // 숫자의 각 자리 숫자를 더하는 메서드
    private static int calculateSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
    // 숫자의 각 자리 숫자를 곱하는 메서드
    private static int calculateMultiply(int number) {
        int multiply = 1;

        while (number > 0) {
            multiply *= number % 10;
            number /= 10;
        }

        return multiply;
    }
}