package com.bellwisdom.boardserver.infra.config

import com.bellwisdom.boardserver.infra.resolver.LoginMemberResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer

@Configuration
class WebfluxConfig(
    private val loginMemberResolver: LoginMemberResolver
) : WebFluxConfigurer {
    override fun configureArgumentResolvers(configurer: ArgumentResolverConfigurer) {
        configurer.addCustomResolver(loginMemberResolver)
    }
}