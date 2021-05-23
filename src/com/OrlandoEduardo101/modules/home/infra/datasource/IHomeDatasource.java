package com.OrlandoEduardo101.modules.home.infra.datasource;

import com.OrlandoEduardo101.modules.home.domain.entities.AnnouncementEntity;
import com.OrlandoEduardo101.modules.home.domain.errors.CreateAnnouncementError;
import com.OrlandoEduardo101.modules.home.domain.errors.IHomeException;
import com.OrlandoEduardo101.modules.home.domain.errors.ListAnnouncementError;

import java.util.List;

public interface IHomeDatasource {
    AnnouncementEntity createAnnouncement(AnnouncementEntity announcementParam) throws CreateAnnouncementError, IHomeException;
    List<AnnouncementEntity> listAllAnnouncement() throws ListAnnouncementError, IHomeException;
    List<AnnouncementEntity> listMyAnnouncement(int userID) throws ListAnnouncementError, IHomeException;
    List<AnnouncementEntity> deleteMyAnnouncement(int userID, String productCode) throws ListAnnouncementError, IHomeException;
}
