class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int len = asteroids.length;
        long massm = mass;
        int h = asteroids[len-1];
        for(int i=0;i<len;i++){
            if(massm < asteroids[i])
                return false;
            massm += asteroids[i];
            if(massm >= h)
                return true;
        }
        return true;
    }
}