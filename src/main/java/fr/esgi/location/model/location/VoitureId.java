package fr.esgi.location.model.location;

import java.util.Objects;

/***
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/15/2022
 */
public class VoitureId {

    public final String voitureId;

    public VoitureId(String voitureId) {
        this.voitureId = voitureId;
    }

    public String getVoitureId() {
        return this.voitureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoitureId voitureId1 = (VoitureId) o;
        return Objects.equals(voitureId, voitureId1.voitureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voitureId);
    }
}
