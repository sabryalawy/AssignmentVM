import models.MColumn;
import models.MRow;
import models.Product;
import models.SnackMachine;

import java.time.LocalDateTime;

public class InitSnackMachine {
    private static MColumn[] makeFiveMColumns() {
        MColumn[] columns5=new MColumn[5];
        int capacity=2;

        for (int i=0 ;i<columns5.length;i++)
            columns5[i] = new MColumn(i,capacity);

        return columns5;
    }

    private static MRow[] makeFiveRowsThatHasFiveColumnsEach() {
        MRow[] rows5=new MRow[5];
        for (int i=0 ;i<rows5.length;i++)
            rows5[i] = new MRow(i,makeFiveMColumns());
        return rows5;
    }

    public static SnackMachine initSnackMachine(){
        SnackMachine init = new SnackMachine(makeFiveRowsThatHasFiveColumnsEach());
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(1,5, LocalDateTime.now(),"water"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(2,10, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(3,0.3, LocalDateTime.now(),"M&Ms"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(4,0.2, LocalDateTime.now(),"kender"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));
        init.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));



//        init.insertProduct(new Product(11,10, LocalDateTime.now(),"kinder"),5);


        return init;
    }

}
