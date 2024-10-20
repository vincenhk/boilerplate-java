package co.tevent.identity.model;

import co.tevent.identity.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@EqualsAndHashCode(callSuper = true)
@Table(name = "user_document", schema = "db_identity")
@Entity
@Data
public class UserDocument extends BaseModel {
    private String userId;

    @ToString.Exclude
    @CreationTimestamp
    @Column(name = "uploaded_at", updatable = false, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String uploadedAt;

    @Lob
    private byte[] documentType;
    private int isVerified;

    @OneToOne(mappedBy = "userDocument")
    private User user;
}
