package com.training.spring.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import com.kafein.spring.KafeinConfig;
import com.training.spring.component.Hello;
import com.training.spring.component.HelloEsp;
import com.training.spring.component.HelloTr;
import com.training.spring.component.HelloWithPrefix;
import com.training.spring.component.IHello;
import com.training.spring.component.Language;
import com.training.spring.core.confprop.AppConfiguration;

@Configuration
@PropertySource("classpath:my.properties")
@Import(KafeinConfig.class)
public class MyConfiguration {

    @Autowired
    private Environment        env;

    @Autowired
    private ApplicationContext act;


    @Language("dynamic")
    @Bean(value = {
                    "dynamic-hello",
                    "hello-dynamic",
                    "xyz-dynamic"
    })
    @Order(1)
    @DependsOn(value = "hellodynamic2")
    public IHello hellodynamic3(final AppConfiguration ac) {
        System.out.println("Conf : " + ac);
        switch (ac.getLanguage()) {
            case "tr":
                return new HelloTr();
            case "eng":
                return new Hello();
            case "esp":
                return new HelloEsp();
            case "ex":
                return new HelloWithPrefix(ac.getHello()
                                             .getPrefix());
            default:
                return new Hello();
        }
    }

    @Language("dynamic3")
    @Bean
    @Order(2)
    public IHello hellodynamic2(@Value("${app.language}") final String lang) {
        switch (lang) {
            case "tr":
                return new HelloTr();
            case "eng":
                return new Hello();
            case "esp":
                return new HelloEsp();
            case "ex":
                return new HelloWithPrefix(this.env.getProperty("app.hello.prefix"));
            default:
                return new Hello();
        }
    }

    @Language("dynamic4")
    @Bean
    @Order(3)
    public IHello hellodynamic4(@Value("#{appConfiguration.language}") final String lang,
                                @Value("#{appConfiguration.hello.prefix}") final String prefix) {
        switch (lang) {
            case "tr":
                return new HelloTr();
            case "eng":
                return new Hello();
            case "esp":
                return new HelloEsp();
            case "ex":
                return new HelloWithPrefix(prefix);
            default:
                return new Hello();
        }
    }


    @Language("englishEx")
    @Primary
    @Bean
    public Hello helloEngEx() {
        Hello helloLoc = new Hello();
        // code
        return helloLoc;
    }

    @Language("dynamic2")
    @Bean
    @Order(4)
    public IHello hellodynamic() {
        String languageLoc = this.env.getProperty("app.language");
        switch (languageLoc) {
            case "tr":
                return new HelloTr();
            case "eng":
                return new Hello();
            case "esp":
                return new HelloEsp();
            case "ex":
                return new HelloWithPrefix(this.env.getProperty("app.hello.prefix"));
            default:
                return new Hello();
        }
    }

}
