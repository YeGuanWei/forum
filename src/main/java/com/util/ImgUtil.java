package com.util;

import com.alibaba.fastjson.JSONObject;
import com.model.dto.ImgDTO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片处理工具
 */
public class ImgUtil {

    // 文件服务器地址
    private String fileServiceUrl = "";

    private Map<String, Font> MAP_FONT = new HashMap();

    private Graphics2D g = null;
    // 添加字体的属性设置
    private Font font = loadFont("wryh", Font.PLAIN, 25);


    /**
     * 图片处理
     *
     * @param imgPath 原图片地址
     * @param dto     需要插入的内容
     * @return
     */
    public String modifyImage(String imgPath, ImgDTO dto) {
        BufferedImage bufferedImage = this.loadImageResource(imgPath);
        // 判断是文字还是图片
        if (StringUtil.isNotBlank(dto.getContent())) {
            // 文字
            addContent(bufferedImage, dto.getContent(), dto.getX(), dto.getY(), new Color(dto.getRgb_r(), dto.getRgb_g(), dto.getRgb_b()));
        } else if (StringUtil.isNotBlank(dto.getContent())) {
            // 图片
            addImg(bufferedImage, dto.getImgPath(), dto.getX(), dto.getY(), new Color(dto.getRgb_r(), dto.getRgb_g(), dto.getRgb_b()));
        } else {
            // 都没有,直接返回
        }
        // 生成图片地址
        String localFilePath = dto.getName() + System.currentTimeMillis() + ".jpg";
        // 生成图片到本地
        this.writeImageLocal(localFilePath, bufferedImage);
        // 上传到文件服务器
        String result = FileUtil.upload(fileServiceUrl, localFilePath);
        // 转换
        JSONObject json = JSONObject.parseObject(result);
        // 返回服务器图片地址
        return json.getString("newPath");
    }

    /**
     * 添加文字内容
     *
     * @param img
     * @param content
     * @param x
     * @param y
     * @param color
     * @return
     */
    private BufferedImage addContent(BufferedImage img, String content, int x, int y, Color color) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.BLUE);
            g.setColor(color);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            g.setStroke(new BasicStroke(3));
            if (this.font != null)
                g.setFont(this.font);
            if (content != null) {
                g.translate(w / 2, 0);
                g.drawString(content, x, y);
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     * 添加图片
     *
     * @param img
     * @param iconPath
     * @param x
     * @param y
     * @param color
     * @return
     */
    private BufferedImage addImg(BufferedImage img, String iconPath, int x, int y, Color color) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setColor(color);//设置字体颜色
            ImageIcon imgIcon = new ImageIcon(iconPath);
            Image con = imgIcon.getImage();
            g.translate(w / 2, h / 2);
            g.drawImage(con, x, y, null);
            g.dispose();
        } catch (Exception e) {

        }
        return img;
    }

    /**
     * 添加图片
     *
     * @param img
     * @param iconPath
     * @param x
     * @param y
     * @param color
     * @return
     */
    private BufferedImage addImg(BufferedImage img, URL iconPath, int x, int y, Color color) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setColor(color);//设置字体颜色
            ImageIcon imgIcon = new ImageIcon(iconPath);
            Image con = imgIcon.getImage();
            g.translate(w / 2, h / 2);
            g.drawImage(con, x, y, null);
            g.dispose();
        } catch (Exception e) {

        }
        return img;
    }

    /**
     * 导入网络图片到缓冲区
     */
    private BufferedImage loadImageResource(String imgName) {
        try {
            URL url = this.getClass().getResource(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File file = new File(newImage);
                ImageIO.write(img, "jpg", file);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 设置字体
     *
     * @param fontFileName
     * @param style
     * @param fontSize
     * @return
     */
    private Font loadFont(String fontFileName, Integer style, int fontSize) {
        InputStream inputStream = null;
        try {
            if (MAP_FONT.get(fontFileName + fontSize) != null) {
                return MAP_FONT.get(fontFileName + fontSize);
            }
            inputStream = (InputStream) this.getClass().getResourceAsStream("/ttc/" + fontFileName + ".ttc");
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            Font dynamicFontPt = dynamicFont.deriveFont(style, fontSize);
            MAP_FONT.put(fontFileName + fontSize, dynamicFontPt);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(dynamicFontPt);
            return dynamicFontPt;
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("宋体", Font.PLAIN, fontSize);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception E) {
                }
            }
        }
    }

}