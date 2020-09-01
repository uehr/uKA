package co.uehr.uka.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="trend")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrendEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="trending_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trendingAt;

    @Column(name="rank")
    private int rank;

    @Column(name="word")
    private String word;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedAt = new Date();
    }
}