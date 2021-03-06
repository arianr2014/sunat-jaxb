package io.github.carlosthe19916.beans.ubl.ubl21;

import io.github.carlosthe19916.beans.AbstractImpuestosBeanBuilder;

import java.math.BigDecimal;

public abstract class AbstractImpuestos21BeanBuilder<Builder extends AbstractImpuestos21BeanBuilder, Bean extends Impuestos21Bean> extends AbstractImpuestosBeanBuilder<Builder, Bean> {

    protected AbstractImpuestos21BeanBuilder(Bean bean) {
        super(bean);
    }

    public AbstractImpuestos21BeanBuilder igvAfecto(BigDecimal igvAfecto) {
        impuestos.setIgvAfecto(igvAfecto);
        return this;
    }

    public AbstractImpuestos21BeanBuilder iscAfecto(BigDecimal iscAfecto) {
        impuestos.setIscAfecto(iscAfecto);
        return this;
    }

    public AbstractImpuestos21BeanBuilder otrosAfecto(BigDecimal otrosAfecto) {
        impuestos.setOtrosAfecto(otrosAfecto);
        return this;
    }

}
