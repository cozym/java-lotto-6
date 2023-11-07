package lotto.model;

public class MatchResult {
    private static final int MAX_MATCH = 6;
    private static final int MIN_MATCH = 3;
    private int[] matchCountByRank;

    public MatchResult() {
        // 0번 인덱스부터 증가하며 3개 일치 개수, 4개일치 개수, ... 6개 일치 개수
        matchCountByRank = new int[] {0,0,0,0,0};
    }

    public void setMatchCountByRank(int count, int bonus) {
        if (count==MAX_MATCH) {
            count++;
        }
        if (bonus==1 && count==5) {
            count = count+bonus;
        }
        if (count >= MIN_MATCH) {
            matchCountByRank[count-MIN_MATCH]++;
        }
    }

    public int[] getMatchCountByRank() {
        return matchCountByRank;
    }
}
