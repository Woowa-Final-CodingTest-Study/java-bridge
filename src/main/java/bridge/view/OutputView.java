package bridge.view;

import static bridge.constants.Constants.singleBridgeMap;

import bridge.constants.Constants;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // OutputView 클래스 내 printMap 메서드 수정
    // OutputView 클래스 내 printMap 메서드 수정
    public void printMap(int size, List<String> userPositions, List<String> computerPositions) {
        StringBuilder topRow = new StringBuilder("[");
        StringBuilder bottomRow = new StringBuilder("[");

        for (int i = 0; i <= size; i++) {
            String userPosition = (i < userPositions.size()) ? userPositions.get(i) : "";
            String computerPosition = (i < computerPositions.size()) ? computerPositions.get(i) : "";

            if ("U".equals(userPosition)) {
                if ("U".equals(computerPosition)) {
                    topRow.append(" O ");
                } else {
                    topRow.append(" X ");
                }
                bottomRow.append("   ");
            } else if ("D".equals(userPosition)) {
                topRow.append("   ");
                if ("D".equals(computerPosition)) {
                    bottomRow.append(" O ");
                } else {
                    bottomRow.append(" X ");
                }
            } else {
                topRow.append("   ");
                bottomRow.append("   ");
            }

            if (i < size) {
                topRow.append("|");
                bottomRow.append("|");
            }
        }

        topRow.append("]");
        bottomRow.append("]");

        System.out.println(topRow.toString());
        System.out.println(bottomRow.toString());
    }


    private String getRowSegment(String currentPosition, String row) {
        return " O ".equals(currentPosition == row) ? " O " : "   ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
