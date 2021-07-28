package com.words.unit.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitDefenseTest
{
    @Test
    void testBuilder()
    {
        var object = new UnitDefense.Builder().armor(0).critResistance(1).magicResistance(2).
        lifeRegeneration(3).maxHp(4).miss(5).physicalResistance(6).build();

        assertEquals(0, object.getArmor());
        assertEquals(1, object.getCritResistance());
        assertEquals(2, object.getMagicResistance());
        assertEquals(3, object.getLifeRegeneration());
        assertEquals(4, object.getMaxHp());
        assertEquals(4, object.getHp());
        assertEquals(5, object.getMiss());
        assertEquals(6, object.getPhysicalResistance());
    }

    @Test
    void testSetFunction()
    {
        var object = new UnitDefense.Builder().armor(0).critResistance(1).magicResistance(2).
                lifeRegeneration(3).maxHp(4).miss(5).physicalResistance(6).build();

        object.setArmor(1);
        object.setCritResistance(2);
        object.setHp(3);
        object.setMaxHp(4);
        object.setLifeRegeneration(5);
        object.setPhysicalResistance(6);
        object.setMiss(7);
        object.setMagicResistance(8);

        assertEquals(1, object.getArmor());
        assertEquals(2, object.getCritResistance());
        assertEquals(3, object.getHp());
        assertEquals(4, object.getMaxHp());
        assertEquals(5, object.getLifeRegeneration());
        assertEquals(6, object.getPhysicalResistance());
        assertEquals(7, object.getMiss());
        assertEquals(8, object.getMagicResistance());
    }
}