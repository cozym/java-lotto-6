package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_IN_RANGE = 1;
    private static final int MAX_IN_RANGE = 45;
    private List<Integer> myNumbers;
    private int bonusNumber;

    public MyLottoNumbers(String input) {
        myNumbers = validateNumber(validateSplit(input));
    }

    private List<String> validateSplit(String input) {
        try {
            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
    }

    private List<Integer> validateNumber(List<String> splitInput) {
        try {
            List<Integer> splitInputNumbers = new ArrayList<>();
            for (String number : splitInput) {
                splitInputNumbers.add(validateRange(Integer.parseInt(number)));
            }
            return splitInputNumbers;
            } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자들만 입력 가능합니다.");
        }
    }

    private int validateRange(int number) {
        if (number < MIN_IN_RANGE || number > MAX_IN_RANGE) {
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자들만 입력 가능합니다.");
        }
        return number;
    }

    public List<Integer> getMyNumbers() {
        return myNumbers;
    }
}
