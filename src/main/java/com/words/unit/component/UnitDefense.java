package com.words.unit.component;

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
     * @return 返回单位的闪避
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
        private int maxHp;
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

        public Builder maxHp(int maxHp)
        {
            this.maxHp = maxHp;
            return this;
        }

        public Builder physicalResistance(double physicalResistance)
        {
            this.physicalResistance = physicalResistance;
            return this;
        }

        public Builder magicResistance(double magicResistance)
        {
            this.magicResistance = magicResistance;
            return this;
        }

        public Builder armor(int armor)
        {
            this.armor = armor;
            return this;
        }

        public Builder miss(int miss)
        {
            this.miss = miss;
            return this;
        }

        public Builder lifeRegeneration(int lifeRegeneration)
        {
            this.lifeRegeneration = lifeRegeneration;
            return this;
        }

        public Builder critResistance(int critResistance)
        {
            this.critResistance = critResistance;
            return this;
        }

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
}
