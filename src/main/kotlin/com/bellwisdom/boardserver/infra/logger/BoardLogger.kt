package com.bellwisdom.boardserver.infra.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface BoardLogger {
    val log: Logger get() = LoggerFactory.getLogger(this.javaClass)
}