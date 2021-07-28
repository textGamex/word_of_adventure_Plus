package com.words.file;

import java.io.File;
import java.io.IOException;

/**
 * @author 留恋千年
 * @version 1.0.0
 * @since 2021-7-28
 */
public class PathTools
{
    private PathTools()
    {}

    /**
     * @return 程序运行时目录
     */
    public static String getRuntimeDirectory()
    {
        final var directory = new File("");
        try
        {
            return directory.getCanonicalPath();
        }
        catch (IOException e)
        {
            return directory.getAbsolutePath();
        }
    }
}
