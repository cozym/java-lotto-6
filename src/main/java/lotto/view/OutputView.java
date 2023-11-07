package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchResult;
import lotto.model.OutputByRank;

public class OutputView {
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---";

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        printEmptyLine();
        System.out.printf("%d개를 구매했습니다.\n",lottos.count());
        for (Lotto lotto : lottos.get()) {
            System.out.println(lotto.getSortedNumbers());
        }
        printEmptyLine();
    }

    public static void printMatchResult(MatchResult matchResult) {
        OutputByRank[] outputByRanks = OutputByRank.values();
        printEmptyLine();
        System.out.println(RESULT_MESSAGE);
        System.out.println(DIVIDING_LINE);
        for (int idx = 0; idx < outputByRanks.length; idx++) {
            System.out.print(outputByRanks[idx].getOutput());
            System.out.printf("%d개",matchResult.getMatchCountByRank()[idx]);
            printEmptyLine();
        }
    }

    public static void printEarningsRate() {

    }
}
