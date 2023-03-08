package io.github.twinklekhj.ros.op;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RosResponse implements RosOperation {
    private final Type op = Type.CALL_SERVICE;
    @NonNull
    private final String service;
    @NonNull
    private final boolean result;

    private String id;
    private JsonNode values;

    private static RosResponseBuilder builder() {
        return new RosResponseBuilder();
    }

    public static RosResponseBuilder builder(String service, boolean result) {
        return builder().service(service).result(result);
    }

    public String getService() {
        return service;
    }

    public boolean getResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JsonNode getValues() {
        return values;
    }

    public void setValues(JsonNode values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new JSONObject()
                .put("op", this.op.code)
                .put("service", this.service)
                .put("values", this.values)
                .put("result", this.result)
                .put("id", this.id).toString();
    }

    @Override
    public Type getOperation() {
        return this.op;
    }
}
