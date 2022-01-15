package com.bellwisdom.boardserver.infra.resolver

import com.bellwisdom.boardserver.domain.member.Member
import com.bellwisdom.boardserver.infra.member.LoginMember
import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.core.ReactiveAdapterRegistry
import org.springframework.web.reactive.BindingContext
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolverSupport
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Configuration
class LoginMemberResolver(
    adapterRegistry: ReactiveAdapterRegistry
) : HandlerMethodArgumentResolverSupport(adapterRegistry) {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return checkAnnotatedParamNoReactiveWrapper(parameter, LoginMember::class.java) { _, clazz ->
            !Member::class.java.isAssignableFrom(clazz)
        }
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        bindingContext: BindingContext,
        exchange: ServerWebExchange
    ): Mono<Any> {
        return Mono.just(Member(email = "test@test.com", password = "password"))
    }

}