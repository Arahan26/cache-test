package com.telstra.service;

import com.telstra.entity.ConfigurationEntity;

import java.util.Optional;



public interface IConfigurationService {
    void save(ConfigurationEntity configuration);

   // int getTimeToLive();
   Optional<ConfigurationEntity> getTimeToLive();

}
