public class DateID {
    String orderMonth, orderDay, orderYear;

    public DateID(String orderMonth, String orderDay, String orderYear) {
        this.orderMonth = orderMonth;
        this.orderDay = orderDay;
        this.orderYear = orderYear;
    }

    public String getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(String orderMonth) {
        this.orderMonth = orderMonth;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public String getOrderYear() {
        return orderYear;
    }

    public void setOrderYear(String orderYear) {
        this.orderYear = orderYear;
    }
}
