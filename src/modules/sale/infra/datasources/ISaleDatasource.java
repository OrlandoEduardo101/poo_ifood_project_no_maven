package modules.sale.infra.datasources;

import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;

public interface ISaleDatasource {
    SaleEntitty setPurchase(SaleEntitty param) throws ISaleException;
}
