package com.prongbang.logbackcolor.logback

import com.prongbang.logbackcolor.context.Context
import org.slf4j.LoggerFactory
import org.slf4j.Marker
import org.slf4j.MarkerFactory

/**
 * Created by prongbang on 8/25/2016.
 */
class Logger {

    companion object {

        private var ctx: Context? = null

        private val LOGGER = LoggerFactory.getLogger(Logger::class.java)

        enum class Color(val marker: Marker) {
            BLACK(MarkerFactory.getMarker("black")),
            RED(MarkerFactory.getMarker("red")),
            GREEN(MarkerFactory.getMarker("green")),
            YELLOW(MarkerFactory.getMarker("yellow")),
            BLUE(MarkerFactory.getMarker("blue")),
            MAGENTA(MarkerFactory.getMarker("magenta")),
            CYAN(MarkerFactory.getMarker("cyan")),
            WHITE(MarkerFactory.getMarker("white"));
        }

        fun info(text: String, color: Color = Color.WHITE, vararg args: Any) {
            LOGGER.info(color.marker, text, args)
        }

        fun debug(text: String, color: Color = Color.WHITE, vararg args: Any) {
            LOGGER.debug(color.marker, text, args)
        }

        fun error(text: String, color: Color = Color.WHITE, vararg args: Any) {
            LOGGER.error(color.marker, text, args)
        }

        fun warn(text: String, color: Color = Color.WHITE, vararg args: Any) {
            LOGGER.warn(color.marker, text, args)
        }

        fun trace(text: String, color: Color = Color.WHITE, vararg args: Any) {
            LOGGER.trace(color.marker, text, args)
        }

        fun normal(text: String = "") {
            info(text, Color.WHITE)
            ctx?.server?.sendLog("normal", text)
        }

        fun black(text: String = "") {
            info(text, Color.BLACK)
            ctx?.server?.sendLog("black", text)
        }

        fun red(text: String = "") {
            warn(text, Color.RED)
            ctx?.server?.sendLog("red", text)
        }

        fun green(text: String = "") {
            info(text, Color.GREEN)
            ctx?.server?.sendLog("green", text)
        }

        fun yellow(text: String = "") {
            info(text, Color.YELLOW)
            ctx?.server?.sendLog("yellow", text)
        }

        fun blue(text: String = "") {
            info(text, Color.BLUE)
            ctx?.server?.sendLog("blue", text)
        }

        fun magenta(text: String = "") {
            info(text, Color.MAGENTA)
            ctx?.server?.sendLog("magenta", text)
        }

        fun cyan(text: String = "") {
            info(text, Color.CYAN)
            ctx?.server?.sendLog("cyan", text)
        }

        fun white(text: String = "") {
            info(text, Color.WHITE)
            ctx?.server?.sendLog("white", text)
        }

        fun setContext(ctx: Context) {
            this.ctx = ctx
        }
    }
}