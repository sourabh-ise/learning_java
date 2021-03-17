package com.fresco;

import java.text.DecimalFormat;

public abstract class Student {

    public abstract String result(String allMarks);

    double met(String s) {
        DecimalFormat df = new DecimalFormat("#.#");
        double val = 0.0;
        int score = Integer.parseInt(s);
        if (score >= 75) {
            val = 9 + find((score - 75), 0.04);
        } else if (score >= 60 && score <= 74) {
            val = 8 + find((score - 60), 0.06);
        } else if (score >= 50 && score <= 59) {
            val = 7 + find((score - 50), 0.1);
        } else if (score >= 40 && score <= 49) {
            val = 6 + find((score - 40), 0.1);
        } else {
            val = 0;
        }
        return Double.parseDouble(df.format(val));
    }

    private double find(int difference, double variance) {
        return difference * variance;
    }
}
