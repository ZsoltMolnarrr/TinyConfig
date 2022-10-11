package net.tinyconfig.models;

public class Vec2f {
    public static final Vec2f ZERO = new Vec2f(0.0F, 0.0F);
    public static final Vec2f UP_RIGHT_UNIT = new Vec2f(1.0F, 1.0F);
    public static final Vec2f RIGHT_UNIT = new Vec2f(1.0F, 0.0F);
    public static final Vec2f LEFT_UNIT = new Vec2f(-1.0F, 0.0F);
    public static final Vec2f DOWN_UNIT = new Vec2f(0.0F, 1.0F);
    public static final Vec2f UP_UNIT = new Vec2f(0.0F, -1.0F);
    public static final Vec2f DOWN_LEFT = new Vec2f(-1.0F, -1.0F);
    public static final Vec2f MAX_UP_RIGHT = new Vec2f(Float.MAX_VALUE, Float.MAX_VALUE);
    public static final Vec2f MIN_DOWN_LEFT = new Vec2f(Float.MIN_VALUE, Float.MIN_VALUE);
    public final float x;
    public final float y;

    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2f multiply(float value) {
        return new Vec2f(this.x * value, this.y * value);
    }

    public float dot(Vec2f vec) {
        return this.x * vec.x + this.y * vec.y;
    }

    public Vec2f add(Vec2f vec) {
        return new Vec2f(this.x + vec.x, this.y + vec.y);
    }

    public Vec2f add(float value) {
        return new Vec2f(this.x + value, this.y + value);
    }

    public boolean equals(Vec2f other) {
        return this.x == other.x && this.y == other.y;
    }

    public Vec2f normalize() {
        float f = (float) Math.sqrt(this.x * this.x + this.y * this.y);
        return f < 1.0E-4F ? ZERO : new Vec2f(this.x / f, this.y / f);
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public float distanceSquared(Vec2f vec) {
        float f = vec.x - this.x;
        float g = vec.y - this.y;
        return f * f + g * g;
    }

    public Vec2f negate() {
        return new Vec2f(-this.x, -this.y);
    }
}
