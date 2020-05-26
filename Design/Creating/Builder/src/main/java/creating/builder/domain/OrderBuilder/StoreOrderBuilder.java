package creating.builder.domain.OrderBuilder;

import creating.builder.domain.AbstractCompany;
import creating.builder.domain.AbstractOrderBuilder;
import creating.builder.domain.Company.Company;
import creating.builder.domain.Product.Surfing;
import creating.builder.domain.User.Customer;

import java.util.LinkedList;
import java.util.List;

public class StoreOrderBuilder extends AbstractOrderBuilder {

    @Override
    public void buildCompany() {
        AbstractCompany lending =
                new Company("vcredit", "维信金科", "4325***423");
        List<AbstractCompany> companyList = new LinkedList<>();
        companyList.add(lending);
        order.setCompany(companyList);
    }

    @Override
    public void buildProduct() {
        Surfing surfing = new Surfing();
        AbstractCompany company =
                new Company("Offline", "金薪贷", "234432***43243");
        surfing.setCompany(company);
        order.setOrderSource(surfing);
    }

    @Override
    public void buildUser() {
        Customer user = new Customer();
        user.setIdentityCard("6101221984****9743");
        user.setBankCard("6453439024****44324");
        user.setPhone("135****9832");
        user.setUserName("Seam");
        order.setUser(user);
    }
}
