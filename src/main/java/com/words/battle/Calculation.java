package com.words.battle;

import com.words.unit.Unit;
import com.words.unit.component.buff.BuffType;

import static com.calculation.tools.CalculationTools.*;
import static java.util.Objects.requireNonNull;

/**
 * 游戏的计算组件.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-31
 */
public class Calculation
{
    private Calculation()
    {
        throw new AssertionError();
    }
    /**
     * 判断攻击者是否可以对被被攻击者造成暴击.
     *
     * @param attacker 攻击者
     * @param victim 被攻击者
     * @return 如果可以造成暴击, 返回{@code true}, 否则返回{@code false}
     */
    public static boolean canCrit(Unit attacker, Unit victim)
    {
        return Tools.randomBooleanValue(Value.attackerCritChance(requireNonNull(attacker).attack().getCrit(),
                requireNonNull(victim).defense().getCritResistance()));
    }

    public static boolean canHit(Unit attacker, Unit victim)
    {
        return Tools.randomBooleanValue(Value.attackHitRate(requireNonNull(attacker).attack().getHit(),
                requireNonNull(victim).defense().getMiss()));
    }

    /**
     * 根据单位的状态来判断本回合是否可以行动.
     *
     * @param unit 要进行判断的单位
     * @return 如果可以行动, 返回{@code true}, 否则返回{@code false}
     * @throws NullPointerException 如果{@code unit}为null
     */
    public static boolean canMove(final Unit unit)
    {
        requireNonNull(unit);
        return !unit.buff().have(BuffType.VERTIGO);
    }

    /**
     * 计算普通攻击伤害.
     *
     * @return 返回普通攻击伤害
     * @throws NullPointerException 如果{@code attacker}或{@code victim}为null
     */
    public static int normalAttackDamage(final Unit attacker, final Unit victim)
    {
        var attackPower = Value.attackerPhysicalDamage(requireNonNull(attacker).attack().getPhysicalAttack(),
                requireNonNull(victim).defense().getArmor());
        //返回经过随机的数值
        return Tools.floatingNumber(attackPower, 0.2);
    }
}
