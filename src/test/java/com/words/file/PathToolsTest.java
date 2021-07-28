package com.words.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.words.file.PathTools.*;

class PathToolsTest
{

    @Test
    void textGetRuntimeDirectory()
    {
        assertEquals("D:\\IDE\\Project\\Game\\word_of_adventure_Plus", getRuntimeDirectory());
    }
}