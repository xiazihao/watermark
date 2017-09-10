package me.xiazihao;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterMarkTest {
    @Test
    public void make() throws Exception {
    }

    @Test
    public void makeFromDirectory() throws Exception {
        String waterMarkPath = "/Users/xiazihao/Pictures/watermark.png";
        String sourcePath="/Users/xiazihao/Pictures/加水印";
        String targetPath="/Users/xiazihao/Pictures/加水印/未命名文件夹";
        WaterMark.Builder builder = new WaterMark.Builder(waterMarkPath);
        WaterMark build = builder.build();
        build.makeFromDirectory(sourcePath,targetPath);
    }

    @Test
    public void getWaterMarkImage() throws Exception {
    }

}