package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.GameMessage;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void run() {
        startGame();
        Bridge bridge = buildBridge();
        proceedGame(bridge, inputView);

    }

    public void startGame() {
        outputView.printMessage(GameMessage.START_GAME_MESSAGE.getMessage());
        outputView.printMessage(GameMessage.ENTER_BRIDGE_SIZE_MESSAGE.getMessage());
    }

    public Bridge buildBridge() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridge);
    }

    public void proceedGame(Bridge bridge, InputView inputView) {
        outputView.printMessage(GameMessage.ENTER_UP_OR_DOWN_MESSAGE.getMessage());
        List<String> bridgeForGame = bridge.getBridge();
        List<String> userBridge = new ArrayList<>();
        int bridgeSize = bridge.getBridgeSize();

        for (int i = 0, count = 1; i < bridgeForGame.size(); i++) {
            String moving = inputView.readMoving();
            userBridge.add(moving);
            outputView.printMap(i, userBridge, bridgeForGame);


            if (!bridgeForGame.get(i).equals(userBridge.get(i))) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String restartOrQuitInput = Console.readLine();
                if ("R".equals(restartOrQuitInput)) {
                    proceedGame(bridge, inputView);
                }
                if ("Q".equals(restartOrQuitInput)) {
                    // 최종 게임 결과
                    System.out.println("게임 성공 여부: 실패");
                    System.out.println("총 시도한 횟수: " + count);
                    break;
                }
            }

            if (count == bridgeForGame.size()) {
                // 최종게임 결과
                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: " + count);
            }
            count++; // 반복문이 한 번 돌 때마다 count 증가
        }
    }
}

