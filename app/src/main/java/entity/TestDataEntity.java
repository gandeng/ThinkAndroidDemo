package entity;

import com.ta.annotation.TACompareAnnotation;
import com.ta.util.db.annotation.TAColumn;
import com.ta.util.db.annotation.TAPrimaryKey;
import com.ta.util.db.annotation.TATransient;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ganjian on 2016/8/22.
 */
public class TestDataEntity implements Serializable {
    @TATransient
    private static final long serialVersionUIID= -7995717179024306707L;
    @TAPrimaryKey(autoIncrement = true)
    int auto;
    @TAColumn(name = "username")
    String name;
    Date date;
    char c;
    @TACompareAnnotation(sortFlag=0)
    int i=0;
    Boolean b;
    float f;
    double d;

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public float getF() {

        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public Boolean getB() {

        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public int getI() {

        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public char getC() {

        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuto() {

        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "TestDataEntity{" +
                "auto=" + auto +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", c=" + c +
                ", i=" + i +
                ", b=" + b +
                ", f=" + f +
                ", d=" + d +
                '}';
    }
}
