package penguin.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;
import penguin.login.model.key.SystemVariableId;

@Table(name = "`system_variable`")
@IdClass(SystemVariableId.class)
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SystemVariable {
    @Id
    private String variableType;
    @Id
    private String variableCode;
    private String variableContent;
}
