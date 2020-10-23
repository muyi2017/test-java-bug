package com.company.project.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

public class DpDoInsideDoPrivileged {
    private Logger logger = LoggerFactory.getLogger(DpDoInsideDoPrivileged.class);

    public static void replaceNull(Object obj) {
        if (obj == null) {
            return;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                try {
                    if (field.get(obj) == null) {
                        setDefaultValue(obj, field, fieldType);
                    }
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }

            }
        }
    }

    private static void setDefaultValue(Object obj, Field field, Class<?> fieldType) throws IllegalAccessException {
        if (fieldType == String.class) {
            field.set(obj, "1");

        } else if (fieldType == Date.class) {
            field.set(obj, new Date());
        } else if (fieldType == Long.class) {
            field.setLong(obj, 0L);
        } else if (fieldType == Integer.class) {
            field.setInt(obj, 0);
        } else if (fieldType == BigDecimal.class) {
            field.set(obj, new BigDecimal("0.0"));
        }
    }
}
