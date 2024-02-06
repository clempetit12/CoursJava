package demo.composeKey;


import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class EmployePK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lastName;
    private String firstName;

    public EmployePK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployePK employePK = (EmployePK) o;
        return Objects.equals(lastName, employePK.lastName) && Objects.equals(firstName, employePK.firstName);
    }

    // Référence unique :  identifiant unique
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
