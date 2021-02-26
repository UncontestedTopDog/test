package com.yy.android.myapplicationaaq.diff;

import com.yy.android.myapplicationaaq.diff.Diff;

public class Data implements Diff {
    private String text;
    private int type;
    private int id;

    public Data(String text, int type, int id) {
        this.text = text;
        this.type = type;
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Data)) {
            return false;
        }
        return ((Data) o).text.equals(this.text);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean areItemsTheSame(Diff diff) {
        if (diff instanceof Data) {
            return this.id == ((Data) diff).getId();
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(Diff diff) {
        if (diff instanceof Data) {
            return this.text.equals( ((Data) diff).getText());
        }
        return false;
    }
}
