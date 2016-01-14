package org.embulk.output.jdbc.setter;

import java.io.IOException;
import java.sql.SQLException;
import org.embulk.spi.Column;
import org.embulk.spi.ColumnVisitor;
import org.embulk.spi.PageReader;

public class ColumnSetterVisitor
        implements ColumnVisitor
{
    private final PageReader pageReader;
    private final ColumnSetter setter;

    public ColumnSetterVisitor(PageReader pageReader, ColumnSetter setter)
    {
        this.pageReader = pageReader;
        this.setter = setter;
    }

    @Override
    public void booleanColumn(Column column)
    {
        try {
            if (pageReader.isNull(column)) {
                setter.nullValue();
            } else {
                setter.booleanValue(pageReader.getBoolean(column));
            }
        } catch (IOException | SQLException ex) {
            // TODO exception class
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void longColumn(Column column)
    {
        try {
            if (pageReader.isNull(column)) {
                setter.nullValue();
            } else {
                setter.longValue(pageReader.getLong(column));
            }
        } catch (IOException | SQLException ex) {
            // TODO exception class
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void doubleColumn(Column column)
    {
        try {
            if (pageReader.isNull(column)) {
                setter.nullValue();
            } else {
                setter.doubleValue(pageReader.getDouble(column));
            }
        } catch (IOException | SQLException ex) {
            // TODO exception class
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void stringColumn(Column column)
    {
        try {
            if (pageReader.isNull(column)) {
                setter.nullValue();
            } else {
                setter.stringValue(pageReader.getString(column));
            }
        } catch (IOException | SQLException ex) {
            // TODO exception class
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void jsonColumn(Column column) {
        throw new UnsupportedOperationException("This plugin doesn't support json type. Please try to upgrade version of the plugin using 'embulk gem update' command. If the latest version still doesn't support json type, please contact plugin developers, or change configuration of input plugin not to use json type.");
    }

    @Override
    public void timestampColumn(Column column)
    {
        try {
            if (pageReader.isNull(column)) {
                setter.nullValue();
            } else {
                setter.timestampValue(pageReader.getTimestamp(column));
            }
        } catch (IOException | SQLException ex) {
            // TODO exception class
            throw new RuntimeException(ex);
        }
    }
}
