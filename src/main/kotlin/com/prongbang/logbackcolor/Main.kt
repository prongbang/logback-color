package com.prongbang.logbackcolor

import com.prongbang.logbackcolor.logback.Logger

/**
 * Created by prongbang on 8/25/2016.
 */
fun main(args: Array<String>) {

    Logger.info("info")
    Logger.debug("debug")
    Logger.error("error")
    Logger.warn("warn")
    Logger.trace("trace")
    Logger.normal("normal")
    Logger.black("black")
    Logger.white("white")
    Logger.blue("blue")
    Logger.green("green")
    Logger.red("red")
    Logger.yellow("yellow")
    Logger.magenta("magenta")
    Logger.cyan("cyan")

}