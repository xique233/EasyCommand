package life.magpies.utils

import life.magpies.utils.TeleportRequest
import java.util.*

class TeleportRequestManager {
    private val requests: MutableSet<TeleportRequest?> = HashSet()

    // 添加一个请求到请求池中（若目标不存在）
    fun add(request: TeleportRequest?) {
        requests.add(request)
    }

    // 从请求池中删减一个请求（若目标存在）
    fun remove(request: TeleportRequest?) {
        requests.remove(request)
    }

    // 获取请求池快照
    fun getRequests(): Set<TeleportRequest?> {
        return HashSet(requests)
    }

    // 删除请求池中已过期的请求
    fun removeInvalidRequests() {
        requests.removeIf { req: TeleportRequest? -> !req!!.isValid }
    }

    // 通过传送请求发起者和传送对象来获取池中的请求，若找不到则返回null
    fun getRequest(sender: UUID, target: UUID): TeleportRequest? {
        return requests.stream().filter { req: TeleportRequest? -> target == req!!.target && sender == req.sender }
            .findAny().orElse(null)
    }
}