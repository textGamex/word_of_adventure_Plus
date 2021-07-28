package com.words.unit;

import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;

import java.util.Arrays;

/**
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-27
 */
public class Unit
{
    private UnitAttack attack = new UnitAttack.Builder().build();
    private UnitDefense defense = new UnitDefense.Builder().build();
    public static void main(String[] args)
    {
    }
}
