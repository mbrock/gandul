package se.mbrock.gandul.journal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JournalEntry {
    @Id
    private String id;

    private String entryText;

    private JournalEntryType type;

    private boolean stricken;

    public JournalEntry(String entryText, boolean stricken) {
        this.entryText = entryText;
        this.stricken = stricken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntryText() {
        return entryText;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public boolean isStricken() {
        return stricken;
    }

    public void setStricken(boolean stricken) {
        this.stricken = stricken;
    }

    public JournalEntryType getType() {
        return type;
    }

    public void setType(JournalEntryType type) {
        this.type = type;
    }
}
