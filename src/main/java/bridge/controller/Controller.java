package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.GameMessage;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void run() {
        outputView.printMessage(GameMessage.START_GAME_MESSAGE.getMessage());
        outputView.printMessage(GameMessage.ENTER_BRIDGE_SIZE_MESSAGE.getMessage());

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
    }


}
