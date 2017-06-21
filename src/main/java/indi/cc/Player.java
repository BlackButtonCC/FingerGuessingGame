package indi.cc;

/**
 * 猜拳游戏的玩家
 * Author : CharlesChen
 * Time : 2017-06-08 20:57
 * Version : 1.0
 */
public class Player {
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    /**
     * 增加积分
     */
    public void addScore() {
        this.score+=10;
    }

    /**
     * 增加积分
     */
    public void subScore() {
        this.score-=10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
