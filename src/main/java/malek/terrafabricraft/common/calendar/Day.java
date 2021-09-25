package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.common.util.HelperUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;

import java.util.HashMap;
import java.util.Map;

public enum Day
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final Map<String, String> BIRTHDAYS = new HashMap<>();
    private static final Day[] VALUES = values();

    static
    {
        // Original developers, all hail their glorious creation
        BIRTHDAYS.put("JULY7", "Bioxx");
        BIRTHDAYS.put("JUNE18", "Kitty");
        BIRTHDAYS.put("OCTOBER2", "Dunk");

        // 1.12+ Dev Team and significant contributors
        BIRTHDAYS.put("MAY1", "Dries");
        BIRTHDAYS.put("DECEMBER9", "Alcatraz");
        BIRTHDAYS.put("FEBRUARY31", "Bunsan");
        BIRTHDAYS.put("MARCH14", "Claycorp");
        BIRTHDAYS.put("DECEMBER1", "LightningShock");
        BIRTHDAYS.put("JANUARY20", "Therighthon");
        BIRTHDAYS.put("FEBRUARY21", "CtrlAltDavid");
        BIRTHDAYS.put("MARCH10", "Disastermoo");
    }

    public static Day valueOf(int i)
    {
        return i < 0 ? MONDAY : i >= VALUES.length ? SUNDAY : VALUES[i];
    }

    public static MutableText getDayName(long totalDays, Month month, int dayOfMonth)
    {
        String birthday = BIRTHDAYS.get(month.name() + dayOfMonth);
        if (birthday != null)
        {
            return new TranslatableText("tfc.tooltip.calendar_birthday", birthday);
        }
        Day day = Day.valueOf((int) totalDays % 7);
        return HelperUtil.translateEnum(day);
    }
}