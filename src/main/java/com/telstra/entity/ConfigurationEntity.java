package com.telstra.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Data
@Table(name = "configuration", schema = "cache_test")
@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler", "createdTs"})
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConfigurationEntity {
    @Basic
    @Column(name = "time_to_live")
    @NonNull
    private int timeToLive;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
