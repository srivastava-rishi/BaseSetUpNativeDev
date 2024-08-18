package com.rishi.basesetup.utils

/**
 * Navigation Extension Helpers ====================================
 */
fun String.addRoutePath(pathName: String) = this.plus("/{$pathName}")

fun String.withPath(pathName: String) = this.plus("/$pathName")

fun String.addRouteArgument(argName: String) =
    this.plus("?").plus(argName).plus("={").plus(argName).plus("}")

fun String.withArg(argName: String, argValue: String) =
    "$this?$argName=${argValue}"

//==================================== ====================================
