package se.mbrock.gandul.journal;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class DiagnosisJournalEntry extends JournalEntry {

    private List<Diagnosis> diagnoses;

    public DiagnosisJournalEntry(String entryText, boolean stricken) {
        super(entryText, stricken);
        setType(JournalEntryType.DIAGNOSIS);
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
