package io.github.twinklekhj.ros.type.std;

import io.github.twinklekhj.ros.type.RosMessage;
import io.vertx.core.json.JsonObject;

import java.awt.*;

public class ColorRGBA extends RosMessage {
    public static final String FIELD_R = "r";
    public static final String FIELD_G = "g";
    public static final String FIELD_B = "b";
    public static final String FIELD_A = "a";

    public static final String TYPE = "std_msgs/ColorRGBA";

    private final float r, g, b, a;

    /**
     * Create a new ColorRGBA with all 0s for colors and an alpha value of 1.
     */
    public ColorRGBA() {
        this(0f, 0f, 0f, 1f);
    }

    /**
     * Create a new ColorRGBA with the given color values (alpha will be 1).
     *
     * @param r The r value of the color.
     * @param g The g value of the color.
     * @param b The b value of the color.
     */
    public ColorRGBA(float r, float g, float b) {
        this(r, g, b, 1f);
    }

    /**
     * Create a new ColorRGBA with the given color values.
     *
     * @param r The r value of the color.
     * @param g The g value of the color.
     * @param b The b value of the color.
     * @param a The a value of the color.
     */
    public ColorRGBA(float r, float g, float b, float a) {
        // build the JSON object
        super(jsonBuilder().put(ColorRGBA.FIELD_R, r).put(ColorRGBA.FIELD_G, g).put(ColorRGBA.FIELD_B, b).put(ColorRGBA.FIELD_A, a), ColorRGBA.TYPE);
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    /**
     * Create a new ColorRGBA based on the color information in the Java Color
     * object.
     *
     * @param c The Java Color object containing the color information.
     * @return A new ColorRGBA message based on the given color information.
     */
    public static ColorRGBA fromColor(Color c) {
        float r = c.getRed() / 255.0f;
        float g = c.getGreen() / 255.0f;
        float b = c.getBlue() / 255.0f;
        float a = c.getAlpha() / 255.0f;
        return new ColorRGBA(r, g, b, a);
    }

    public static ColorRGBA fromJsonString(String jsonString) {
        return ColorRGBA.fromMessage(new RosMessage(jsonString, TYPE));
    }

    public static ColorRGBA fromMessage(RosMessage m) {
        return ColorRGBA.fromJsonObject(m.getJsonObject());
    }

    public static ColorRGBA fromJsonObject(JsonObject jsonObject) {
        float r = jsonObject.containsKey(ColorRGBA.FIELD_R) ? jsonObject.getDouble(ColorRGBA.FIELD_R).floatValue() : 0f;
        float g = jsonObject.containsKey(ColorRGBA.FIELD_G) ? jsonObject.getDouble(ColorRGBA.FIELD_G).floatValue() : 0f;
        float b = jsonObject.containsKey(ColorRGBA.FIELD_B) ? jsonObject.getDouble(ColorRGBA.FIELD_B).floatValue() : 0f;
        float a = jsonObject.containsKey(ColorRGBA.FIELD_A) ? jsonObject.getDouble(ColorRGBA.FIELD_A).floatValue() : 0f;

        return new ColorRGBA(r, g, b, a);
    }

    public float getR() {
        return this.r;
    }

    public float getG() {
        return this.g;
    }

    public float getB() {
        return this.b;
    }

    public float getA() {
        return this.a;
    }

    public Color toColor() {
        return new Color(this.r, this.g, this.b, this.a);
    }

    @Override
    public ColorRGBA clone() {
        return new ColorRGBA(this.r, this.g, this.b, this.a);
    }
}
