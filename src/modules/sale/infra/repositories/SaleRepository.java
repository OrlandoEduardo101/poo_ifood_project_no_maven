package modules.sale.infra.repositories;
import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;
import modules.sale.domain.errors.PurchaseError;
import modules.sale.domain.repositories.ISaleRepository;
import modules.sale.infra.datasources.ISaleDatasource;

import java.util.HashMap;
import java.util.Map;

public class SaleRepository implements ISaleRepository {

    private ISaleDatasource _datasource;

    private static SaleRepository instance;

    private SaleRepository(ISaleDatasource datasource) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._datasource = datasource;
    }

    public static SaleRepository getInstance(ISaleDatasource datasource) {
        if (instance == null) {
            instance = new SaleRepository(datasource);
        }
        return (SaleRepository) instance;
    }

    @Override
    public SaleEntitty setPurchase(SaleEntitty param) throws ISaleException {
        try{
            return _datasource.setPurchase(param);
        } catch (Exception e) {
            throw new PurchaseError(e.getMessage());
        }
    }
}
