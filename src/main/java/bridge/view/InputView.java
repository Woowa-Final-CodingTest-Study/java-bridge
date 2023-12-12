package bridge.view;

import bridge.constants.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        int bridgeSize = validateInteger(bridgeSizeInput);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    private int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private void validateBridgeSizeRange(int input) {
        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            String moving;
            try {
                String userMovingInput = Console.readLine();
                validateUserMovingInput(userMovingInput);
                return userMovingInput;
            }
            catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void validateUserMovingInput(String userMovingInput) {
        if (!userMovingInput.equals("U") && !userMovingInput.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_ERROR.getMessage());
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
