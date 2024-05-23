import java.util.HashMap;

public class LongestPerformingStreak {

    public static void main(String[] args) {
        // Sample input
        int N = 7;
        int[] hoursWorked = {9, 8, 10, 6, 12, 8, 14};

        // Calculate the longest-performing streak
        int longestStreak = findLongestPerformingStreak(N, hoursWorked);
        System.out.println(longestStreak);
    }

    public static int findLongestPerformingStreak(int N, int[] hoursWorked) {
        int[] transformed = new int[N];
        for (int i = 0; i < N; i++) {
            transformed[i] = hoursWorked[i] > 8 ? 1 : -1;
        }

        HashMap<Integer, Integer> cumulativeSumIndexMap = new HashMap<>();
        cumulativeSumIndexMap.put(0, -1); // To handle cases where the sum is positive from the start
        int cumulativeSum = 0;
        int longestStreak = 0;

        for (int i = 0; i < N; i++) {
            cumulativeSum += transformed[i];

            if (cumulativeSum > 0) {
                longestStreak = i + 1;
            } else {
                if (!cumulativeSumIndexMap.containsKey(cumulativeSum)) {
                    cumulativeSumIndexMap.put(cumulativeSum, i);
                }

                if (cumulativeSumIndexMap.containsKey(cumulativeSum - 1)) {
                    int previousIndex = cumulativeSumIndexMap.get(cumulativeSum - 1);
                    longestStreak = Math.max(longestStreak, i - previousIndex);
                }
            }
        }

        return longestStreak;
    }
}
