package modules.sale.domain.repositories;
import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;

public interface ISaleRepository {
    SaleEntitty setPurchase(SaleEntitty param) throws ISaleException;
}
