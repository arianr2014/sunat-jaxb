package io.github.carlosthe19916.sunatjaxb.ubl21.utils;

import io.github.carlosthe19916.sunatjaxb.core.catalogos.Catalogo1;
import io.github.carlosthe19916.sunatjaxb.core.catalogos.Catalogo6;
import io.github.carlosthe19916.sunatjaxb.core.catalogos.Catalogo7;
import io.github.carlosthe19916.sunatjaxb.ubl21.beans.Invoice21Bean;
import io.github.carlosthe19916.sunatjaxb.ubl21.builders.Invoice21BeanBuilder;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class Bean21ToTypeTest {

    //    private TimeZone timeZone;
//    private Invoice20Bean invoiceBean;
//
//    public static NodeList getNodesWithXPath(Node aNode, String aXPath) throws XPathExpressionException {
//        NamespaceContext namespaceContext = new SimpleInvoiceNamespaceContext();
//
//        XPathFactory xPathFactory = XPathFactory.newInstance();
//        XPath xPath = xPathFactory.newXPath();
//        xPath.setNamespaceContext(namespaceContext);
//
//        XPathExpression xPathExpression = xPath.compile(aXPath);
//        return (NodeList) xPathExpression.evaluate(aNode, XPathConstants.NODESET);
//    }

    @Test
    public void before() {
        Invoice21Bean invoice = Invoice21BeanBuilder.builder()
                .serie("F001")
                .numero(1_234_567)
                .tipoComprobante(Catalogo1.FACTURA)
                .fecha()
                    .fechaEmision(new Date())
                    .end()
                .firmante()
                    .nombreEmpresa("MiEmpresa")
                    .idEmpresa("MiEmpresaID")
                    .idFirma("MiFirma")
                    .end()
                .impuestos()
                    .igv(BigDecimal.valueOf(10))
                    .end()
                .total()
                    .pagar(BigDecimal.valueOf(1))
                    .descuentoGlobal(BigDecimal.valueOf(2))
                    .otrosCargos(BigDecimal.valueOf(5))
                    .end()
                .totalInformacionAdicional()
                    .gravado(BigDecimal.valueOf(1))
                    .inafecto(BigDecimal.valueOf(2))
                    .exonerado(BigDecimal.valueOf(3))
                    .gratuito(BigDecimal.valueOf(4))
                    .end()
                .proveedor()
                    .codigoTipoDocumento(Catalogo6.RUC)
                    .numeroDocumento("10467793549")
                    .nombreComercial("Wolsnut4 Consultores")
                    .razonSocial("Wolsnut4 S.A.")
                    .codigoPostal("050101")
                    .end()
                .cliente()
                    .codigoTipoDocumento(Catalogo6.DNI)
                    .numeroDocumento("46779354")
                    .nombre("Carlos Esteban Feria Vila")
                    .email("carlosthe19916@gmail.com")
                    .direccion("Jr. carlos 997")
                    .end()
                .addDetalle()
                    .unidadMedida("NIU")
                    .descripcion("Bolsa de arroz")
                    .codigoTipoIgv(Catalogo7.GRAVADO_OPERACION_ONEROSA)
                    .cantidad(new BigDecimal("100"))
                    .valorUnitario(new BigDecimal("10"))
                    .precioUnitario(new BigDecimal("11.8"))
                    .subtotal(new BigDecimal("1000"))
                    .total(new BigDecimal("1180"))
                    .totalIgv(new BigDecimal("180"))
                    .end()
                .build();
    }

//    @Test
//    public void testInvalidInvoice() {
//        invoiceBean.setSerie(null);
//        invoiceBean.setNumero(null);
//
//        try {
//            Bean21ToType.toInvoiceType(invoiceBean, timeZone);
//        } catch (Invoice20BeanValidacionException e) {
//            Set<String> paths = e.getViolations().stream().map(f -> f.getPropertyPath().toString()).collect(Collectors.toSet());
//            Assert.assertTrue(paths.contains("serie"));
//            Assert.assertTrue(paths.contains("numero"));
//        }
//    }
//
//    @Test(expected = InvalidCodeException.class)
//    public void testInvalidCodeOnInvoiceLine() {
//        invoiceBean.getDetalle().get(0).setCodigoTipoIgv("09");
//        Bean21ToType.toInvoiceType(invoiceBean, timeZone);
//    }
//
//    @Test
//    public void toInvoiceTypeTest() throws Exception {
//        InvoiceType invoiceType = Bean21ToType.toInvoiceType(invoiceBean, timeZone);
//
//        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factories = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
//        JAXBElement<InvoiceType> jaxbElement = factories.createInvoice(invoiceType);
//        Document xmlDocument = JaxbUtils.toDocument(InvoiceType.class, jaxbElement);
//
//        // Extensions
//        Assert.assertEquals("1001", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("1", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/@currencyID").item(0).getTextContent());
//
//        Assert.assertEquals("1002", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:ID/text()").item(1).getTextContent());
//        Assert.assertEquals("2", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/text()").item(1).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/@currencyID").item(1).getTextContent());
//
//        Assert.assertEquals("1003", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:ID/text()").item(2).getTextContent());
//        Assert.assertEquals("3", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/text()").item(2).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/@currencyID").item(2).getTextContent());
//
//        Assert.assertEquals("1004", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:ID/text()").item(3).getTextContent());
//        Assert.assertEquals("4", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/text()").item(3).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent/sac:AdditionalInformation/sac:AdditionalMonetaryTotal/cbc:PayableAmount/@currencyID").item(3).getTextContent());
//
//        // Empty extension to sign
//        Assert.assertEquals(2, getNodesWithXPath(xmlDocument, "//ns:Invoice/ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent").getLength());
//
//        // General data
//        Assert.assertEquals("2.0", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:UBLVersionID/text()").item(0).getTextContent());
//        Assert.assertEquals("1.0", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:CustomizationID/text()").item(0).getTextContent());
//        Assert.assertEquals("F001-1", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("2018-05-14", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:IssueDate/text()").item(0).getTextContent());
//        Assert.assertEquals("01", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:InvoiceTypeCode/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cbc:DocumentCurrencyCode/text()").item(0).getTextContent());
//
//        // Signature
//        Assert.assertEquals("IDSignWolsnut4Consultores", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:Signature/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("10467793549", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:Signature/cac:SignatoryParty/cac:PartyIdentification/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("Wolsnut4 Consultores", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:Signature/cac:SignatoryParty/cac:PartyName/cbc:Name/text()").item(0).getTextContent());
//        Assert.assertEquals("#signatureWolsnut4Consultores", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:Signature/cac:DigitalSignatureAttachment/cac:ExternalReference/cbc:URI/text()").item(0).getTextContent());
//
//        // Supplier
//        Assert.assertEquals("10467793549", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cbc:CustomerAssignedAccountID/text()").item(0).getTextContent());
//        Assert.assertEquals("6", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cbc:AdditionalAccountID/text()").item(0).getTextContent());
//
//        Assert.assertEquals("050101", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("Jr. ayacucho 123", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cbc:StreetName/text()").item(0).getTextContent());
//        Assert.assertEquals("Jesús Nazareno", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cbc:District/text()").item(0).getTextContent());
//        Assert.assertEquals("Huamanga", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cbc:CityName/text()").item(0).getTextContent());
//        Assert.assertEquals("Ayacucho", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cbc:CountrySubentity/text()").item(0).getTextContent());
//        Assert.assertEquals("PE", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingSupplierParty/cac:Party/cac:PostalAddress/cac:Country/cbc:IdentificationCode/text()").item(0).getTextContent());
//
//        // Customer
//        Assert.assertEquals("46779354", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingCustomerParty/cbc:CustomerAssignedAccountID/text()").item(0).getTextContent());
//        Assert.assertEquals("3", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingCustomerParty/cbc:AdditionalAccountID/text()").item(0).getTextContent());
//
//        Assert.assertEquals("Carlos Esteban Feria Vila", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:AccountingCustomerParty/cac:Party/cac:PartyLegalEntity/cbc:RegistrationName/text()").item(0).getTextContent());
//
//        // Tax Total
//        Assert.assertEquals("10", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cbc:TaxAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cbc:TaxAmount/@currencyID").item(0).getTextContent());
//
//        Assert.assertEquals("10", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cac:TaxSubtotal/cbc:TaxAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cac:TaxSubtotal/cbc:TaxAmount/@currencyID").item(0).getTextContent());
//        Assert.assertEquals("1000", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID").item(0).getTextContent());
//        Assert.assertEquals("IGV", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name").item(0).getTextContent());
//        Assert.assertEquals("VAT", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode").item(0).getTextContent());
//
//        // Legal Monetary Total
//        Assert.assertEquals("5", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:PayableAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:PayableAmount/@currencyID").item(0).getTextContent());
//
//        Assert.assertEquals("6", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:AllowanceTotalAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:AllowanceTotalAmount/@currencyID").item(0).getTextContent());
//
//        Assert.assertEquals("7", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:ChargeTotalAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:LegalMonetaryTotal/cbc:ChargeTotalAmount/@currencyID").item(0).getTextContent());
//
//        // Lines
//        Assert.assertEquals("1", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cbc:ID/text()").item(0).getTextContent());
//
//        Assert.assertEquals("100", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cbc:InvoicedQuantity/text()").item(0).getTextContent());
//        Assert.assertEquals("NIU", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cbc:InvoicedQuantity/@unitCode").item(0).getTextContent());
//
//        Assert.assertEquals("1000", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cbc:LineExtensionAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cbc:LineExtensionAmount/@currencyID").item(0).getTextContent());
//
//        Assert.assertEquals("11.8", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceAmount/@currencyID").item(0).getTextContent());
//        Assert.assertEquals("01", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:PricingReference/cac:AlternativeConditionPrice/cbc:PriceTypeCode/text()").item(0).getTextContent());
//
//        Assert.assertEquals("180", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cbc:TaxAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cbc:TaxAmount/@currencyID").item(0).getTextContent());
//        Assert.assertEquals("10", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cbc:TaxExemptionReasonCode/text()").item(0).getTextContent());
//        Assert.assertEquals("1000", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:ID/text()").item(0).getTextContent());
//        Assert.assertEquals("IGV", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:Name/text()").item(0).getTextContent());
//        Assert.assertEquals("VAT", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:TaxTotal/cac:TaxSubtotal/cac:TaxCategory/cac:TaxScheme/cbc:TaxTypeCode/text()").item(0).getTextContent());
//        Assert.assertEquals("Bolsa de arroz", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:Item/cbc:Description/text()").item(0).getTextContent());
//        Assert.assertEquals("10", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:Price/cbc:PriceAmount/text()").item(0).getTextContent());
//        Assert.assertEquals("PEN", getNodesWithXPath(xmlDocument, "//ns:Invoice/cac:InvoiceLine/cac:Price/cbc:PriceAmount/@currencyID").item(0).getTextContent());
//
//    }

}