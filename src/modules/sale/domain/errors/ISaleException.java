package modules.sale.domain.errors;

public abstract class ISaleException extends Exception {
    public ISaleException(String errorMessage) {
        super(errorMessage);
    }
}

