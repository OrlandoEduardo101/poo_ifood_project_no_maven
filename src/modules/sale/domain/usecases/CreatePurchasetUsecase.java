package modules.sale.domain.usecases;
import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;
import modules.sale.domain.errors.PurchaseError;
import modules.sale.domain.repositories.ISaleRepository;

interface ICreatePurchasetUsecase {
    SaleEntitty setPurchase(SaleEntitty param) throws ISaleException;
}

public class CreatePurchasetUsecase implements ICreatePurchasetUsecase {
    private ISaleRepository _repository;

    private static CreatePurchasetUsecase instance;

    private CreatePurchasetUsecase(ISaleRepository repository) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._repository = repository;
    }

    public static CreatePurchasetUsecase getInstance(ISaleRepository repository) {
        if (instance == null) {
            instance = new CreatePurchasetUsecase(repository);
        }
        return instance;
    }


    @Override
    public SaleEntitty setPurchase(SaleEntitty param) throws ISaleException {
        try {
            return _repository.setPurchase(param);
        } catch (Exception e) {
            throw new PurchaseError(e.getMessage());
        }
    }
}


