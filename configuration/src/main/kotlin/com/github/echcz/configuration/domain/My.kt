package com.github.echcz.configuration.domain

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "my")
@Component
data class My(var name: String = "echcz", var msg: String = "")