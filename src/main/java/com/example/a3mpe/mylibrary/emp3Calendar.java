package com.example.a3mpe.mylibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Emre Vatansever 8.04.2017.
 */
public class emp3Calendar {
    private Context context;
    private View calendarRoot;
    private HashMap<String, Calendar> getFixedDates;
    private EditText edtCalendarStartDate, edtCalendarEndDate;
    private int
            startDay = 0,
            startMonth = 0,
            startYear = 0,
            endDay = 0,
            endMonth = 0,
            endYear = 0,
            EditTextResourceStartDate,
            EditTextResourceEndDate;
    private String title = "Date Selection";
    private String separator = ".";
    private SimpleDateFormat simpleDateFormat;
    private static String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
    private boolean
            autoStart = false,
            specifiedTime = false,
            startDateIsFixed = false,
            endDateIsFixed = false;


    public emp3Calendar(Context context, View view, int EditTextResourceStartDate) {
        this.context = context;
        this.calendarRoot = view;
        this.EditTextResourceStartDate = EditTextResourceStartDate;
        getFixedDates = Utils.getFixedDates();
    }

    public emp3Calendar(Context context, View view, Calendar startDate, int EditTextResourceStartDate) {
        this.context = context;
        this.calendarRoot = view;
        this.EditTextResourceStartDate = EditTextResourceStartDate;
        getFixedDates = Utils.getFixedDates();
        getFixedDates.get("start_date").compareTo(startDate);

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get("start_date"));
    }

    public emp3Calendar(Context context, View view, Calendar startDate, Calendar endDate, int EditTextResourceStartDate, int EditTextResourceEndDate) {
        this.context = context;
        this.calendarRoot = view;
        this.EditTextResourceStartDate = EditTextResourceStartDate;
        this.EditTextResourceEndDate = EditTextResourceEndDate;
        getFixedDates = Utils.getFixedDates();
        getFixedDates.get("start_date").compareTo(startDate);
        getFixedDates.get("end_date").compareTo(endDate);

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get("start_date"));

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get(""));
    }

    public emp3Calendar(Context context, View view, int EditTextResourceStartDate, int day, int month, int year) {
        this.context = context;
        this.calendarRoot = view;
        this.EditTextResourceStartDate = EditTextResourceStartDate;
        getFixedDates = Utils.getFixedDates();
        getFixedDates.get("start_date").set(Calendar.DAY_OF_MONTH, day);
        getFixedDates.get("start_date").set(Calendar.MONTH, month);
        getFixedDates.get("start_date").set(Calendar.YEAR, year);

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get("start_date"));
    }

    public emp3Calendar(Context context, View view, int EditTextResourceStartDate, int sartDay, int startMonth, int startYear, int EditTextResourceEndDate, int endDay, int endMonth, int endYear) {

        this.context = context;
        this.calendarRoot = view;
        this.EditTextResourceStartDate = EditTextResourceStartDate;
        this.EditTextResourceEndDate = EditTextResourceEndDate;
        getFixedDates = Utils.getFixedDates();
        getFixedDates.get("start_date").set(Calendar.DAY_OF_MONTH, sartDay);
        getFixedDates.get("start_date").set(Calendar.MONTH, startMonth);
        getFixedDates.get("start_date").set(Calendar.YEAR, startYear);

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get("start_date"));

        getFixedDates.get("end_date").set(Calendar.DAY_OF_MONTH, endDay);
        getFixedDates.get("end_date").set(Calendar.MONTH, endMonth);
        getFixedDates.get("end_date").set(Calendar.YEAR, endYear);

        simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        simpleDateFormat.setCalendar(getFixedDates.get("end_date"));

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCalendarStartDate(int calendarType, int value) {
        getFixedDates.get("start_date").set(calendarType, value);
    }

    public void setCalendarEndDate(int calendarType, int value) {
        getFixedDates.get("end_date").set(calendarType, value);
    }

    public void setAutoStart(boolean start) {
        this.autoStart = start;
    }

    public void selectedSpecified(boolean specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setStartDateIsFixed(boolean selectedDateIsFixed) {
        this.startDateIsFixed = selectedDateIsFixed;
    }

    public void setEndDateIsFixed(boolean selectedDateIsFixed) {
        this.endDateIsFixed = selectedDateIsFixed;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String setDateFormat(String dateFormat2) {
        dateFormat = dateFormat2 == null ? "" : "yyyy-MM-dd'T'HH:mm:ssZ";
        return dateFormat;
    }

    public void Show() {
        edtCalendarStartDate = (EditText) calendarRoot.findViewById(EditTextResourceStartDate);
        edtCalendarEndDate = (EditText) calendarRoot.findViewById(EditTextResourceEndDate);

        if (edtCalendarEndDate == null) init(false);
        else init(true);
    }

    private void init(boolean isTxtEndDate) {
        Calendar startDate = getFixedDates.get("start_date");
        Calendar endDate = getFixedDates.get("end_date");

        if (isTxtEndDate) {
            edtCalendarStartDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDatePicker(edtCalendarStartDate);
                }
            });
            edtCalendarEndDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDatePicker(edtCalendarEndDate);
                }
            });

            edtCalendarStartDate.setText(startDate.get(Calendar.DAY_OF_MONTH) + separator + startDate.get(Calendar.MONTH) + separator + startDate.get(Calendar.YEAR));
            edtCalendarStartDate.setText(endDate.get(Calendar.DAY_OF_MONTH) + separator + endDate.get(Calendar.MONTH) + separator + endDate.get(Calendar.YEAR));
        } else {
            edtCalendarStartDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDatePicker(edtCalendarStartDate);
                }
            });
            edtCalendarStartDate.setText(startDate.get(Calendar.DAY_OF_MONTH) + separator + startDate.get(Calendar.MONTH) + separator + startDate.get(Calendar.YEAR));
        }
    }

    private void openDatePicker(final EditText editText) {
        int mYear = 0;
        int mMonth = 0;
        int mDate = 0;

        if (autoStart) {
            mYear = getFixedDates.get("start_date").get(Calendar.YEAR);
            mMonth = getFixedDates.get("start_date").get(Calendar.MONTH);
            mDate = getFixedDates.get("start_date").get(Calendar.DAY_OF_MONTH);
        } else {
            Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDate = c.get(Calendar.DAY_OF_MONTH);
        }

        DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (editText.getId() == EditTextResourceStartDate) {
                    startYear = year;
                    startMonth = monthOfYear;
                    startDay = dayOfMonth;
                    edtCalendarStartDate.setText(dayOfMonth + separator + monthOfYear + separator + year);
                    if (specifiedTime)
                        openDatePicker(edtCalendarEndDate);
                } else if (editText.getId() == EditTextResourceEndDate) {
                    endYear = year;
                    endMonth = monthOfYear;
                    endDay = dayOfMonth;
                    edtCalendarEndDate.setText(dayOfMonth + separator + monthOfYear + separator + year);
                }

            }
        }, mYear, mMonth, mDate);

        if (editText.getId() == EditTextResourceStartDate && startDateIsFixed) {
            Calendar minDate = Calendar.getInstance();
            minDate.set(Calendar.YEAR, startYear);
            minDate.set(Calendar.MONTH, startMonth);
            minDate.set(Calendar.DAY_OF_MONTH, startDay);
            dialog.getDatePicker().setMinDate(minDate.getTimeInMillis() - 1000);
        } else if (editText.getId() == EditTextResourceEndDate && endDateIsFixed) {
            Calendar minDate = Calendar.getInstance();
            minDate.set(Calendar.YEAR, mYear);
            minDate.set(Calendar.MONTH, mMonth);
            minDate.set(Calendar.DAY_OF_MONTH, mDate);
            dialog.getDatePicker().setMinDate(minDate.getTimeInMillis() - 1000);
        }
        dialog.setTitle(title);
        dialog.show();

    }
}
