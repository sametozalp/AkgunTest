package com.ozalp.AkgunTest.controller.business.abstracts;

import com.ozalp.AkgunTest.model.entities.abstracts.BaseEntity;

import java.util.UUID;

public interface BaseService<T extends BaseEntity> {

    Boolean delete(UUID uuid);

    T getById(UUID uuid);
}
