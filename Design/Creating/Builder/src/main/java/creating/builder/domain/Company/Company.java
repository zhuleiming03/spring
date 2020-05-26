package creating.builder.domain.Company;

import creating.builder.domain.AbstractCompany;

public class Company extends AbstractCompany {

    private String companyName;

    private String companyCode;

    private String companyType;

    private String toAccount;

    public Company(String companyCode) {
        this(companyCode, "");
    }

    public Company(String companyCode, String companyName) {
        this(companyCode, companyName, "");
    }

    public Company(String companyCode, String companyName, String toAccount) {
        this(companyCode, companyName, toAccount, "lending");
    }

    public Company(String companyCode, String companyName, String toAccount, String companyType) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyType = companyType;
        this.toAccount = toAccount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyType='" + companyType + '\'' +
                ", toAccount='" + toAccount + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getToAccount() {
        return toAccount;
    }
}
