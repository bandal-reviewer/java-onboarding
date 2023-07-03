package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = calculateScores(user, friends, visitors);
        List<String> recommendations = getRecommendations(scores);
        return recommendations;
    }
    private static Map<String, Integer> calculateScores(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        // 사용자의 친구들을 저장할 Set
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(user)) {
                userFriends.add(friend2);
            } else if (friend2.equals(user)) {
                userFriends.add(friend1);
            }
        }

        // 친구 추천 점수 계산
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
            }
        }

        // 사용자의 친구들의 점수는 10점으로 설정
        for (String friend : userFriends) {
            scores.put(friend, scores.getOrDefault(friend, 0) + 10);
        }

        return scores;
    }

    private static List<String> getRecommendations(Map<String, Integer> scores) {
        List<String> recommendations = new ArrayList<>(scores.keySet());

        recommendations.sort((a, b) -> {
            int scoreA = scores.get(a);
            int scoreB = scores.get(b);

            if (scoreA == scoreB) {
                return a.compareTo(b);
            }

            return Integer.compare(scoreB, scoreA);
        });

        if (recommendations.size() > 5) {
            recommendations = recommendations.subList(0, 5);
        }

        return recommendations;
    }
}
