package com.words.unit.component;

import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

/**
 * 单位的基础信息组件.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-29
 */
public class UnitMessage
{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnitMessage.class);
    /**
     * 单位所属阵营.
     *
     * @author 留恋千年
     * @version 1.0.0
     * @since 2021-7-29
     */
    public enum Camp
    {
        /**玩家*/
        PLAYER,
        /**敌人*/
        ENEMY
    }
    /**名称*/
    private String name;
    /**身份*/
    private Camp camp;
    /**等级*/
    private int level;
    /**速度*/
    private int speed;
    /**分数*/
    private int value;
    /**货币*/
    private int cash;
    /**经验*/
    private int xp;
    /**升到下一级所需经验*/
    private int upgradeNeedXp;
    /**升到下一级所需经验增长*/
    private double upgradeNeedXpIncrease;

    private UnitMessage(Builder builder)
    {
        name = builder.name;
        camp = builder.camp;
        level = builder.level;
        speed = builder.speed;
        value = builder.value;
        cash = builder.cash;
        xp = builder.xp;
        upgradeNeedXp = builder.upgradeNeedXp;
        upgradeNeedXpIncrease = builder.upgradeNeedXpIncrease;
    }

    /**
     * @author 留恋千年
     * @version 1.0.0
     * @since 2021-7-29
     */
    public static class Builder
    {
        /**名称*/
        private String name                  = "NONE";
        /**身份*/
        private Camp camp                    = Camp.ENEMY;
        /**等级*/
        private int level                    = 0;
        /**速度*/
        private int speed                    = 0;
        /**分数*/
        private int value                    = 0;
        /**货币*/
        private int cash                     = 0;
        /**经验*/
        private int xp                       = 0;
        /**升到下一级所需经验*/
        private int upgradeNeedXp            = 0;
        /**升到下一级所需经验增长*/
        private double upgradeNeedXpIncrease = 0.05;

        /**
         * @param name 单位名称
         * @return {@code this}
         * @throws NullPointerException 如果{@code name}为null
         */
        public Builder name(String name)
        {
            this.name = requireNonNull(name);
            return this;
        }

        /**
         * @param camp 单位所属阵营
         * @return {@code this}
         * @throws NullPointerException 如果{@code camp}为null
         */
        public Builder camp(Camp camp)
        {
            this.camp = requireNonNull(camp);
            return this;
        }

        public Builder level(int level)
        {
            this.level = level;
            return this;
        }

        public Builder speed(int speed)
        {
            this.speed = speed;
            return this;
        }

        public Builder value(int value)
        {
            this.value = value;
            return this;
        }

        public Builder cash(int cash)
        {
            this.cash = cash;
            return this;
        }

        public Builder xp(int xp)
        {
            this.xp = xp;
            return this;
        }

        public Builder upgradeNeedXp(int upgradeNeedXp)
        {
            this.upgradeNeedXp = upgradeNeedXp;
            return this;
        }

        public Builder upgradeNeedXpIncrease(double upgradeNeedXpIncrease)
        {
            this.upgradeNeedXpIncrease = upgradeNeedXpIncrease;
            return this;
        }

        public UnitMessage build()
        {
            return new UnitMessage(this);
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Camp getCamp()
    {
        return camp;
    }

    public void setCamp(Camp camp)
    {
        this.camp = camp;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getCash()
    {
        return cash;
    }

    public void setCash(int cash)
    {
        this.cash = cash;
    }

    public int getXp()
    {
        return xp;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

    public int getUpgradeNeedXp()
    {
        return upgradeNeedXp;
    }

    public void setUpgradeNeedXp(int upgradeNeedXp)
    {
        this.upgradeNeedXp = upgradeNeedXp;
    }

    public double getUpgradeNeedXpIncrease()
    {
        return upgradeNeedXpIncrease;
    }

    public void setUpgradeNeedXpIncrease(double upgradeNeedXpIncrease)
    {
        this.upgradeNeedXpIncrease = upgradeNeedXpIncrease;
    }

    public int addXp(int xp)
    {

        var count = 0;
        this.xp += xp;
        while (this.xp >= upgradeNeedXp)
        {
            count++;
            level++;
            upgradeNeedXp += upgradeNeedXp * upgradeNeedXpIncrease;
            LOGGER.trace("第{}次迭代, 现在等级为{}, 升级下一级所需为{}", count, level, upgradeNeedXp);
        }
        return count;
    }
}
