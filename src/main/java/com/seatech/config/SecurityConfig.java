//package com.seatech.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/*").permitAll()
////                .antMatchers("/resources/*").anonymous()
//                .antMatchers("/add-page").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/")
//                .defaultSuccessUrl("/product/allProduct")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403")
//                .and()
//                .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username,password from T_USER where username=?)")
//                .authoritiesByUsernameQuery(
//                        "select username, role_name from T_USER join T_ROLE where username=?");
//    }
//
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/css/**")
////                .antMatchers("/fonts/**")
////                .antMatchers("/images/**")
////                .antMatchers("/js/**")
////                .antMatchers("vendor");
////    }
//}