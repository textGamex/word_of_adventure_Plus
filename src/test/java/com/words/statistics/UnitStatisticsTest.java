package com.words.statistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitStatisticsTest
{
    @Test
    void testSetAndGet()
    {
        var object = new UnitStatistics();

        object.setTotalRound(1);
        object.setTotalAttack(2);
        object.setTotalKill(3);
        object.setTotalVictory(4);
        object.setTotalHarm(5);

        assertEquals(1, object.getTotalRound());
        assertEquals(2, object.getTotalAttack());
        assertEquals(3, object.getTotalKill());
        assertEquals(4, object.getTotalVictory());
        assertEquals(5, object.getTotalHarm());
    }

    @Test
    void testAddHarm()
    {
        var object = new UnitStatistics();

        object.addHarm(10);

        assertEquals(10, object.getTotalHarm());
    }

    @Test
    void testIncrement()
    {
        var object = new UnitStatistics();

        object.victoryIncrement();
        object.attackNumberIncrement();
        object.killIncrement();
        object.roundIncrement();

        assertEquals(1, object.getTotalVictory());
        assertEquals(1, object.getTotalAttack());
        assertEquals(1, object.getTotalKill());
        assertEquals(1, object.getTotalRound());
    }

    @Test
    void testEquals()
    {
        var object1 = new UnitStatistics();
        var object2 = new UnitStatistics();

        assertTrue(object1.equals(object2));
        assertTrue(object1.equals(object1));
    }

    @Test
    void testHashCode()
    {
        var object1 = new UnitStatistics();
        var object2 = new UnitStatistics();

        object1.setTotalHarm(1);
        object2.setTotalHarm(1);

        assertEquals(object1.hashCode(), object2.hashCode());
    }
}