package se.mbrock.gandul.journal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Diagnosis {
    private String text;
    private boolean chronic;

    public Diagnosis(String text, boolean chronic) {
        this.text = text;
        this.chronic = chronic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChronic() {
        return chronic;
    }

    public void setChronic(boolean chronic) {
        this.chronic = chronic;
    }
}
