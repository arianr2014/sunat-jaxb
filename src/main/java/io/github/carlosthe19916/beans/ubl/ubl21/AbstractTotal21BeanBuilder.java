package io.github.carlosthe19916.beans.ubl.ubl21;

import io.github.carlosthe19916.beans.AbstractTotalBeanBuilder;

import java.math.BigDecimal;

public abstract class AbstractTotal21BeanBuilder<Builder extends AbstractTotal21BeanBuilder, Bean extends Total21Bean> extends AbstractTotalBeanBuilder<Builder, Bean> {

    protected AbstractTotal21BeanBuilder(Bean total) {
        super(total);
    }

    public AbstractTotal21BeanBuilder anticipos(BigDecimal anticipos) {
        total.setAnticipos(anticipos);
        return this;
    }

    public AbstractTotal21BeanBuilder extensionAmount(BigDecimal extensionAmount) {
        total.setExtensionAmount(extensionAmount);
        return this;
    }

    public AbstractTotal21BeanBuilder inclusiveAmount(BigDecimal inclusiveAmount) {
        total.setInclusiveAmount(inclusiveAmount);
        return this;
    }

}
