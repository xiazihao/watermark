package me.xiazihao;

import com.google.common.base.Preconditions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;

public class WaterMark {
    private static final String IMG_PATH = ClassLoader.getSystemResource("").getPath() + "img.jpg";

    private static final String ICON_PATH = ClassLoader.getSystemResource("").getPath() + "icon.png";

    private static final String OUT_PATH = ClassLoader.getSystemResource("").getPath() + "out.jpg";

//    public static void main(String[] argv) {
//        Builder builder = new Builder(ICON_PATH);
//        WaterMark build = builder.build();
//        try {
//            build.make(IMG_PATH, OUT_PATH);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private BufferedImage makeWaterMark(Image waterMarkImage, BufferedImage source, BufferedImage outputImage, Coordinate waterMarkCoordinate) throws IOException {
        Graphics2D graphics = outputImage.createGraphics();
        graphics.drawImage(source, 0, 0, source.getWidth(), source.getHeight(), null);
        System.out.println(waterMarkCoordinate.getX() + "  " + waterMarkCoordinate.getY());
        graphics.drawImage(waterMarkImage, (int)waterMarkCoordinate.getX(), (int)waterMarkCoordinate.getY(), waterMarkImage.getWidth(null), waterMarkImage.getHeight(null), null);
        graphics.dispose();
        return outputImage;
    }

    //deepest
    public boolean make(File sourceFile, File targetFile, WaterMarkLocation waterMarkLocation) throws IOException {
        System.out.println(targetFile.getPath());
        if (!targetFile.exists()) {
            boolean createNewFileResutl = targetFile.createNewFile();
        } else {
            //TODO
        }
        BufferedImage sourceImage = ImageIO.read(sourceFile);
        if (sourceImage == null || sourceImage.getWidth() < 0 || sourceImage.getHeight() < 0) {
            return false;
        }

        double x = this.getWaterMarkImage().getIconWidth() * this.waterMarkScale.getX();
        double y = this.getWaterMarkImage().getIconHeight() * this.waterMarkScale.getY();
//        System.out.println("watermark: " + (int)x + "  " + (int)y);
        Image scaledImage = this.getWaterMarkImage().getImage().getScaledInstance((int) x, (int) y, Image.SCALE_SMOOTH);
        //TODO 疑问
        ImageIcon imageIcon = new ImageIcon(scaledImage);
//        System.out.println("scaled :" + imageIcon.getIconWidth() + "  " + imageIcon.getIconHeight());
        BufferedImage outputImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), sourceImage.getType());
        Coordinate startCoordinate = waterMarkLocation.getStartCoordinate(new Size(sourceImage.getWidth(), sourceImage.getHeight()), new Size(scaledImage.getWidth(null), scaledImage.getHeight(null)));
        BufferedImage bufferedImage = this.makeWaterMark(scaledImage, sourceImage, outputImage, startCoordinate);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        ImageIO.write(bufferedImage, "JPG", fileOutputStream);
        fileOutputStream.close();
        return true;
    }

    public int makeFromDirectory(File sourceFileDirectory, File targetFileDirectory) {
        File[] files = sourceFileDirectory.listFiles();
        if (files == null) {
            return 0;
        }
        for (File sourceFile : files) {
            if (!sourceFile.isFile()) {
                continue;
            }
            String fileName = sourceFile.getName();
            try {
                this.make(sourceFile, new File(targetFileDirectory, fileName), AbstractWaterMarkLocation.CENTER_TOP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int makeFromDirectory(String sourceFilePath, String targetFilePath) {
        File sourceFileDirectory = new File(sourceFilePath);
        File targetFileDirectory = new File(targetFilePath);
        Preconditions.checkArgument(sourceFileDirectory.exists());
        Preconditions.checkArgument(targetFileDirectory.exists());
        Preconditions.checkArgument(sourceFileDirectory.isDirectory());
        Preconditions.checkArgument(targetFileDirectory.isDirectory());
        return makeFromDirectory(sourceFileDirectory, targetFileDirectory);
    }

    public boolean make(String sourcePath, String targetPath) throws IOException {
        return make(new File(sourcePath), new File(targetPath), AbstractWaterMarkLocation.CENTER_TOP);
    }

    private final ImageIcon waterMarkImage;

    private TwoDimension waterMarkScale = new DimensionFactor(1, 1);

    private int rotateDegree = 0;


    private WaterMark(ImageIcon waterMarkImage) {
        this.waterMarkImage = waterMarkImage;
    }

    public ImageIcon getWaterMarkImage() {
        return waterMarkImage;
    }

    public static class Builder {
        private final String waterMarkPath;

        public Builder(String waterMarkPath) {
            this.waterMarkPath = waterMarkPath;
        }

        public WaterMark build() {
            ImageIcon imageIcon = new ImageIcon(waterMarkPath);
            Preconditions.checkArgument(imageIcon.getImage().getWidth(null) > 0);
            Preconditions.checkArgument(imageIcon.getImage().getHeight(null) > 0);
            return new WaterMark(imageIcon);
        }
    }


}
