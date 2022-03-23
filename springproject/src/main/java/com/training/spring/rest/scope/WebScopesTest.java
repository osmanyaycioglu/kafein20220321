package com.training.spring.rest.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.training.spring.component.IHello;
import com.training.spring.component.Language;

@RestController
@RequestMapping("/web/scope")
@ApplicationScope
public class WebScopesTest {

    private int    webCounter = 0;

    @Autowired
    @Language("hello-tester")
    private IHello hello;

    @GetMapping("test1")
    public String abcTest(@RequestParam("name") final String name,
                          @RequestParam("sur") final String surname) {
        this.webCounter++;
        String str = this.hello.sayHello("xyz");
        return "WebCounter : " + this.webCounter + "  " + str;
    }
}
