package com.OrlandoEduardo101.modules.home.domain.usecases;

import com.OrlandoEduardo101.modules.home.domain.entities.AnnouncementEntity;
import com.OrlandoEduardo101.modules.home.domain.errors.CreateAnnouncementError;
import com.OrlandoEduardo101.modules.home.domain.errors.IHomeException;
import com.OrlandoEduardo101.modules.home.domain.repositories.IHomeRepository;

interface ICreateAnnouncementUsecase {
    AnnouncementEntity createAnnouncement(AnnouncementEntity announcementParam) throws IHomeException;
}

public class CreateAnnouncementUsecase implements ICreateAnnouncementUsecase {
    private IHomeRepository _repository;

    private static CreateAnnouncementUsecase instance;

    private CreateAnnouncementUsecase(IHomeRepository repository) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._repository = repository;
    }

    public static CreateAnnouncementUsecase getInstance(IHomeRepository repository) {
        if (instance == null) {
            instance = new CreateAnnouncementUsecase(repository);
        }
        return instance;
    }


    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcementParam) throws IHomeException {
        try {
            return _repository.createAnnouncement(announcementParam);
        } catch (Exception e) {
            throw new CreateAnnouncementError(e.getMessage());
        }
    }
}


