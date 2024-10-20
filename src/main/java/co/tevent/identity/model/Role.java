package co.tevent.identity.model;


import co.tevent.identity.model.base.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "roles", schema = "db_identity")
public class Role extends BaseModel {

    @OneToOne(mappedBy = "roleId")
    private User users;

    @Column(name = "role_name")
    private String roleName;
}
