package com.github.fcannizzaro.material.icons;

import com.github.fcannizzaro.material.icons.util.TintUtils;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.swing.*;
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
            // for jar packaging
            icon = ImageIO.read(getClass().getResource("/res/" + name.replaceAll(" ", "_") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * choose icon
     */
    public IconMaterial name(int size) {
        this.size = size;
        return this;
    }


    /**
     * set size of icon
     */
    public IconMaterial size(int size) {
        this.size = size;
        return this;
    }

    /**
     * resize icon
     */
    private void resize() {
        try {
            icon = Thumbnails.of(icon).size(size, size).asBufferedImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set color
     */
    public IconMaterial color(Color color) {
        this.color = color;
        return this;
    }

    /**
     * create an ImageIcon
     */
    public ImageIcon imageIcon() {
        return new ImageIcon(icon());
    }

    public ImageIcon imageIcon(int width, int height, Color color){
		return new ImageIcon(this.color(color).icon().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
    
    /**
     * Create a BufferedImage and apply size/color
     */
    public BufferedImage icon() {

        if (size != 0)
            resize();

        if (color != null)
            icon = TintUtils.color(icon, color);

        return icon;

    }
}
