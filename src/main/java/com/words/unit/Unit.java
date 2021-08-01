package com.words.unit;

import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;
import com.words.unit.component.UnitMessage;
import com.words.unit.component.buff.UnitBuff;

import java.util.Objects;

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
 * @see UnitBuff
 */
public class Unit
{
    public static void main(String[] args)
    {
        var object = new Unit.Builder().build();
        System.out.println("object = " + object);
    }
    /**基础信息组件*/
    private UnitMessage message;
    /**攻击组件*/
    private final UnitAttack attack;
    /**防御组件*/
    private final UnitDefense defense;
    /**buff组件*/
    private final UnitBuff buff = new UnitBuff();

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

    public UnitBuff buff()
    {
        return buff;
    }

    @Override
    public String toString()
    {
        return "Unit{" +
                "message=" + message +
                ", attack=" + attack +
                ", defense=" + defense +
                ", buff=" + buff +
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
        Unit unit = (Unit) o;
        return message.equals(unit.message) && attack.equals(unit.attack) && defense.equals(unit.defense)
                && buff.equals(unit.buff);
    }

    @Override
    public int hashCode()
    {
        int result = message.hashCode();
        result = 31 * result + attack.hashCode();
        result = 31 * result + defense.hashCode();
        result = 31 * result + buff.hashCode();
        return result;
    }
}
