package models;

public class SnackMachine {
    //states -------------
    final static String START="Start";
    final static String CANCEL="Cancel";
    final static String PAY="Pay";
    final static String SELECT="Select";
    final static String DELIVER="Deliver";
    //-------------------
    private String state;
    private MRow[] rows;
    private int keyPadInput;
    private String monitorDisplay;
    private Cash cash;
    private double moneyInput;


    public SnackMachine() {
        state=START;
        MRow[] rows=new MRow[5];
        this.keyPadInput = 0;
        this.monitorDisplay = "";
        cash=new Cash(3,3,3,3,3,3);
        moneyInput=0;
    }

    public SnackMachine(MRow[] rows) {
        state=START;
        this.rows = rows;
        this.keyPadInput = 0;
        this.monitorDisplay = "";
        cash=new Cash(114,114,114,114,114,4);
        moneyInput=0;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public double getMoneyInput() {
        return moneyInput;
    }

    public void setMoneyInput(double moneyInput) {
        if (moneyInput!=0){
            state=PAY;
        }
        this.moneyInput = moneyInput;
    }

    public MRow[] getRows() {
        return rows;
    }

    public void setRows(MRow[] rows) {
        this.rows = rows;
    }

    public int getKeyPadInput() {
        return keyPadInput;
    }


    public void setKeyPadInput(String keyPadInput) {
        if (state==PAY){
            this.keyPadInput = Integer.valueOf(keyPadInput);
            makeOrder(keyPadInput);
        }else{
            this.keyPadInput = Integer.valueOf(keyPadInput);
            if (!keyPadInput.equals(0)){
                setMonitorDisplay(findByIndex(keyPadInput+"").toString());
            }
        }
    }

    private void makeOrder(String keyPadInput) {

        Product product=findByIndex(keyPadInput+"");
        setMonitorDisplay("ordaring..."+product.getName());

        if (hasPayBack(product.getPrice())&&product!=null) {
            state = DELIVER;
            makeDelever(product,keyPadInput);
        }else {
            state = CANCEL;
            makeCancel();
        }
    }



    private boolean hasPayBack(double price) {
        if (moneyInput-price>=0) {
            return true;
        }
        return false;
    }

    public void makeCancel() {
        state = START;
        setMoneyInput(0);
        setKeyPadInput("0");
        setMonitorDisplay("the order has been canceled since no Money to pay back");
    }

    private void makeDelever(Product product,String k) {
        int[] payBack = cash.payBack(moneyInput,product.getPrice());
        if (payBack[0]>cash.getD50()||payBack[1]>cash.getD20()||payBack[2]>cash.getD1()||payBack[3]>cash.getC50()||payBack[4]>cash.getC20()||payBack[5]>cash.getC10()){
            makeCancel();
            return;
        }
        char[] yx=k.toCharArray();
        int y=Integer.valueOf(yx[0]+"");
        int x=Integer.valueOf(yx[1]+"");
        rows[x].columns[y].getProducts().remove(rows[x].columns[y].getFirstIndex());
        cash.incrementInTheCorrectCurrancy(moneyInput);
        cash.setC10(cash.getC10()-payBack[5]);
        cash.setC20(cash.getC20()-payBack[4]);
        cash.setC50(cash.getC50()-payBack[3]);
        cash.setD1(cash.getD1()-payBack[2]);
        cash.setD20(cash.getD20()-payBack[1]);
        cash.setD50(cash.getD50()-payBack[0]);
        state=START;
        setMonitorDisplay("the product has been delivered you can take it .... don't forget to take the reset of your money" );
        setMonitorDisplay("50$-> "+payBack[0]);
        setMonitorDisplay("20$-> "+payBack[1]);
        setMonitorDisplay("1$-> "+payBack[2]);
        setMonitorDisplay("0.5$-> "+payBack[3]);
        setMonitorDisplay("0.2$-> "+payBack[4]);
        setMonitorDisplay("0.1$-> "+payBack[5]);
    }

    public String getMonitorDisplay() {
        return monitorDisplay;
    }

    public void setMonitorDisplay(String monitorDisplay) {
        this.monitorDisplay = monitorDisplay;
        System.out.println(monitorDisplay);
    }


    public String insertProduct(Product product){
        int column=-1;
        int row=-1;
        for (MRow r:rows)
            if (!r.isFull()){
                column=r.insertProduct(product);
                row=r.getId();
                if (!(column==-1)){
                    return column+""+row;
                }
            }
        return "did not addded";
    }

    public String insertProduct(Product product, int quantity){
        for (int i=0;i<quantity;i++)
            insertProduct(product);
        return "done";
    }

    public Product findProductByID(int id){
        for (MRow row: rows) {
            if (row.findProduct(id)!=null)
                return row.findProduct(id);
        }
        return null;
    }

    public Product findByIndex(String index){
        char[] yx=index.toCharArray();
        return getRows()[Integer.valueOf(yx[1]+"")].getIndex(Integer.valueOf(yx[0]+""));
    }

}
