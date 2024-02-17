package life.magpies.utils

import java.util.*

class TeleportRequest(// 获取请求发起者的UUID
    val sender: UUID, // 获取传送对象的UUID
    val target: UUID
) {
    // 获取本请求的过期时间，形式为时间戳
    private val time: Long = System.currentTimeMillis() + 30000L // 有效时间30000毫秒，即30秒

    val isValid: Boolean
        // 判断本请求是否已过期
        get() = System.currentTimeMillis() <= time
}