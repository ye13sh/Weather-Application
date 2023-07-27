package com.weather.commonDto;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class JsonDeserial extends StdDeserializer<WeatherDto> {
    public JsonDeserial() {
        this(null);
    }

    private final ObjectMapper mapper;

    public JsonDeserial(ObjectMapper mapper) {
        super(WeatherDto.class);
        this.mapper = mapper;
    }

    @Override
    public WeatherDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        JsonNode node = mapper.readTree(jsonParser);

        String name = node.get("name").asText();
        WeatherMain main = mapper.treeToValue(node.get("main"), WeatherMain.class);


        return new WeatherDto(name, main);
    }
}
