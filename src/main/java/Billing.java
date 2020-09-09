import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

public class Billing {

    private List<Invoice> invoices;

    public void bill(Company company) {

        company.getAgreements().values().forEach( agreement -> {

            DateTime agreementStartDate = new DateTime(agreement.getStartDate());
            DateTime invoiceEndDateForCurrentMonth = agreementStartDate.plusDays(30 * agreement.getAgreementTimeInMonth());

            if (invoiceEndDateForCurrentMonth.isBefore(new DateTime())) {
                Double calculatedPrice = agreement.calculatePrice();

                Invoice invoice = new Invoice();
                invoice.setCompany(company);
                invoice.setCreatedDate(new Date());
                invoice.setNotificationPackage(agreement.getNotificationPackage());
                invoice.setPaid(false);
                invoice.setPrice(calculatedPrice);

                invoices.add(invoice);
            }
        });
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
