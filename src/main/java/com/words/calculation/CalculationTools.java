package com.words.calculation;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 用来辅助游戏数值计算的类.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-28
 */
public class CalculationTools
{
    private CalculationTools()
    {
        throw new AssertionError();
    }

    /**
     * 根据给定的数值计算攻击者的攻击命中的几率.
     *
     * @param attackerHit 攻击者的命中
     * @param victimEvade 被攻击者的闪避
     * @return 攻击者的攻击命中的几率
     * @since 2021-5-15
     */
    public static double attackHitRate(final int attackerHit, final int victimEvade)
    {
        if (attackerHit <= 0)
        {
            return 1.0;
        }
        if (victimEvade <= 0)
        {
            return 0.0;
        }
        return (double) attackerHit / (attackerHit + victimEvade);
    }

    /**
     * 计算攻击者的攻击暴击的概率.
     *
     * @param attackerCrit 攻击者的暴击
     * @param victimResistance 被攻击者的暴击抗性
     * @return 攻击者的攻击暴击的概率
     * @since 2021-5-16
     */
    public static double attackerCritChance(final int attackerCrit, final int victimResistance)
    {
        if (attackerCrit <= 0)
        {
            return 0.0;
        }
        if (victimResistance <= 0)
        {
            return 1.0;
        }
        return (double) attackerCrit / (attackerCrit + victimResistance);
    }

    /**
     * 用给定的数值计算攻击者能对被攻击者打出的伤害.
     *
     * @param attackerPhysicalAttack 攻击者的物理攻击
     * @param victimArmor 被攻击者的护甲值
     * @throws NullPointerException 如果{@code attacker}或{@code victim}为null
     * @return 攻击者的伤害
     */
    public static double attackerPhysicalDamage(double attackerPhysicalAttack, double victimArmor)
    {
        var attack = attackerPhysicalAttack;
        var armor = victimArmor;

        //为了防止出现NaN错误
        if (attackerPhysicalAttack + victimArmor == 0)
        {
            if (victimArmor <= 0)
            {
                attack = ++attackerPhysicalAttack;
            }
            if (attackerPhysicalAttack <= 0)
            {
                armor = ++victimArmor;
            }
        }
        return attack * attack / (attack + armor);
    }

    /**
     * 计算被攻击者有效HP.
     *
     * @param victimHp 被攻击者的HP
     * @param damageReduction 伤害减免率
     * @param evadeChance 闪避概率
     * @return 返回被攻击者有效HP
     */
    public static double victimEffectiveHp(final int victimHp, final double damageReduction, final double evadeChance)
    {
        if (evadeChance >= 1.0 || damageReduction >= 1.0)
        {
            return Integer.MAX_VALUE;
        }
        return victimHp / (1.0 - damageReduction) / (1.0 - evadeChance);
    }

    /**
     *  计算攻击者对被攻击者的暴击伤害.
     *
     * @param hurt 攻击者对被攻击者可以造成的的伤害
     * @param critsEffect 攻击者的暴击效果
     * @return 攻击者对被攻击者的暴击伤害
     * @throws NullPointerException 如果{@code attacker}或{@code victim}为null
     */
    public static int criticalDamage(final double hurt, final double critsEffect)
    {
        return Math.round((float) (hurt * critsEffect));
    }

    /**
     * 根据给定的概率返回{@code true}.
     *
     * @param trueProbability 返回{@code true}的概率
     * @return 根据给定概率返回 {@code true}
     */
    public static boolean randomBooleanValue(double trueProbability)
    {
        if (trueProbability >= 1.0)
        {
            return true;
        }
        if (trueProbability <= 0.0)
        {
            return false;
        }
        return ThreadLocalRandom.current().nextDouble() < trueProbability;
    }
}
