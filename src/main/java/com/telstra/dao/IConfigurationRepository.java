package com.telstra.dao;

import com.telstra.entity.ConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IConfigurationRepository extends JpaRepository<ConfigurationEntity,Integer> {
    Optional<ConfigurationEntity> getConfigurationEntityById(int id);
}
