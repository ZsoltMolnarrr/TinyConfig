package net.tinyconfig.versioning;

public class VersionableConfig implements Versionable {
    public int schema_version = 0;

    @Override
    public int getSchemaVersion() {
        return schema_version;
    }

    @Override
    public void setSchemaVersion(int schemaVersion) {
        schema_version = schemaVersion;
    }
}
