package com.words.unit;

import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;
import com.words.unit.component.buff.BuffModule;

import static java.util.Objects.requireNonNull;

/**
 * 游戏的单位.
 *
 * @author 留恋千年
 * @version 1.1.0
 * @since 2021-7-27
 * @see UnitAttack
 * @see UnitDefense
 */
public class Unit
{
    /**攻击组件*/
    private final UnitAttack attack;
    /**防御组件*/
    private final UnitDefense defense;
    /**buff组件*/
    private final BuffModule buff = new BuffModule();

    private Unit(Builder builder)
    {
        attack = builder.attack;
        defense = builder.defense;
    }

    public static class Builder
    {
        private UnitAttack attack = new UnitAttack.Builder().build();
        private UnitDefense defense = new UnitDefense.Builder().build();

        public Builder attack(UnitAttack attack)
        {
            this.attack = requireNonNull(attack);
            return this;
        }

        public Builder defense(UnitDefense defense)
        {
            this.defense = requireNonNull(defense);
            return this;
        }

        public Unit build()
        {
            return new Unit(this);
        }
    }

    public UnitAttack attack()
    {
        return attack;
    }

    public UnitDefense defense()
    {
        return defense;
    }

    public BuffModule buff()
    {
        return buff;
    }
}
