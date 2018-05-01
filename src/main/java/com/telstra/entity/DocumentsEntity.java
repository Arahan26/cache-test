package com.telstra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
 import java.util.Date;


@Entity
@Table(name = "documents", schema = "cache_test")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({ "hibernate_lazy_initializer", "handler", "createdTs" })
@Data
  public class DocumentsEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "message")
    private String message;
    @JsonIgnore
    @Column(name = "created_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTs;


}
