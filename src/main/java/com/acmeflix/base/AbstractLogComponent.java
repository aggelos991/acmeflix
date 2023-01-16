package com.acmeflix.base;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Abstract class used to provide logging functionality to all components.
 */
public abstract class AbstractLogComponent {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void init() {
        logger.trace("Loaded {}.", getClass().getName());
    }

    @PreDestroy
    private void destroy() {
        logger.trace("Ready to destroy {}.", getClass().getName());
    }
}