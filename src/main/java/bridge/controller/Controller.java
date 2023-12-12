package bridge.controller;

import bridge.constants.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printMessage(GameMessage.START_GAME_MESSAGE.getMessage());
        inputView.readBridgeSize();
    }


}
