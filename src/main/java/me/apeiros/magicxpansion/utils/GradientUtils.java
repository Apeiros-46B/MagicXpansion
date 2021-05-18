package me.apeiros.magicxpansion.utils;

import net.md_5.bungee.api.ChatColor;
import java.awt.Color;

public class GradientUtils {

    public static String makeStringGradient(String str, Color begin, Color end) {

        StringBuilder sb = new StringBuilder();
        String[] charList = str.split("");
        ChatColor[] colorArray = createSteppedGradient(str.length(), begin, end);

        for (int i = 0; i < str.length(); i++) { sb.append(colorArray[i]); sb.append(charList[i]); }

        return sb.toString();
    }

    private static ChatColor[] createSteppedGradient(int n, Color begin, Color end) {
        ChatColor[] colors = new ChatColor[n];

        int redDiff = Math.abs(begin.getRed() - end.getRed()) / (n - 1);
        int greenDiff = Math.abs(begin.getGreen() - end.getGreen()) / (n - 1);
        int blueDiff = Math.abs(begin.getBlue() - end.getBlue()) / (n - 1);

        int[] dir = new int[]{begin.getRed() < end.getRed() ? +1 : -1, begin.getGreen() < end.getGreen() ? +1 : -1, begin.getBlue() < end.getBlue() ? +1 : -1 };

        for (int i = 0; i < n; i++) { Color color = new Color(begin.getRed() + ((redDiff * i) * dir[0]), begin.getGreen() + ((greenDiff * i) * dir[1]), begin.getBlue() + ((blueDiff * i) * dir[2])); colors[i] = ChatColor.of(color); }

        return colors;
    }

}
