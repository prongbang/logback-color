package com.prongbang.logbackcolor.socket

import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketConfig
import com.corundumstudio.socketio.SocketIOServer
import com.prongbang.logbackcolor.context.Context
import com.prongbang.logbackcolor.logback.Logger
import io.netty.util.concurrent.Future

/**
 * Created by prongbang on 8/25/2016.
 */
class SocketServer {

    private var ctx: Context? = null
    private var server: SocketIOServer? = null

    fun start(ctx: Context, port: Int) {
        val config = Configuration()
        config.port = port
        config.socketConfig = SocketConfig().apply {
            isReuseAddress = true
        }

        this.ctx = ctx

        server = SocketIOServer(config)

        var startAttempt: Future<Void>? = null
        do {
            Logger.normal("Attempting to bind Socket Server to port ${port}")
            try {
                startAttempt = server?.startAsync()?.syncUninterruptibly()
            } catch (e: Exception) {
                Logger.red("Failed to bind Socket Server to port ${port}; retrying in 5 seconds")
                Thread.sleep(5000)
            }
        } while (startAttempt == null)
        Logger.green("Bound Socket Server to port ${port}")
    }

    fun stop() {
        server?.stop()
    }

    fun sendLog(type: String, text: String) {
        val log = EventLog()
        log.type = type
        log.text = text
        server?.broadcastOperations?.sendEvent("log", log)
    }

    class EventLog {
        var type: String? = null
        var text: String? = null
    }

}