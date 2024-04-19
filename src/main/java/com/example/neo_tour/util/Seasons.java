package com.example.neo_tour.util;

import java.time.LocalDate;

public class Seasons {
    public static final int AUTUMN = 1;
    public static final int SPRING = 1 << 1;
    public static final int SUMMER = 1 << 2;
    public static final int WINTER = 1 << 3;

    public static final int[] ALL = {AUTUMN, SPRING, SUMMER, WINTER};

    public static int getCurrentSeasonMask() {
        int month = LocalDate.now().getMonthValue();
        int season;

        if (month >= 3 && month <= 5) { // March, April, May
            season = SPRING;
        } else if (month >= 6 && month <= 8) { // June, July, August
            season = SUMMER;
        } else if (month >= 9 && month <= 11) { // September, October, November
            season = AUTUMN;
        } else { // December, January, February
            season = WINTER;
        }

        return season;
    }
}
