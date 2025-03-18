package com.documentmanagement.domain.entity;

import com.documentmanagement.domain.enums.MarkupType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "markups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Markup {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "text")
    private String text;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MarkupType type;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
