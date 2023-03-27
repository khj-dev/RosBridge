package io.github.twinklekhj.ros.type.geometry;


import io.github.twinklekhj.ros.type.RosMessage;
import io.vertx.core.json.JsonObject;
import lombok.ToString;

@ToString
public class Pose extends RosMessage {
    public static final String TYPE = "geometry_msgs/Pose";

    public static final String FIELD_POSITION = "position";
    public static final String FIELD_ORIENTATION = "orientation";

    private Point position;
    private Quaternion orientation;

    public Pose() {
        this(new Point(), new Quaternion());
    }

    public Pose(Point position, Quaternion orientation) {
        this.position = position;
        this.orientation = orientation;

        JsonObject json = jsonBuilder()
                .put(FIELD_POSITION, position.getJsonObject())
                .put(FIELD_ORIENTATION, orientation.getJsonObject());
        super.setJsonObject(json);
        super.setType(TYPE);
    }

    public static Pose fromJsonString(String jsonString) {
        return Pose.fromMessage(new RosMessage(jsonString, TYPE));
    }

    public static Pose fromMessage(RosMessage m) {
        return Pose.fromJsonObject(m.getJsonObject());
    }

    public static Pose fromJsonObject(JsonObject jsonObject) {
        Point position = jsonObject.containsKey(FIELD_POSITION) ? Point.fromJsonObject(jsonObject.getJsonObject(FIELD_POSITION)) : new Point();
        Quaternion orientation = jsonObject.containsKey(FIELD_ORIENTATION) ? Quaternion.fromJsonObject(jsonObject.getJsonObject(FIELD_ORIENTATION)) : new Quaternion();
        return new Pose(position, orientation);
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
        this.jsonObject.put(FIELD_POSITION, position.getJsonObject());
    }

    public Quaternion getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Quaternion orientation) {
        this.orientation = orientation;
        this.jsonObject.put(FIELD_ORIENTATION, orientation.getJsonObject());
    }

    @Override
    public Pose clone() {
        return new Pose(this.position, this.orientation);
    }
}
