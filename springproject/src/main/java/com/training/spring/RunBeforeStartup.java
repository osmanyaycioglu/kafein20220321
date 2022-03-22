package com.training.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.kafein.spring.AnyBean;
import com.training.spring.component.IHello;
import com.training.spring.component.Language;

@Component

//@Controller
//@Repository
//@Service
//@Configuration

public class RunBeforeStartup implements ApplicationRunner {

    @Autowired
    @Language("dynamic")
    private IHello       hello1;

    @Autowired
    private List<IHello> hellos;

    @Autowired
    private AnyBean      anyBean;

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println("------------------------0-------------------------------");
        for (IHello iHelloLoc : this.hellos) {
            System.out.println("IHello : "
                               + iHelloLoc.getClass()
                                          .getName());
        }
        System.out.println("------------------------0-------------------------------");


        System.out.println("**** Çalıştım : " + this.hello1.sayHello("mehmet"));
        System.out.println(this.anyBean.process("osman"));
    }

}
