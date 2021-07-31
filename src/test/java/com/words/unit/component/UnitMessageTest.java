package com.words.unit.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitMessageTest
{
    @Test
    void testBuilder()
    {
        var object = new UnitMessage.Builder().camp(UnitMessage.Camp.PLAYER).cash(1).level(2).name("0")
                .speed(3).upgradeNeedXp(4).value(5).xp(6).upgradeNeedXpIncrease(0.05).build();

        assertEquals(UnitMessage.Camp.PLAYER, object.getCamp());
        assertEquals(1, object.getCash());
        assertEquals(2, object.getLevel());
        assertEquals("0", object.getName());
        assertEquals(3, object.getSpeed());
        assertEquals(4, object.getUpgradeNeedXp());
        assertEquals(5, object.getValue());
        assertEquals(6, object.getXp());
        assertEquals(0.05, object.getUpgradeNeedXpIncrease());
    }

    @Test
    void testSet()
    {
        var object = new UnitMessage.Builder().camp(UnitMessage.Camp.PLAYER).cash(0).level(0).name("0")
                .speed(0).upgradeNeedXp(0).value(0).xp(0).upgradeNeedXpIncrease(0.0).build();

        object.setCamp(UnitMessage.Camp.ENEMY);
        object.setUpgradeNeedXpIncrease(1.0);
        object.setCash(2);
        object.setLevel(3);
        object.setUpgradeNeedXp(4);
        object.setSpeed(5);
        object.setValue(6);
        object.setXp(7);
        object.setName("8");

        assertEquals(UnitMessage.Camp.ENEMY, object.getCamp());
        assertEquals(1.0, object.getUpgradeNeedXpIncrease());
        assertEquals(2, object.getCash());
        assertEquals(3, object.getLevel());
        assertEquals(4, object.getUpgradeNeedXp());
        assertEquals(5, object.getSpeed());
        assertEquals(6, object.getValue());
        assertEquals(7, object.getXp());
        assertEquals("8", object.getName());
    }

    @Test
    void testAddXp()
    {
        var object = new UnitMessage.Builder().camp(UnitMessage.Camp.PLAYER).cash(0).level(0).name("0")
                .speed(0).upgradeNeedXp(50).value(0).xp(0).upgradeNeedXpIncrease(0.07).build();

        object.addXp(50);

        assertEquals(50, object.getXp());
        assertEquals(1, object.getLevel());
    }

    @Test
    void testAddXpError()
    {
        var object = new UnitMessage.Builder().camp(UnitMessage.Camp.PLAYER).cash(0).level(0).name("0")
                .speed(0).upgradeNeedXp(1).value(0).xp(0).upgradeNeedXpIncrease(0.07).build();

        assertThrows(IllegalCallerException.class, () -> object.addXp(1000));
    }
}