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
}