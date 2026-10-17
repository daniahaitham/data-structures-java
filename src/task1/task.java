package task1;
public class task {
    private String name;
    private String dueDate;
    private String priority;
    private String category;
    private int day;
    private int month;
    private int year;
    private boolean completed;  

    public task(String name, int day, int month, int year, String priority, String category) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.dueDate = day + "/" + month + "/" + year;
        this.priority = priority;
        this.category = category;
        this.completed = false;// by defual it is not completed 
    }

	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    
    
    
    // SIMPLE ERROR AVOIDING:
    public void setDay(int day) {
    	  if (day > 0 && day <= 31) { // Simplified validation for day
              this.day = day;
          } else {
              throw new IllegalArgumentException("Invalid day");
          }
    	  }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
    	 if (month > 0 && month <= 12) { // Simplified validation for month
             this.month = month;
         } else {
             throw new IllegalArgumentException("Invalid month");
         }
    	 
   }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
    	 if (year > 0) { // Simplified validation for year
             this.year = year;
         } else {
             throw new IllegalArgumentException("Invalid year");
         }
    }

    public String getDueDate() {
        return day + "/" + month + "/" + year;
    }
    
    
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
	
    public boolean GetCompleted() {
        return completed;
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", dueDate='" + getDueDate() + '\'' +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
                ", completed=" + completed +
                '}';
    }
    
	 
}
