package com.OrlandoEduardo101.modules.home.domain.usecases;

import com.OrlandoEduardo101.modules.home.domain.entities.AnnouncementEntity;
import com.OrlandoEduardo101.modules.home.domain.errors.DeleteAnnouncementError;
import com.OrlandoEduardo101.modules.home.domain.errors.IHomeException;
import com.OrlandoEduardo101.modules.home.domain.repositories.IHomeRepository;

import java.util.List;

interface IDeleteMyAnnouncementUsecase {
    List<AnnouncementEntity> deleteMyAnnouncement(int userID, String productCode) throws IHomeException;
}

public class DeleteMyAnnouncementUsecase implements IDeleteMyAnnouncementUsecase {
    private IHomeRepository _repository;

    private static DeleteMyAnnouncementUsecase instance;

    private DeleteMyAnnouncementUsecase(IHomeRepository repository) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._repository = repository;
    }

    public static DeleteMyAnnouncementUsecase getInstance(IHomeRepository repository) {
        if (instance == null) {
            instance = new DeleteMyAnnouncementUsecase(repository);
        }
        return instance;
    }


    @Override
    public List<AnnouncementEntity> deleteMyAnnouncement(int userID, String productCode) throws IHomeException {
        try {
            return _repository.deleteMyAnnouncement(userID, productCode);
        } catch (Exception e) {
            throw new DeleteAnnouncementError(e.getMessage());
        }
    }
}


