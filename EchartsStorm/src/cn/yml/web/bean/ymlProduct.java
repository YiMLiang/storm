package cn.yml.web.bean;

public class ymlProduct {
    private String userAccount;// VARCHAR(50) ,-- 产品名
    private int count;// VARCHAR(50) ,-- 关键字

    public ymlProduct(String userAccount, int count) {
        super();
        this.userAccount = userAccount;
        this.count = count;
    }

    public ymlProduct() {
        super();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ymlProduct [userAccount=" + userAccount + ", count=" + count
                + "]";
    }
}
