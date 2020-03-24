package com.github.fcannizzaro.material.icons;

import com.github.fcannizzaro.material.icons.util.TintUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("unused")
public class IconMaterial {

	private BufferedImage icon;
	private Color color;

	/**
	 * @param iconSet icon set defines a subfolder / category e.g. Action, Communication
	 * @param name    icon name. Both ways "move_to_inbox" or "move to inbox" are supported
	 * @param size    icon size
	 */
	public IconMaterial(IconSet iconSet, String name, IconSize size) {
		try {
			// for jar packaging
			icon = ImageIO.read(getClass().getResource(getIconPath(iconSet, name, size.getSizeDp())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ImageIcon dp18(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp18).color(color).imageIcon();
	}

	public static ImageIcon dp24(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp24).color(color).imageIcon();
	}

	public static ImageIcon dp36(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp36).color(color).imageIcon();
	}

	public static ImageIcon dp48(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp48).color(color).imageIcon();
	}

	public enum IconSize {
		dp18(18),
		dp24(24),
		dp36(36),
		dp48(48);

		private final int sizeDp;

		/**
		 * @param sizeDp size in dp (device-independent pixels)
		 */
		IconSize(int sizeDp) {
			this.sizeDp = sizeDp;
		}

		public int getSizeDp() {
			return sizeDp;
		}
	}

	public enum IconSet {
		Action,
		Alert,
		Av,
		Communication,
		Content,
		Device,
		Editor,
		File,
		Hardware,
		Image,
		Maps,
		Navigation,
		Notification,
		Places,
		Social,
		Toggle
	}

	/**
	 * @param iconSet icon set defines a subfolder / category e.g. Action, Communication
	 * @param name    icon name. Both ways "move_to_inbox" or "move to inbox" are supported
	 * @param sizeDp  size in dp (device-independent pixels)
	 * @return path to image created from input parameters
	 */
	String getIconPath(IconSet iconSet, String name, int sizeDp) {
		return String.format(
				"/res/material-design-icons-master/%s/1x_web/%s_black_%ddp.png",
				iconSet.toString().toLowerCase(),
				name.replaceAll(" ", "_"),
				sizeDp
		);
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

	/**
	 * Create a BufferedImage and apply size/color
	 */
	public BufferedImage icon() {
		if (color != null)
			icon = TintUtils.color(icon, color);
		return icon;
	}
}
