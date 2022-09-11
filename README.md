# 🔧 TinyConfig
Super small server side config library.

## Installation

Add this mod as dependency into your build.gradle file.

Add artifact repository.

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```
Add dependency, for Fabric workspace:
```groovy
dependencies {
    implementation include("com.github.ZsoltMolnarrr:TinyConfig:VERSION_TAG")
}
```

Add dependency, for Architectury workspace:
```groovy
// common/build.gradle
dependencies {
    implementation("com.github.ZsoltMolnarrr:TinyConfig:VERSION_TAG")
}
// fabric/build.gradle & forge/build.gradle
dependencies {
    shadowCommon(common("com.github.ZsoltMolnarrr:TinyConfig:VERSION_TAG"))
}
```
(Substitute `VERSION_TAG` with the latest release tag of this library, for example: `1.0.0`)

## Usage

```java
private final ConfigManager<ExampleConfig> manager = new ConfigManager<ExampleConfig>
        ("server", new ExampleConfig())
                .builder()
                .enableLogging(true)
                .setDirectory("example-mod")
                .sanitize(true)
                .build();

@Override
public void onInitialize(){
        manager.refresh();
}
```