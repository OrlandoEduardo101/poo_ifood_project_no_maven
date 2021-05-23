package com.OrlandoEduardo101.modules.home.domain.usecases;

import com.OrlandoEduardo101.modules.home.domain.entities.AnnouncementEntity;
import com.OrlandoEduardo101.modules.home.domain.errors.CreateAnnouncementError;
import com.OrlandoEduardo101.modules.home.domain.errors.IHomeException;
import com.OrlandoEduardo101.modules.home.domain.repositories.IHomeRepository;

import java.util.List;

interface IListAllAnnouncementUsecase {
    List<AnnouncementEntity> listAllAnnouncement() throws IHomeException;
}

public class ListAllAnnouncementUsecase implements IListAllAnnouncementUsecase {
    private IHomeRepository _repository;

    private static ListAllAnnouncementUsecase instance;

    private ListAllAnnouncementUsecase(IHomeRepository repository) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._repository = repository;
    }

    public static ListAllAnnouncementUsecase getInstance(IHomeRepository repository) {
        if (instance == null) {
            instance = new ListAllAnnouncementUsecase(repository);
        }
        return instance;
    }


    @Override
    public List<AnnouncementEntity> listAllAnnouncement() throws IHomeException {
        try {
            return _repository.listAllAnnouncement();
        } catch (Exception e) {
            throw new CreateAnnouncementError(e.getMessage());
        }
    }
}


