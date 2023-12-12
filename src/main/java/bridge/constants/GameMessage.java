package bridge.constants;

public enum GameMessage {
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    ENTER_UP_OR_DOWN_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");



    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

