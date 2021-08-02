package com.words.statistics;

import java.util.Arrays;

/**
 * 游戏的统计组件.
 *
 * @author 留恋千年
 * @version 1.0.1
 * @since 2021-8-1
 */
public class UnitStatistics
{
    /**总击杀*/
    private long totalKill;
    /**总回合数*/
    private long totalRound;
    /**攻击总次数*/
    private long totalAttack;
    /**总伤害*/
    private long totalHarm;
    /**胜利场数*/
    private long totalVictory;

    public long getTotalKill()
    {
        return totalKill;
    }

    public void setTotalKill(long totalKill)
    {
        this.totalKill = totalKill;
    }

    public long getTotalRound()
    {
        return totalRound;
    }

    public void setTotalRound(long totalRound)
    {
        this.totalRound = totalRound;
    }

    public long getTotalAttack()
    {
        return totalAttack;
    }

    public void setTotalAttack(long totalAttack)
    {
        this.totalAttack = totalAttack;
    }

    public long getTotalHarm()
    {
        return totalHarm;
    }

    public void setTotalHarm(long totalHarm)
    {
        this.totalHarm = totalHarm;
    }

    public long getTotalVictory()
    {
        return totalVictory;
    }

    public void setTotalVictory(long totalVictory)
    {
        this.totalVictory = totalVictory;
    }

    public void roundIncrement()
    {
        totalRound++;
    }

    public void killIncrement()
    {
        totalKill++;
    }

    public void attackNumberIncrement()
    {
        totalAttack++;
    }

    public void addHarm(long harm)
    {
        totalHarm += harm;
    }

    public void victoryIncrement()
    {
        totalVictory++;
    }

    @Override
    public String toString()
    {
        return "UnitStatistics{" +
                "totalKill=" + totalKill +
                ", totalRound=" + totalRound +
                ", totalAttack=" + totalAttack +
                ", totalHarm=" + totalHarm +
                ", totalVictory=" + totalVictory +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UnitStatistics that = (UnitStatistics) o;
        return totalKill == that.totalKill && totalRound == that.totalRound && totalAttack == that.totalAttack
                && totalHarm == that.totalHarm && totalVictory == that.totalVictory;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (totalKill ^ (totalKill >>> 32));
        result = 31 * result + (int) (totalRound ^ (totalRound >>> 32));
        result = 31 * result + (int) (totalAttack ^ (totalAttack >>> 32));
        result = 31 * result + (int) (totalHarm ^ (totalHarm >>> 32));
        result = 31 * result + (int) (totalVictory ^ (totalVictory >>> 32));
        return result;
    }
}
