import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;

public class BlackListFilter {

    public static final int BLACK_LIST_LIMIT_DAYS = 60;
    private List<Company> blackList;

    public List<Company> getBlackList() {
        return blackList;
    }

    public void filter(List<Invoice> invoices) {

        List<Company> newBlackList = invoices.stream()
                .filter(invoice -> !invoice.getPaid() && new DateTime(invoice.getCreatedDate()).plusDays(BLACK_LIST_LIMIT_DAYS).isBefore(new DateTime()))
                .map(Invoice::getCompany)
                .collect(Collectors.toList());

        blackList.addAll(newBlackList);
    }

}
