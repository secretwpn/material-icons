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
    compile 'com.github.fcannizzaro:material-icons:0.1.1'
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
        <version>0.1.1</version>
    </dependency>
</dependencies>
```

###  Download JAR
[Release 0.1.1](https://github.com/fcannizzaro/material-icons/releases/tag/0.1.1)

## Usage
```java
// as BufferedImage
BufferedImage home =  new IconMaterial("home")
                          .color(Color.BLUE)     // optional, default : black
                          .size(32)              // optional, int pixel
                          .icon();
// as ImageIcon
ImageIcon icon = new IconMaterial("public")
                     .size(32)
                     .imageIcon();
```

## Screenshot

![some icons](https://raw.githubusercontent.com/fcannizzaro/material-icons/master/icons.png)

## Icons
See [Google Icons](https://design.google.com/icons/) for icons name
