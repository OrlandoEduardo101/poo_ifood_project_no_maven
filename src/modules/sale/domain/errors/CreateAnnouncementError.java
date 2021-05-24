package modules.sale.domain.errors;

import modules.home.domain.errors.IHomeException;

public class CreateAnnouncementError extends IHomeException {
    public CreateAnnouncementError(String errorMessage) {
        super(errorMessage);
    }
}