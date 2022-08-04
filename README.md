# 🔧 TinyConfig
Super tiny server side config library.

## Installation

Add this mod as dependency into your build.gradle file.

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    modImplementation include("com.github.ZsoltMolnarrr:TinyConfig:VERSION_TAG")
}
```

(Substitute `VERSION_TAG` with the latest release tag of this library, for example: `1.0.0`)

## Usage

```java
private final ConfigManager manager = new ConfigManager<ExampleConfig>
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