package models;

public class Cash {
    private double total;
    private int c10;
    private int c20;
    private int c50;
    private int d1;
    private int d20;
    private int d50;

    public Cash( int c10, int c20, int c50, int d1, int d20, int d50) {
        this.total = 100.0*c10+100.0*c20+100.0*c50+d1+d20+d50;
        this.c10 = c10;
        this.c20 = c20;
        this.c50 = c50;
        this.d1 = d1;
        this.d20 = d20;
        this.d50 = d50;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public int getC20() {
        return c20;
    }

    public void setC20(int c20) {
        this.c20 = c20;
    }

    public int getC50() {
        return c50;
    }

    public void setC50(int c50) {
        this.c50 = c50;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD20() {
        return d20;
    }

    public void setD20(int d20) {
        this.d20 = d20;
    }

    public int getD50() {
        return d50;
    }

    public void setD50(int d50) {
        this.d50 = d50;
    }


    //1,000 cent  =  10 dollar && 2,000 cent = 20 doller && 100 cent = 1 doller && 5,000 cent = 50 doller
    //rez[0]=num(50)
    //rez[5]=num(0.1)
    public int[] payBack(double moneyInserted,double moneyInPrice){
        int rez[]=new int[6];
        if (moneyInserted>moneyInPrice){
            Double moneyWillBack = moneyInserted-moneyInPrice;
            moneyWillBack=moneyWillBack*100.0;// to convert it to cent

            if (moneyWillBack%5000>=0){
                rez[0]=(int)Math.floor(moneyWillBack/5000);
                moneyWillBack=(moneyWillBack%5000);
            }
            if (moneyWillBack%2000>=0) {
                rez[1] = (int) Math.floor(moneyWillBack / 2000);
                moneyWillBack=(moneyWillBack%2000);
            }

            if (moneyWillBack%100>=0) {
                rez[2] = (int) Math.floor(moneyWillBack / 100);
                moneyWillBack=(moneyWillBack%100);
            }
            if (moneyWillBack%50>=0) {
                rez[3] = (int) Math.floor(moneyWillBack / 50);
                moneyWillBack=(moneyWillBack%50);
            }
            if (moneyWillBack%20>=0) {
                rez[4] = (int) Math.floor(moneyWillBack / 20);
                moneyWillBack=(moneyWillBack%20);
            }
            if (moneyWillBack%10>=0) {
                rez[5] = (int) Math.floor(moneyWillBack / 10);
                moneyWillBack=(moneyWillBack%10);
            }

        }

        return rez;
    }

    public void incrementInTheCorrectCurrancy(double currunsy){
        if (currunsy==0.10){
            c10++;
        }
        if (currunsy==0.20){
            c20++;
        }
        if (currunsy==0.50){
            c50++;
        }
        if (currunsy==1){
            d1++;
        }
        if (currunsy==20){
            d20++;
        }
        if (currunsy==50){
            d50++;
        }
    }


}
