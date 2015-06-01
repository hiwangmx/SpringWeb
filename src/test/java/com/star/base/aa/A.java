package com.star.base.aa;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedImage bufferedImaged = (BufferedImage) ImageIO.read(new File(
				A.class.getResource("we.jpg").getPath()));

		Integer width = bufferedImaged.getWidth();
		Integer height = bufferedImaged.getHeight();

		A a = new A();
		BufferedImage destImage = a.getGrayImage1(bufferedImaged);
		ImageIO.write(destImage, "jpg", new File("D://sss1.jpg"));

		System.out.println(width);
		System.out.println(height);

		System.out.println(A.class.getResource(""));
		System.out.println(A.class.getResource("/"));
		System.out.println(A.class.getClassLoader().getResource(""));
		System.out.println(A.class.getClassLoader().getResource("/"));
		System.out.println(A.class.getResource("we.jpg").getPath());
	}

	public BufferedImage getGrayImage(BufferedImage originalImage) {
		BufferedImage grayPicture;
		Integer width = originalImage.getWidth();
		Integer height = originalImage.getHeight();
		grayPicture = new BufferedImage(width, height,
				BufferedImage.TYPE_3BYTE_BGR);
		ColorConvertOp cco = new ColorConvertOp(
				ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
		cco.filter(originalImage, grayPicture);
		return grayPicture;
	}

	public BufferedImage getGrayImage1(BufferedImage originalImage) {
		int red, green, blue, rgb;
		Integer width = originalImage.getWidth();
		Integer height = originalImage.getHeight();
		for (int i = originalImage.getMinX(); i < width; i++) {
			for (int j = originalImage.getMinY(); i < height; i++) {
				Object data = originalImage.getRaster().getDataElements(i, j, null);
				red = originalImage.getColorModel().getRed(data);
				blue = originalImage.getColorModel().getBlue(data);
				green = originalImage.getColorModel().getGreen(data);
				red = (red * 3 + green * 6 + blue * 1) / 10;
				green = red;
				blue = green;
				rgb = (red * 256 + green) * 256 + blue;
				if (rgb > 8388608) {
					rgb = rgb - 16777216;
				}
				// 将rgb值写回图片
				originalImage.setRGB(i, j, rgb);
			}
		}
		return originalImage;
	}

}
