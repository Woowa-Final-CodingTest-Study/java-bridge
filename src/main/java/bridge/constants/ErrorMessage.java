package bridge.constants;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("[ERROR] 정수가 아닙니다."),
    BRIDGE_SIZE_RANGE_ERROR("[ERROR] 다리 길이의 범위가 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
