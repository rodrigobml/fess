package org.codelibs.fess.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codelibs.fess.taglib.FessFunctions;

public final class DocumentUtil {

    private DocumentUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getValue(final Map<String, Object> doc, final String key, final Class<T> clazz) {
        if (doc == null || key == null) {
            return null;
        }

        final Object value = doc.get(key);
        if (value == null) {
            return null;
        }

        if (value instanceof List) {
            if (clazz.isAssignableFrom(List.class)) {
                return (T) value;
            }

            if (((List<?>) value).isEmpty()) {
                return null;
            }

            return convertObj(((List<?>) value).get(0), clazz);
        }

        return convertObj(value, clazz);
    }

    @SuppressWarnings("unchecked")
    private static <T> T convertObj(Object value, final Class<T> clazz) {
        if (value == null) {
            return null;
        }

        if (clazz.isAssignableFrom(String.class)) {
            return (T) value.toString();
        } else if (clazz.isAssignableFrom(Date.class)) {
            if (value instanceof Date) {
                return (T) value;
            } else {
                return (T) FessFunctions.parseDate(value.toString());
            }
        } else if (clazz.isAssignableFrom(Long.class)) {
            if (value instanceof Long) {
                return (T) value;
            } else {
                return (T) Long.valueOf(value.toString());
            }
        } else if (clazz.isAssignableFrom(Integer.class)) {
            if (value instanceof Integer) {
                return (T) value;
            } else {
                return (T) Integer.valueOf(value.toString());
            }
        } else if (clazz.isAssignableFrom(Double.class)) {
            if (value instanceof Double) {
                return (T) value;
            } else {
                return (T) Double.valueOf(value.toString());
            }
        } else if (clazz.isAssignableFrom(Float.class)) {
            if (value instanceof Float) {
                return (T) value;
            } else {
                return (T) Float.valueOf(value.toString());
            }
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            if (value instanceof Boolean) {
                return (T) value;
            } else {
                return (T) Boolean.valueOf(value.toString());
            }
        }
        return null;
    }
}