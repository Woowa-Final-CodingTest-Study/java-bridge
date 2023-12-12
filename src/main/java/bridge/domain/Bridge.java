package bridge.domain;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }
}
