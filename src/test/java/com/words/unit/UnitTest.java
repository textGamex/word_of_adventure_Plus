package com.words.unit;

import com.words.unit.component.UnitAttack;
import com.words.unit.component.UnitDefense;
import com.words.unit.component.UnitMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest
{
    @Test
    void testBuilder()
    {
        var object = new Unit.Builder().attack(new UnitAttack.Builder().build())
                .defense(new UnitDefense.Builder().build()).message(new UnitMessage.Builder().build()).build();

        assertNotEquals(null, object.attack());
        assertNotEquals(null, object.defense());
        assertNotEquals(null, object.message());
        assertNotEquals(null, object.buff());
    }

    @Test
    void testBuilderError()
    {
        assertThrows(NullPointerException.class, () -> new Unit.Builder().message(null).build());
        assertThrows(NullPointerException.class, () -> new Unit.Builder().attack(null).build());
        assertThrows(NullPointerException.class, () -> new Unit.Builder().defense(null).build());
    }
}