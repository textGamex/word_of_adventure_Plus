package com.words.unit;

import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;
import com.words.unit.component.UnitMessage;
import com.words.unit.component.buff.BuffModule;

import static java.util.Objects.requireNonNull;

/**
 * 游戏的单位.
 *
 * @author 留恋千年
 * @version 1.2.0
 * @since 2021-7-27
 * @see UnitAttack
 * @see UnitDefense
 * @see UnitMessage
 * @see BuffModule
 */
public class Unit
{
    /**基础信息组件*/
    private UnitMessage message;
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
        message = builder.message;
    }

    /**
     * @author 留恋千年
     * @version 1.0.0
     * @since 2021-7-29
     */
    public static class Builder
    {
        private UnitAttack attack = new UnitAttack.Builder().build();
        private UnitDefense defense = new UnitDefense.Builder().build();
        private UnitMessage message = new UnitMessage.Builder().build();

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

        public Builder message(UnitMessage message)
        {
            this.message = requireNonNull(message);
            return this;
        }

        public Unit build()
        {
            return new Unit(this);
        }
    }

    public UnitMessage message()
    {
        return message;
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
