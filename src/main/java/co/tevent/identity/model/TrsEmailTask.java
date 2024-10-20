package co.tevent.identity.model;

import co.tevent.identity.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import co.tevent.identity.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "trs_email_task", schema = "db_identity")
public class TrsEmailTask  {
    @Id
    private String task_id;
    private String subject;
    private String recipient;
    @Lob
    private String body;
    private EmailStatus status;
    private boolean isVerified;
    private String verificationToken;

    @ToString.Exclude
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ToString.Exclude
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(name = "verification_sent_at")
    private LocalDateTime verificationSentAt;

    @ToString.Exclude
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(name = "verification_confirmed_at")
    private LocalDateTime verificationConfirmedAt;

    @ToString.Exclude
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(name = "token_expires_at")
    private LocalDateTime tokenExpiresAt;


}
