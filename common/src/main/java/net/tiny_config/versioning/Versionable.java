package net.tiny_config.versioning;

public interface Versionable {
    int getSchemaVersion();
    void setSchemaVersion(int schemaVersion);
}
