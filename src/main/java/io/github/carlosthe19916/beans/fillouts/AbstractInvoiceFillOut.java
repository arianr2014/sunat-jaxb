package io.github.carlosthe19916.beans.fillouts;

import io.github.carlosthe19916.beans.AbstractInvoiceBean;
import io.github.carlosthe19916.beans.FechaBean;
import io.github.carlosthe19916.beans.config.ubl21.GlobalUBL21Defaults;
import io.github.carlosthe19916.beans.config.ubl21.UBL21Defaults;

import java.util.Date;

public abstract class AbstractInvoiceFillOut {

    protected UBL21Defaults defaults = GlobalUBL21Defaults.getInstance();

    protected void setFechaDefaults(AbstractInvoiceBean invoice) {
        if (invoice.getFecha() == null) {
            invoice.setFecha(new FechaBean());
        }

        if (invoice.getFecha().getFechaEmision() == null) {
            invoice.getFecha().setFechaEmision(new Date());
        }

        if (invoice.getFecha().getTimeZone() == null) {
            invoice.getFecha().setTimeZone(defaults.getTimeZone());
        }
    }

}
