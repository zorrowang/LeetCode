package src.java.easy.string;

class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int currentLate = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCount++;
                if (absentCount > 1)    return false;
                currentLate = 0;
            } else if (c == 'L') {
                currentLate++;
                if (currentLate > 2)    return false;
            } else {
                currentLate = 0;
            }
        }
        return true;
    }
}