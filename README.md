

# 3mpe Custom Calendar

----
## What is 3mpeCalendar?
> Provides your Calendar launcher so that you can evaluate the DatePickerDialog with its start and end dates.

#####
<img width="250" height="250" src="http://i68.tinypic.com/2vd2rtf.jpg" />

## How to install 

```Groovy
repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}

dependencies {
  compile 'com.github.3mpe:3mp3Calendar:1.0.1'
}
```

#### Example 
````Groovy
        // import project.
        import com.example.a3mpe.mylibrary.emp3Calendar; 

        View content = getWindow().findViewById(Window.ID_ANDROID_CONTENT); // getview
        emp3Calendar calendar =  new emp3Calendar(this,content,R.id.txt_rent_start_date);
        calendar.setAutoStart(false); // default false
        calendar.setSeparator("-"); // default sperator '.'
        calendar.setTitle("Selection"); // default ' Date Selection '
````




| Function										   | Default value                                                         |
|------------------------------------------------- |:---------------------------------------------------------------------:|
| setTitle			 							   | Date Selection						                                   |
| setCalendarStartDate (calendarType, value)	   | To update the start date						                       |
| setCalendarEndDate (calendarType, value)	       | To update the End date						                           |
| setAutoStart (boolean start)					   | Do the second selection auto-start (Auto-start default value true)	   |				
| selectedSpecified (boolean specifiedTime)		   | Are you selected from the date specified ?						       |
| setStartDateIsFixed(boolean selectedDateIsFixed) | Is the selected date fixed						                       |
| setEndDateIsFixed (boolean selectedDateIsFixed)  | Is the selected date fixed						                       |
| getDateFormat (boolean selectedDateIsFixed)  	   | 						                                               |
| setDateFormat (boolean selectedDateIsFixed)  	   | Formats the output		                                               |				
| setSeparator (String seperator)				   | Change Reagents													   |









