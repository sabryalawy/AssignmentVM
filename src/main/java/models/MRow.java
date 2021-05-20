package models;

public class MRow {
    int id;
    MColumn[] columns=new MColumn[5];

    public MRow(int id, MColumn[] columns) {
        this.id = id;
        this.columns = columns;
    }

    public MRow(int id) {
        this.id = id;
        this.columns = initalizeColumns();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MColumn[] getColumns() {
        return columns;
    }

    public void setColumns(MColumn[] columns) {
        this.columns = columns;
    }

    public int insertProduct(Product product){
        int rez=-1;
        for (MColumn c :
                getColumns()) {
            if (!c.isFull()){
                boolean didAdd=c.insertProduct(product);
                if (didAdd){//here we check the product if they are the same
                    rez=c.getId();
                    break;
                }
            }
        }
        return rez;
    }

    private MColumn[] initalizeColumns() {
        for (int i=0;i<columns.length;i++)
            columns[i]=new MColumn(i);
        return columns;
    }

    public Product findProduct(int id){
        Product rez=null;
        for (MColumn c :
                columns) {
            if (((rez=c.findProduct(id))!=null)) {
                return rez;
            }

        }
        return null;
    }

    public boolean isFull() {
        for (MColumn c:columns){
            if (!c.isFull()){
                return false;
            }
        }
        return true;
    }
    public Product getIndex(int column){
        return columns[column].getFirstIndex();
    }

}

