package com.telstra.service.impl;

import com.telstra.dao.IConfigurationRepository;
import com.telstra.entity.ConfigurationEntity;
import com.telstra.service.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConfigurationServiceImpl implements IConfigurationService {

    @Autowired
    private IConfigurationRepository configurationRepository;

    @Override
    public void save(ConfigurationEntity configuration) {
        configurationRepository.save(configuration);
    }

    @Override
    public Optional<ConfigurationEntity> getTimeToLive() {
        List<ConfigurationEntity> list= configurationRepository.findAll();
        if(list.size()>=0)
            return Optional.of(list.get(0)) ;
        else
            return Optional.empty();
    }
}
