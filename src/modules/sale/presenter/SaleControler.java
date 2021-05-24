package modules.sale.presenter;

import AuthStore.AuthStore;
import modules.home.domain.entities.AnnouncementEntity;
import modules.home.domain.entities.DrinkModel;
import modules.home.domain.errors.IHomeException;
import modules.home.domain.usecases.ListAllAnnouncementUsecase;
import modules.sale.domain.entities.SaleEntitty;
import modules.sale.domain.errors.ISaleException;
import modules.sale.domain.errors.PurchaseError;
import modules.sale.domain.usecases.CreatePurchasetUsecase;

import java.util.ArrayList;
import java.util.List;

public class SaleControler {
    private CreatePurchasetUsecase _createPurchase;
    private AuthStore _authStore;
    private ListAllAnnouncementUsecase _listAllAnnouncementUsecase;
    SaleEntitty sale = new SaleEntitty();

    List<AnnouncementEntity> announcementEntityList = new ArrayList<AnnouncementEntity>();

    public SaleControler(AuthStore _authStore, CreatePurchasetUsecase _createPurchase, ListAllAnnouncementUsecase listAllAnnouncementUsecase) {
        this._createPurchase = _createPurchase;
        this._authStore = _authStore;
        this._listAllAnnouncementUsecase = listAllAnnouncementUsecase;
    }

    public void setAnnouncementCode(String code) throws ISaleException, IHomeException {
        announcementEntityList = _listAllAnnouncementUsecase.listAllAnnouncement();
        AnnouncementEntity announcementEntity = null;
        sale = new SaleEntitty();

        for (int i = 0; i < announcementEntityList.size(); i++) {
            if (announcementEntityList.get(i).getProductCode().contains(code)){
                announcementEntity = announcementEntityList.get(i);
            }
        }

        if(announcementEntity == null){
            throw new PurchaseError("Announcement not found");
        }


        sale.setAnnouncementId(announcementEntity.getId());
        sale.setUserId(_authStore.getLoggedUser().getId());
        sale.setSellerId(announcementEntity.getSellerId());
        sale.setPurchasePrice(announcementEntity.getProduct().getPrice());

        sale = _createPurchase.setPurchase(sale);
    }
}
