package bridge.constants;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("[ERROR] 정수가 아닙니다."),
    BRIDGE_SIZE_RANGE_ERROR("[ERROR] 다리 길이의 범위가 잘못되었습니다."),
    INVALID_MOVING_ERROR("[ERROR] 유효하지 않은 입력입니다. 'U' 또는 'D'를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
