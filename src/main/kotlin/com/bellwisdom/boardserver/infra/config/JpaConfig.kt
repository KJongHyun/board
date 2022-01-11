package com.bellwisdom.boardserver.infra.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import javax.sql.DataSource

@EnableJpaAuditing
@Configuration
class JpaConfig {

    @Bean
    fun dataSource(): DataSource {
        return HikariDataSource().apply {
            this.driverClassName = "com.mysql.cj.jdbc.Driver"
            this.jdbcUrl =
                "jdbc:mysql://192.168.35.233:3306/dev_board?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true"
            this.username = "eclass"
            this.password = "Elcass0925!"
        }
    }
}