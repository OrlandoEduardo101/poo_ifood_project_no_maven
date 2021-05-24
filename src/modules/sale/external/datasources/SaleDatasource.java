package modules.sale.external.datasources;

import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;
import modules.sale.infra.datasources.ISaleDatasource;

import java.util.HashMap;
import java.util.Map;

public class SaleDatasource implements ISaleDatasource {

    private static ISaleDatasource instance;

    private SaleDatasource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static ISaleDatasource getInstance() {
        if (instance == null) {
            instance = new SaleDatasource();
        }
        return (SaleDatasource) instance;
    }

    Map<Integer, Map<String, Object>> saleList = new HashMap<Integer, Map<String, Object>>();

    @Override
    public SaleEntitty setPurchase(SaleEntitty param) throws ISaleException {
        int id = saleList.size();

        while (saleList.containsKey(id)) {
            id++;
        }

        param.setId(id);
        saleList.put(id, param.toMap());

        return param;
    }
}
