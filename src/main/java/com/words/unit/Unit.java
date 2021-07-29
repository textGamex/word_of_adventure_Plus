package com.words.unit;

import com.calculation.tools.CalculationTools;
import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;

import static java.util.Objects.requireNonNull;

/**
 * 游戏的单位.
 *
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-27
 * @see UnitAttack
 * @see UnitDefense
 */
public class Unit
{
    public static void main(String[] args)
    {
    }
    private UnitAttack attack;
    private UnitDefense defense;

    public Unit()
    {
        attack = new UnitAttack.Builder().build();
        defense = new UnitDefense.Builder().build();
    }

    /**
     * @param attack 单位攻击组件
     * @throws NullPointerException 如果{@code attack}为null
     */
    public Unit(UnitAttack attack)
    {
        this.attack = requireNonNull(attack);
        defense = new UnitDefense.Builder().build();
    }

    /**
     * @param defense 单位防御组件
     * @throws NullPointerException 如果{@code defense}为null
     */
    public Unit(UnitDefense defense)
    {
        attack = new UnitAttack.Builder().build();
        this.defense = requireNonNull(defense);
    }

    /**
     * @param attack 单位攻击组件
     * @param defense 单位防御组件
     * @throws NullPointerException 如果{@code attack}或{@code defense}为null
     */
    public Unit(UnitAttack attack, UnitDefense defense)
    {
        this.attack = requireNonNull(attack);
        this.defense = requireNonNull(defense);
    }

    public UnitAttack attack()
    {
        return attack;
    }

    public UnitDefense defense()
    {
        return defense;
    }
}
