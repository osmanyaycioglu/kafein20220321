package com.training.spring.core.confprop;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.training.spring.models.Person;

@Component
@ConfigurationProperties(prefix = "application.info")
public class AppConfiguration {

    private String              language = "tr";
    private String              desc     = "app desc";
    private Integer             index;
    private Long                build;
    private String              version;
    private List<String>        supportedLanguage;
    private HelloConf           hello;
    private List<Person>        personList;
    private Map<String, Person> personMap;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String languageParam) {
        this.language = languageParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(final Integer indexParam) {
        this.index = indexParam;
    }

    public Long getBuild() {
        return this.build;
    }

    public void setBuild(final Long buildParam) {
        this.build = buildParam;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(final String versionParam) {
        this.version = versionParam;
    }

    public Iterator<String> languageIterator() {
        return this.supportedLanguage.iterator();
    }

    public List<String> getSupportedLanguage() {
        return this.supportedLanguage;
    }

    public void setSupportedLanguage(final List<String> supportedLanguageParam) {
        this.supportedLanguage = supportedLanguageParam;
    }

    public HelloConf getHello() {
        return this.hello;
    }

    public void setHello(final HelloConf helloParam) {
        this.hello = helloParam;
    }


    public List<Person> getPersonList() {
        return this.personList;
    }


    public void setPersonList(final List<Person> personListParam) {
        this.personList = personListParam;
    }


    public Map<String, Person> getPersonMap() {
        return this.personMap;
    }


    public void setPersonMap(final Map<String, Person> personMapParam) {
        this.personMap = personMapParam;
    }

    @Override
    public String toString() {
        return "AppConfiguration [language="
               + this.language
               + ", desc="
               + this.desc
               + ", index="
               + this.index
               + ", build="
               + this.build
               + ", version="
               + this.version
               + ", supportedLanguage="
               + this.supportedLanguage
               + ", hello="
               + this.hello
               + ", personList="
               + this.personList
               + ", personMap="
               + this.personMap
               + "]";
    }


}
