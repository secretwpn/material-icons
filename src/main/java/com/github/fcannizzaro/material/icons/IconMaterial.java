package com.github.fcannizzaro.material.icons;

import com.github.fcannizzaro.material.icons.util.TintUtils;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("unused")
public class IconMaterial {

    private BufferedImage icon;
    private Color color;
    private int size;

    public IconMaterial(String name) {
        try {
            // jar packaging
            icon = ImageIO.read(getClass().getResource("/res/" + name.replaceAll(" ", "_") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IconMaterial name(int size) {
        this.size = size;
        return this;
    }

    public IconMaterial size(int size) {
        this.size = size;
        return this;
    }

    private void resize() {
        try {
            icon = Thumbnails.of(icon).size(size, size).asBufferedImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IconMaterial color(Color color) {
        this.color = color;
        return this;
    }

    public BufferedImage icon() {

        if (size != 0)
            resize();

        if (color != null)
            icon = TintUtils.color(icon, color);

        return icon;

    }
}
