package org.example.meliexam.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dna")
public class Dna {
    @Id
    private String _id;
    private String[] sequence;
    private boolean isMutant;

    public Dna(String[] sequence, boolean isMutant) {
        this.sequence = sequence;
        this.isMutant = isMutant;
    }

    public String getId() {
        return _id;
    }
    public void setId(String id) {
        this._id = id;
    }
    public String[] getSequence() {
        return sequence;
    }
    public void setSequence(String[] sequence) {
        this.sequence = sequence;
    }
    public boolean getIsMutant() {
        return isMutant;
    }
    public void setIsMutant(boolean mutant) {
        this.isMutant = mutant;
    }
}
