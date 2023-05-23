package others;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

public class ColorConvert {
    final static String strPathCMYKProfile = "C:/Windows/System32/spool/drivers/color/JapanColor2001Coated.icc";

    public static float[] rgb2cmyk(float... rgb) throws IOException
    {
        if (rgb.length != 3)
        {
            throw new IllegalArgumentException();
        }
        ICC_Profile icc=ICC_Profile.getInstance(strPathCMYKProfile);
        ColorSpace instance = new ICC_ColorSpace(icc);
        float[] cmyk = instance.fromRGB(rgb);
        return cmyk;
    }

    public static float[] cmyk2rgb(float... cmyk) throws IOException
    {
        if (cmyk.length != 4)
        {
            throw new IllegalArgumentException();
        }

        ColorSpace instance = new ICC_ColorSpace(ICC_Profile.getInstance(strPathCMYKProfile));
        float[] fromRGB = instance.toRGB(cmyk);
        return fromRGB;
    }

    public static void main(String[] args)
    {
        try
        {

            // 以 color 对象输入
            Color color = new Color(45, 45, 45);
            // float rgb1[] = { (float) 45 / 255, (float) 45 / 255, (float) 45 / 255 };
            float[] cmyk = rgb2cmyk(color.getRGBColorComponents(null));
            // [0.79394215, 0.7535668, 0.73749906, 0.50597394]
            // float[] cmyk = rgb2cmyk(rgb1);

            // 就结果而言，Color 对象输入得到的更精确一些。
            System.out.println(Arrays.toString(cmyk));
            System.out.println(Arrays.toString(cmyk2rgb(cmyk[0], cmyk[1], cmyk[2], cmyk[3])));

            // 以 array float 输入
            float rgb[] = { 45f / 255f, 45f / 255f, 45f / 255f };
            float[] cmyk2 = rgb2cmyk(rgb);

            System.out.println(Arrays.toString(cmyk2));
            System.out.println(Arrays.toString(cmyk2rgb(cmyk2[0], cmyk2[1], cmyk2[2], cmyk2[3])));

            // 四舍五入取整取 cmyk
            // BigDecimal dec = new BigDecimal(cmyk[0] * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
            // cmyk[0] = (int) dec.floatValue();
            //
            // dec = new BigDecimal(cmyk[1] * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
            // cmyk[1] = (int) dec.floatValue();
            //
            // dec = new BigDecimal(cmyk[2] * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
            // cmyk[2] = (int) dec.floatValue();
            //
            // dec = new BigDecimal(cmyk[3] * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
            // cmyk[3] = (int) dec.floatValue();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
