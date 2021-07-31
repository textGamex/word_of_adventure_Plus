package com.words.unit.component.buff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitBuffTest
{
    private static UnitBuff buffs;

    @BeforeEach
    void setUp()
    {
        buffs = new UnitBuff();
    }

    @Test
    void testAdd()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.add(BuffType.BLEED, new BuffEffect(10,1,true));
        buffs.add(BuffType.DEBILITY, new BuffEffect(10,1,true));

        assertThrows(NullPointerException.class, () -> buffs.add(BuffType.BLEED, null));
        assertThrows(NullPointerException.class, () -> buffs.add(null, new BuffEffect(1, 1)));
        assertThrows(NullPointerException.class, () -> buffs.add(null, null));
        assertTrue(buffs.have(BuffType.POISON));
        assertTrue(buffs.have(BuffType.BLEED));
        assertTrue(buffs.have(BuffType.DEBILITY));
    }

    @Test
    void testAddHaveBuffAndIsTimeLess()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));

        buffs.add(BuffType.POISON, new BuffEffect(2,2,true, true));
        var effect = buffs.getMessage(BuffType.POISON);

        assertEquals(2, effect.getLayers());
        assertEquals(2, effect.getTimeLimit());
    }

    @Test
    void testAddHaveBuffIsNotTimeLess()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));

        buffs.add(BuffType.POISON, new BuffEffect(2,2,true, false));
        var effect = buffs.getMessage(BuffType.POISON);

        assertEquals(2, effect.getLayers());
        assertEquals(11, effect.getTimeLimit());
    }

    @Test
    void testGetMessageNullPointer()
    {
        assertThrows(NullPointerException.class, () -> buffs.getMessage(BuffType.POISON));
    }

    @Test
    void isEmpty()
    {
        assertTrue(buffs.isEmpty());
    }

    @Test
    void size()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.add(BuffType.BLEED, new BuffEffect(10,1,true));
        buffs.add(BuffType.DEBILITY, new BuffEffect(10,1,true));

        assertEquals(3, buffs.size());
    }

    @Test
    void remove()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.remove(BuffType.POISON);

        assertThrows(NullPointerException.class, () -> buffs.remove(BuffType.DEBILITY));
        assertThrows(NullPointerException.class, () -> buffs.remove(BuffType.DEBILITY, 1));
        assertThrows(NullPointerException.class, () -> buffs.remove(null));
        assertThrows(NullPointerException.class, () -> buffs.remove(null, 1));
        assertFalse(buffs.have(BuffType.POISON));
    }

    @Test
    void testRemove()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.add(BuffType.BLEED, new BuffEffect(10,1,true));
        buffs.remove(BuffType.POISON, 3);
        buffs.remove(BuffType.BLEED, 11);

        assertFalse(buffs.have(BuffType.BLEED));//因为移除的回合大于持续回合,所以buff被删除
        assertEquals(7, buffs.getMessage(BuffType.POISON).getTimeLimit());
    }

    @Test
    void clear()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.add(BuffType.BLEED, new BuffEffect(10,1,true));
        buffs.clear();

        assertTrue(buffs.isEmpty());
    }

    @Test
    void clearDebuff()
    {
        buffs.add(BuffType.POISON, new BuffEffect(10,1,true));
        buffs.add(BuffType.BLEED, new BuffEffect(10,1,true));
        buffs.add(BuffType.DEBILITY, new BuffEffect(10,1,false));
        buffs.clearDebuff();

        assertFalse(buffs.have(BuffType.POISON));
        assertFalse(buffs.have(BuffType.BLEED));
        assertTrue(buffs.have(BuffType.DEBILITY));
    }

    @Test
    void clearDebuffNullPointer()
    {
        assertThrows(NullPointerException.class, () -> buffs.add(null,
                new BuffEffect(10,1,true)));
        assertThrows(NullPointerException.class, () -> buffs.add(BuffType.POISON, null));
        assertThrows(NullPointerException.class, () -> buffs.add(null, null));
    }

    @Test
    void testRemoveIllegalArgument()
    {
        assertThrows(IllegalArgumentException.class, () -> buffs.remove(BuffType.POISON, -1));
    }

    @Test
    void testEqual()
    {
        final var copy = new UnitBuff();

        assertEquals(buffs, buffs);
        assertEquals(buffs, copy);
        assertNotEquals(null, buffs);
    }
}