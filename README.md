# material-icons
Java Material Design Icons from [Google](https://design.google.com/icons/)

[![](https://jitpack.io/v/fcannizzaro/material-icons.svg)](https://jitpack.io/#fcannizzaro/material-icons)

## Dependence

### Gradle
```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.fcannizzaro:material-icons:0.1.0'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.fcannizzaro</groupId>
        <artifactId>material-icons</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

###  Download JAR
[Release 0.1.0](https://github.com/fcannizzaro/material-icons/releases/tag/0.1.0)

## Usage
```java
BufferedImage home =  new IconMaterial("home")   // name icon
                          .color(Color.BLUE)       // optional, default : black
                          .size(32)                // optional, int pixel
                          .icon();
```

## Screenshot

![some icons](https://raw.githubusercontent.com/fcannizzaro/material-icons/master/icons.png)

## Icons
See [Google Icons](https://design.google.com/icons/) for icons name
