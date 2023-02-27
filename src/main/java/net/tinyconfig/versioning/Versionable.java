package net.tinyconfig.versioning;

public interface Versionable {
    int getSchemaVersion();
    void setSchemaVersion(int schemaVersion);
}
