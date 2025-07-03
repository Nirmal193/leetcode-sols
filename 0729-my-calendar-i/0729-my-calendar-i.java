class MyCalendar {


    public List<int[]> calender;
    public MyCalendar() {
        calender = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] arr: calender){
            if(startTime >= arr[0] && startTime < arr[1])
                return false;
            if(endTime <= arr[1] && endTime > arr[0])
                return false;
            if(arr[0] >= startTime && arr[0] < endTime)
                return false;
            if(arr[1] > startTime && arr[1] <= endTime)
                return false;
        }
        calender.add(new int[]{startTime,endTime} );
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */