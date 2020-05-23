package com.natritmeyer.examplecucumberjvmspringframework.aut.implementations.desktop;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public String getSaveToMe() {
        return saveToMe;
    }

    public void setSaveToMe(String saveToMe) {
        this.saveToMe = saveToMe;
    }

    private String saveToMe;



    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(String key){
        return scenarioContext.get(key);
    }

    public Boolean isContains(String key){
        return scenarioContext.containsKey(key);
    }
}
