

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<account> bank = new ArrayList();

    public ATM() {
    }

    public void beginFace() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("请选择：");
            System.out.println("1.创建账号");
            System.out.println("2.登录账号");
            switch (sc.next()) {
                case "1":
                    this.creatAccount();
                    break;
                case "2":
                    this.enterAccount();
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

    public void creatAccount() {
        account newuser = new account();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = sc.next();
        newuser.setName(name);
        System.out.println("请输入性别:");
        String sex = sc.next();
        newuser.setSex(sex);

        while(true) {
            System.out.println("请输入密码：");
            String password = sc.next();
            newuser.setSex(password);
            System.out.println("请确认密码：");
            String repassword = sc.next();
            newuser.setSex(repassword);
            if (this.confirmPass(password, repassword)) {
                newuser.setPassword(password);
                newuser.setId(this.craetId());
                this.bank.add(newuser);
                System.out.println("创建成功");
                PrintStream var10000 = System.out;
                ArrayList var10001 = this.bank;
                int var10002 = this.bank.size();
                var10000.println("您的账号是" + ((account)var10001.get(var10002 - 1)).getSelfId());
                return;
            }

            System.out.println("输入错误！");
        }
    }

    public String craetId() {
        String id = "";
        Random r = new Random();

        while(true) {
            int i;
            for(i = 0; i < 6; ++i) {
                id = id + r.nextInt(10);
            }

            i = 0;
            if (this.bank.isEmpty()) {
                return id;
            }

            while(i < this.bank.size()) {
                account now = (account)this.bank.get(i);
                if (now.getSelfId() == id) {
                    break;
                }

                if (i == this.bank.size() - 1) {
                    return id;
                }

                ++i;
            }
        }
    }

    public boolean confirmPass(String p1, String p2) {
        return p1.equals(p2);
    }

    public void enterAccount() {
        if (this.bank.isEmpty()) {
            System.out.println("请先创建账号");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入账号");
            String id = sc.next();

            for(int i = 0; i < this.bank.size(); ++i) {
                account find = (account)this.bank.get(i);
                if (id.equals(find.getSelfId())) {
                    System.out.println("请输入密码");
                    String pasw = sc.next();
                    if (this.confirmPass(pasw, find.getPassword())) {
                        System.out.println("密码正确");
                        this.workFace(find);
                        return;
                    }

                    System.out.println("密码错误");
                    return;
                }
            }

            System.out.println("账号错误！");
        }
    }

    public void workFace(account user) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("请选择");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账号");
            switch (sc.next()) {
                case "1":
                    this.showAccount(user);
                    break;
                case "2":
                    this.enterPrice(user);
                    break;
                case "3":
                    this.getPrice(user);
                    break;
                case "5":
                    this.changePass(user);
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

    public void showAccount(account user) {
        System.out.println("-------------------------");
        System.out.println("id:" + user.getSelfId());
        System.out.println("name:" + user.getSelfName());
        System.out.println("money:" + user.getMoney());
        System.out.println("sex:" + user.getSex());
    }

    public void enterPrice(account user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("请输入要存的金额：");
        double money = sc.nextDouble();
        user.setMoney(user.getMoney() + money);
        System.out.println("当前余额" + user.getMoney());
    }

    public void getPrice(account user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("请输入要取的金额：");
        double money = sc.nextDouble();
        if (money <= user.getMoney()) {
            user.setMoney(user.getMoney() - money);
        } else {
            System.out.println("余额不足！");
        }

        System.out.println("当前余额" + user.getMoney());
    }

    public void changePass(account user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("请输入原密码:");
        String olapass = sc.next();
        if (this.confirmPass(olapass, user.getPassword())) {
            String newpass = sc.next();
            user.setPassword(newpass);
        } else {
            System.out.println("错误!");
        }

    }
}
