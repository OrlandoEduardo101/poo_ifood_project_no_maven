package modules.sale.domain.errors;


public class PurchaseError extends ISaleException {
    public PurchaseError(String errorMessage) {
        super(errorMessage);
    }
}