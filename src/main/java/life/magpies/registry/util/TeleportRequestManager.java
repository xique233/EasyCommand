package life.magpies.registry.util;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TeleportRequestManager {
    private final Set<TeleportRequest> requests = new HashSet<>();

    // 添加一个请求到请求池中（若目标不存在）
    public void add(TeleportRequest request) {
        requests.add(request);
    }

    // 从请求池中删减一个请求（若目标存在）
    public void remove(TeleportRequest request) {
        requests.remove(request);
    }

    // 获取请求池快照
    public Set<TeleportRequest> getRequests() {
        return new HashSet<>(requests);
    }

    // 删除请求池中已过期的请求
    public void removeInvalidRequests() {
        requests.removeIf(req -> !req.isValid());
    }

    // 通过传送请求发起者和传送对象来获取池中的请求，若找不到则返回null
    public TeleportRequest getRequest(UUID sender, UUID target) {
        return requests.stream().filter(req -> target.equals(req.getTarget()) && sender.equals(req.getSender())).findAny().orElse(null);
    }
}
