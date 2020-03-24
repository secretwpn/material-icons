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
	private double angle;

	/**
	 * @param iconSet icon set defines a subfolder / category e.g. Action, Communication
	 * @param name    icon name. Both ways "move_to_inbox" or "move to inbox" are supported
	 * @param size    icon size
	 */
	public IconMaterial(IconSet iconSet, String name, IconSize size) {
		final String iconPath = getIconPath(iconSet, name, size.getSizeDp());
		try {
			icon = ImageIO.read(getClass().getResource(iconPath));
		} catch (IOException e) {
			System.out.println(String.format("Failed to load icon '%s'", iconPath));
		}
	}

	private static BufferedImage rotate(BufferedImage srcImg, double angle) {
		int w = srcImg.getWidth();
		int h = srcImg.getHeight();

		BufferedImage dstImg = new BufferedImage(w, h, srcImg.getType());
		Graphics2D g2d = dstImg.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.rotate(Math.toRadians(angle), w / 2.0, h / 2.0);
		g2d.drawImage(srcImg, null, 0, 0);
		g2d.dispose();
		return dstImg;
	}

	public static ImageIcon dp18(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp18).color(color).imageIcon();
	}

	public static ImageIcon dp18(IconSet iconSet, String name, Color color, double angle) {
		return new IconMaterial(iconSet, name, IconSize.dp18).color(color).rotation(angle).imageIcon();
	}

	public static ImageIcon dp24(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp24).color(color).imageIcon();
	}

	public static ImageIcon dp24(IconSet iconSet, String name, Color color, double angle) {
		return new IconMaterial(iconSet, name, IconSize.dp24).color(color).rotation(angle).imageIcon();
	}

	public static ImageIcon dp36(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp36).color(color).imageIcon();
	}

	public static ImageIcon dp36(IconSet iconSet, String name, Color color, double angle) {
		return new IconMaterial(iconSet, name, IconSize.dp36).color(color).rotation(angle).imageIcon();
	}

	public static ImageIcon dp48(IconSet iconSet, String name, Color color) {
		return new IconMaterial(iconSet, name, IconSize.dp48).color(color).imageIcon();
	}

	public static ImageIcon dp48(IconSet iconSet, String name, Color color, double angle) {
		return new IconMaterial(iconSet, name, IconSize.dp48).color(color).rotation(angle).imageIcon();
	}

	/**
	 * @param iconSet icon set defines a subfolder / category e.g. Action, Communication
	 * @param name    icon name. Both ways "move_to_inbox" or "move to inbox" are supported
	 * @param sizeDp  size in dp (device-independent pixels)
	 * @return path to image created from input parameters
	 */
	public static String getIconPath(IconSet iconSet, String name, int sizeDp) {
		return String.format(
				"/res/material-design-icons-master/%s/1x_web/ic_%s_black_%ddp.png",
				iconSet.getFolder(),
				name.replaceAll(" ", "_"),
				sizeDp
		);
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
		Action("action"),
		Alert("alert"),
		Av("av"),
		Communication("communication"),
		Content("content"),
		Device("device"),
		Editor("editor"),
		File("file"),
		Hardware("hardware"),
		Image("image"),
		Maps("maps"),
		Navigation("navigation"),
		Notification("notification"),
		Places("places"),
		Social("social"),
		Toggle("toggle");
		private final String folder;

		/**
		 * @param folder where icons of this set are located
		 */
		IconSet(String folder) {
			this.folder = folder;
		}

		public String getFolder() {
			return folder;
		}
	}

	public IconMaterial color(Color color) {
		this.color = color;
		return this;
	}

	public IconMaterial rotation(double angle) {
		this.angle = angle;
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
		if (Double.compare(angle, 0) != 0)
			icon = rotate(icon, angle);
		return icon;
	}
}
