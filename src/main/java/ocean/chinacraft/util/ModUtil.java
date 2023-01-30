package ocean.chinacraft.util;

import java.util.Random;

public class ModUtil {
    /**
     * 生成1-100的随机数
     *
     * @return 结果
     */
    public static Integer random() {
        return (int) (Math.random() * (100 - 1) + 1);
    }

    public static float randomFloat(float max) {
        Random random = new Random();
        return random.nextFloat(max);
    }

    /**
     * 生成指定随机数
     *
     * @return 结果
     */
    public static Integer random(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
