package io.github.bhuwanupadhyay.inventory.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public enum Asserts {

    INSTANCE;

    public static final String EMPTY_STRING = "";
    public static final String UNEXPECTED_NULL = "Unexpected Null Parameter";
    public static final String UNEXPECTED_EMPTY_STRING = "Unexpected Null Parameter";
    public static final String NOT_TRUE = "Should have been TRUE but wasn't";
    public static final String NOT_FALSE = "Should have been FALSE but wasn't";
    public static final String USED_WRONG_METHOD = "I think you used the wrong Asserts method!";
    private static final Logger LOG = LoggerFactory.getLogger(Asserts.class);
    private static boolean active = false;

    public void isTrue(boolean trueism) {
        if (active && !trueism) {
            LOG.warn(NOT_TRUE);
            throw new AssertionError(NOT_TRUE);
        }
    }

    public void isFalse(boolean falsehood) {
        if (active && falsehood) {
            LOG.warn(NOT_FALSE);
            throw new AssertionError(NOT_FALSE);
        }
    }

    public void isNotEmpty(Object object) {

        if (active) {

            if (null == object) {
                LOG.debug(UNEXPECTED_NULL);
                throw new AssertionError(UNEXPECTED_NULL);
            }

            if (List.class.isAssignableFrom(object.getClass())) {
                LOG.debug(USED_WRONG_METHOD);
                throw new IllegalArgumentException(USED_WRONG_METHOD);
            }

            if (String.class.isAssignableFrom(object.getClass())) {
                if (Objects.equals(object, EMPTY_STRING)) {
                    LOG.debug(UNEXPECTED_EMPTY_STRING);
                    throw new AssertionError(UNEXPECTED_EMPTY_STRING);
                }
            }
        }
    }

    public void areNotEmpty(List<Object> objects) {
        if (active) {
            for (Object object : objects) {
                isNotEmpty(object);
            }
        }
    }

    public boolean isAssertsOn() {
        return active;
    }

    public void setAssertsTo(boolean asserts) {
        Asserts.active = asserts;
    }

}
