package com.words.unit.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitAttackTest
{
    @Test
    void testBuilder()
    {
        var object =  new UnitAttack.Builder().magicAttack(0).mana(1).maxMana(2).crit(3).hit(4).critsEffect(5)
                .manaRecovery(6).physicalAttack(7).build();

        assertEquals(0, object.getMagicAttack());
        assertEquals(1, object.getMana());
        assertEquals(2, object.getMaxMana());
        assertEquals(3, object.getCrit());
        assertEquals(4, object.getHit());
        assertEquals(5, object.getCritsEffect());
        assertEquals(6, object.getManaRecovery());
        assertEquals(7, object.getPhysicalAttack());
    }

    @Test
    void testSetFunction()
    {
        var object =  new UnitAttack.Builder().magicAttack(0).mana(1).maxMana(2).crit(3).hit(4).critsEffect(5)
                .manaRecovery(6).physicalAttack(7).build();

        object.setCrit(0);
        object.setMagicAttack(1);
        object.setHit(2);
        object.setMana(3);
        object.setMaxMana(4);
        object.setPhysicalAttack(5);
        object.setCritsEffect(6.0);
        object.setManaRecovery(7);

        assertEquals(0, object.getCrit());
        assertEquals(1, object.getMagicAttack());
        assertEquals(2, object.getHit());
        assertEquals(3, object.getMana());
        assertEquals(4, object.getMaxMana());
        assertEquals(5, object.getPhysicalAttack());
        assertEquals(6, object.getCritsEffect());
        assertEquals(7, object.getManaRecovery());
    }

    @Test
    void testToString()
    {
        var object =  new UnitAttack.Builder().magicAttack(0).mana(1).maxMana(2).crit(3).hit(4).critsEffect(5)
                .manaRecovery(6).physicalAttack(7).build();

        var result = "UnitAttack{physicalAttack=7, magicAttack=0, crit=3, critsEffect=5.0, hit=4, maxMana=2, mana=1" +
                ", manaRecovery=6}";

        assertEquals(result, object.toString());
    }
}