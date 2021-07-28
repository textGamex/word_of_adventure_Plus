package com.words.unit.component;

/**
 * 单位的攻击组件.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-27
 */
public class UnitAttack
{
    /**物理攻击*/
    private int physicalAttack;
    /**法术伤害*/
    private int magicAttack;
    /**暴击 */
    private int crit;
    /**暴击效果*/
    private double critsEffect;
    /**命中*/
    private int hit;
    /**最大法力值*/
    private int maxMana;
    /**法力值*/
    private int mana;
    /**每回合法力值恢复*/
    private int manaRecovery;

    private UnitAttack(Builder builder)
    {
        physicalAttack = builder.physicalAttack;
        magicAttack = builder.magicAttack;
        crit = builder.crit;
        critsEffect = builder.critsEffect;
        hit = builder.hit;
        maxMana = builder.maxMana;
        mana = builder.mana;
        manaRecovery = builder.manaRecovery;
    }

    /**
     * @return 返回此单位的物理攻击
     */
    public int getPhysicalAttack()
    {
        return physicalAttack;
    }

    public void setPhysicalAttack(final int physicalAttack)
    {
        this.physicalAttack = physicalAttack;
    }

    /**
     * @return 返回此单位的魔法攻击
     */
    public int getMagicAttack()
    {
        return magicAttack;
    }

    public void setMagicAttack(final int magicAttack)
    {
        this.magicAttack = magicAttack;
    }

    /**
     * @return 返回此单位的暴击
     */
    public int getCrit()
    {
        return crit;
    }

    public void setCrit(final int crit)
    {
        this.crit = crit;
    }

    /**
     * @return 返回此单位的暴击效果
     */
    public double getCritsEffect()
    {
        return critsEffect;
    }

    public void setCritsEffect(final double critsEffect)
    {
        this.critsEffect = critsEffect;
    }

    /**
     * @return 返回此单位的命中
     */
    public int getHit()
    {
        return hit;
    }

    public void setHit(final int hit)
    {
        this.hit = hit;
    }

    /**
     * @return 返回此单位的最大法力值
     */
    public int getMaxMana()
    {
        return maxMana;
    }

    /**
     * @param maxMana 此单位的最大法力值
     */
    public void setMaxMana(int maxMana)
    {
        this.maxMana = maxMana;
    }

    /**
     * @return 返回此单位的法力值
     */
    public int getMana()
    {
        return mana;
    }

    public void setMana(final int mana)
    {
        this.mana = mana;
    }

    /**
     * @return 返回此单位的每回合法力值回复
     */
    public int getManaRecovery()
    {
        return manaRecovery;
    }

    public void setManaRecovery(final int manaRecovery)
    {
        this.manaRecovery = manaRecovery;
    }

    public static class Builder
    {
        /**物理攻击*/
        private int physicalAttack = 0;
        /**法术伤害*/
        private int magicAttack    = 0;
        /**暴击 */
        private int crit           = 0;
        /**暴击效果*/
        private double critsEffect = 0.0;
        /**命中*/
        private int hit            = 0;
        /**最大法力值*/
        private int maxMana        = 0;
        /**法力值*/
        private int mana           = 0;
        /**每回合法力值恢复*/
        private int manaRecovery   = 0;

        /**物理攻击*/
        public Builder physicalAttack(final int physicalAttack)
        {
            this.physicalAttack = physicalAttack;
            return this;
        }

        /**法术伤害*/
        public Builder magicAttack(final int magicAttack)
        {
            this.magicAttack = magicAttack;
            return this;
        }

        /**暴击*/
        public Builder crit(final int crit)
        {
            this.crit = crit;
            return this;
        }

        /**暴击效果*/
        public Builder critsEffect(final double critsEffect)
        {
            this.critsEffect = critsEffect;
            return this;
        }

        /**命中*/
        public Builder hit(final int hit)
        {
            this.hit = hit;
            return this;
        }

        /**最大法力值*/
        public Builder maxMana(final int maxMana)
        {
            this.maxMana = maxMana;
            return this;
        }

        /**法力值*/
        public Builder mana(final int mana)
        {
            this.mana = mana;
            return this;
        }

        /**每回合法力值恢复*/
        public Builder manaRecovery(final int manaRecovery)
        {
            this.manaRecovery = manaRecovery;
            return this;
        }

        /**构建*/
        public UnitAttack build()
        {
            return new UnitAttack(this);
        }
    }

    @Override
    public String toString()
    {
        return "UnitAttack{" +
                "physicalAttack=" + physicalAttack +
                ", magicAttack=" + magicAttack +
                ", crit=" + crit +
                ", critsEffect=" + critsEffect +
                ", hit=" + hit +
                ", maxMana=" + maxMana +
                ", mana=" + mana +
                ", manaRecovery=" + manaRecovery +
                '}';
    }
}
