package ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    long id;
    String name;
    String email;
    int bonus;
    int report;
    int app;
    double lt;

    public Student(long id, String name, String email, int bonus, int report, int app, double lt) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public double getTotalFinal() {
        double total = 0.1 * bonus + 0.3 * report + 0.15 * app + 0.45 * lt;
        return Math.round(total * 10) / 10;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + bonus + "," + report + "," + app + "," + lt;
    }

    public boolean isVailEmail() {
        String regex = "^([\\w.-]+)@|(?!gmail|outlook)(([a-zA-Z\\d-]+\\.)+)([a-zA-Z]{2,15}|\\d{1,3})(\\]?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean matchFound = m.find();
        return matchFound;
    }

    public boolean isVailEmailGmail() {
        String regex = "^([\\w.-]+)@|(?!gmail)(([a-zA-Z\\d-]+\\.)+)([a-zA-Z]{2,15}|\\d{1,3})(\\]?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean matchFound = m.find();
        return matchFound;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

}
