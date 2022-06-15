package ua.com.javarush.json.strange_mistake;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class RealBean {
    protected final int id;
    protected final String name;

    protected Map<String, Object> additionalMap = new HashMap<>();

    //Аннотация используется для точной настройику конструктора при десериализации
    @JsonCreator
    public RealBean(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // позволяет методу получения возвращать Map, которая затем используется для сериализации дополнительных свойств JSON
    @JsonAnyGetter
    public Map<String, Object> getAdditionalMap() {
        return additionalMap;
    }

    //позволяет методу установки использовать Map при десериализации свойств JSON
    @JsonAnySetter
    public void setAdditionalMap(String name, Object value) {
        additionalMap.put(name, value);
    }
}