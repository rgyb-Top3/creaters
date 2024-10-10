
public class account {
    private String name;
    private String sex;
    private String id;
    private String password;
    private double money;
    private double quota;

    public account() {
    }

    public account(String name, String sex, String id, String password, double money, double quota) {
        this.name = name;
        this.sex = sex;
        this.id = id;
        this.password = password;
        this.money = money;
        this.quota = quota;
    }

    public String getSelfName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSelfId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuota() {
        return this.quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }
}

