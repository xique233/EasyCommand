package life.magpies.registry.util;

import java.util.UUID;

public class TeleportRequest {
    private final UUID sender;
    private final UUID target;
    private final long time;

    // 创建传送请求要提供请求发起者和传送对象的UUID
    public TeleportRequest(UUID sender, UUID target) {
        this.sender = sender;
        this.target = target;
        this.time = System.currentTimeMillis() + 30000L; // 有效时间30000毫秒，即30秒
    }

    // 获取请求发起者的UUID
    public UUID getSender() {
        return sender;
    }

    // 获取传送对象的UUID
    public UUID getTarget() {
        return target;
    }

    // 获取本请求的过期时间，形式为时间戳
    public long getTime() {
        return time;
    }

    // 判断本请求是否已过期
    public boolean isValid() {
        return System.currentTimeMillis() <= time;
    }
}
