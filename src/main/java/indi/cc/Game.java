package indi.cc;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

/**
 * 猜拳游戏的规则
 * Author : CharlesChen
 * Time : 2017-06-08 20:58
 * Version : 1.0
 */
public class Game {
    private Player player1;

    private String[] array = new String[]{"剪刀", "石头", "布"};
    /**
     * 游戏主要判断规则
     * @param s1
     * @param s2
     * @return
     */
    public int rule(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        if (s1.equals("剪刀")) {
            if (s2.equals("石头")) {
                return -1;
            }
            if (s2.equals("布")) {
                return 1;
            }
        }
        if (s1.equals("石头")) {
            if (s2.equals("布")) {
                return -1;
            }
            if (s2.equals("剪刀")) {
                return 1;
            }
        }
        if (s1.equals("布")) {
            if (s2.equals("剪刀")) {
                return -1;
            }
            if (s2.equals("石头")) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * 游戏的入口
     */
    public void start(String playerName) {
        this.player1 = new Player(playerName);
        System.out.println("玩家 " + player1.getName() + " 进入游戏，初始积分为：" + player1.getScore());
        while (true) {
            int index_s2 = (int)(Math.random()*3);
            String s2 = this.array[index_s2];
            System.out.println("请输入\"剪刀\"、\"石头\"、\"布\"其中之一，退出请输入\"0\"。");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.next();
            if (checkParams(s1, s2)) {
                System.out.println("电脑出：" + s2 + "。");
                int result = rule(s1, s2);
                getFinalResult(result);
            } else {
                System.out.println("错误输入，请重新输入");
                System.out.println();
                continue;
            }
        }
    }

    /**
     * 检查参数
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkParams(String s1, String s2) {
        if (s1.equals("0")) {
            System.out.println("已退出游戏，玩家 " + player1.getName() + " 的积分为：" + player1.getScore());
            System.exit(0);
        }
        if (ArrayUtils.contains(this.array, s1)) {
            return true;
        }
        return false;
    }

    /**
     * 根据规则返回的数字判断胜利、平局、失败
     * @param result
     */
    public void getFinalResult(int result) {
        if (result == 0) {
            System.out.println("平局！！！积分不改变，目前积分为：" + player1.getScore());
            System.out.println();
        } else if(result == 1) {
            player1.addScore();
            System.out.println("胜利！！！获得积分，目前积分为：" + player1.getScore());
            System.out.println();
        } else if (result == -1) {
            player1.subScore();
            System.out.println("输了！！！扣去积分，目前积分为：" + player1.getScore());
            System.out.println();
        }
    }

}
