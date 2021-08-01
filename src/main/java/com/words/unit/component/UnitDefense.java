package com.words.unit.component;

import java.util.Objects;

/**
 * 单位的防御组件.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-28
 */
public class UnitDefense
{
    /**最大生命值*/
    private int maxHp;
    /**生命值*/
    private int hp;
    /**物理抗性*/
    private double physicalResistance;
    /**魔法抗性*/
    private double magicResistance;
    /**护甲*/
    private int armor;
    /**闪避*/
    private int miss;
    /**每回合生命回复*/
    private int lifeRegeneration;
    /**暴击抗性 */
    private int critResistance;

    private UnitDefense(Builder builder)
    {
        maxHp = builder.maxHp;
        hp = maxHp;
        physicalResistance = builder.physicalResistance;
        magicResistance = builder.magicResistance;
        armor = builder.armor;
        miss = builder.miss;
        lifeRegeneration = builder.lifeRegeneration;
        critResistance = builder.critResistance;
    }

    /**
     * @return 返回单位的最大生命值
     */
    public int getMaxHp()
    {
        return maxHp;
    }

    public void setMaxHp(final int maxHp)
    {
        this.maxHp = maxHp;
    }

    /**
     * @return 返回单位的生命值
     */
    public int getHp()
    {
        return hp;
    }

    public void setHp(final int hp)
    {
        this.hp = hp;
    }

    /**
     * @return 返回单位的
     */
    public double getPhysicalResistance()
    {
        return physicalResistance;
    }

    public void setPhysicalResistance(final double physicalResistance)
    {
        this.physicalResistance = physicalResistance;
    }

    /**
     * @return 返回单位的护甲值
     */
    public int getArmor()
    {
        return  armor;
    }

    public void setArmor(final int armor)
    {
        this.armor = armor;
    }

    /**
     * @return 返回单位的闪避
     */
    public int getMiss()
    {
        return miss;
    }


    public void setMiss(final int miss)
    {
        this.miss = miss;
    }

    /**
     * @return 返回单位的每回合生命回复
     */
    public int getLifeRegeneration()
    {
        return lifeRegeneration;
    }

    public void setLifeRegeneration(final int lifeRegeneration)
    {
        this.lifeRegeneration = lifeRegeneration;
    }

    /**
     * @return 返回单位的暴击抗性
     */
    public int getCritResistance()
    {
        return critResistance;
    }

    public void setCritResistance(final int critResistance)
    {
        this.critResistance = critResistance;
    }

    /**
     * @return 返回单位的魔法抗性
     */
    public double getMagicResistance()
    {
        return magicResistance;
    }

    public void setMagicResistance(final double magicResistance)
    {
        this.magicResistance = magicResistance;
    }

    public static class Builder
    {
        /**最大生命值*/
        private int maxHp                 = 100;
        /**物理抗性*/
        private double physicalResistance = 0;
        /**魔法抗性*/
        private double magicResistance    = 0;
        /**护甲*/
        private int armor                 = 0;
        /**闪避*/
        private int miss                  = 0;
        /**每回合生命回复*/
        private int lifeRegeneration      = 0;
        /**暴击抗性 */
        private int critResistance        = 0;

        /**最大生命值*/
        public Builder maxHp(int maxHp)
        {
            this.maxHp = maxHp;
            return this;
        }

        /**物理抗性*/
        public Builder physicalResistance(double physicalResistance)
        {
            this.physicalResistance = physicalResistance;
            return this;
        }

        /**魔法抗性*/
        public Builder magicResistance(double magicResistance)
        {
            this.magicResistance = magicResistance;
            return this;
        }

        /**护甲*/
        public Builder armor(int armor)
        {
            this.armor = armor;
            return this;
        }

        /**闪避*/
        public Builder miss(int miss)
        {
            this.miss = miss;
            return this;
        }

        /**每回合生命回复*/
        public Builder lifeRegeneration(int lifeRegeneration)
        {
            this.lifeRegeneration = lifeRegeneration;
            return this;
        }

        /**暴击抗性*/
        public Builder critResistance(int critResistance)
        {
            this.critResistance = critResistance;
            return this;
        }

        /**构建*/
        public UnitDefense build()
        {
            return new UnitDefense(this);
        }
    }

    @Override
    public String toString()
    {
        return "UnitDefense{" +
                "maxHp=" + maxHp +
                ", hp=" + hp +
                ", physicalResistance=" + physicalResistance +
                ", magicResistance=" + magicResistance +
                ", armor=" + armor +
                ", miss=" + miss +
                ", lifeRegeneration=" + lifeRegeneration +
                ", critResistance=" + critResistance +
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
        UnitDefense that = (UnitDefense) o;
        return maxHp == that.maxHp && hp == that.hp && Double.compare(that.physicalResistance, physicalResistance) == 0
                && Double.compare(that.magicResistance, magicResistance) == 0 && armor == that.armor && miss == that.miss
                && lifeRegeneration == that.lifeRegeneration && critResistance == that.critResistance;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = maxHp;
        result = 31 * result + hp;
        temp = Double.doubleToLongBits(physicalResistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(magicResistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + armor;
        result = 31 * result + miss;
        result = 31 * result + lifeRegeneration;
        result = 31 * result + critResistance;
        return result;
    }
}
