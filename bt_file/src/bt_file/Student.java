package bt_file;

class Student {
	String studentID;
    String fullName;
    String gender;
    double pythonScore;
    double javaScore;
    double avgScore;
    String result;

    public Student(String studentID, String fullName, String gender, double pythonScore, double javaScore) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gender = gender;
        this.pythonScore = pythonScore;
        this.javaScore = javaScore;
        this.avgScore = (pythonScore + javaScore * 2) / 3;
        this.result = calculateResult();
    }

    public String calculateResult() {
        if (avgScore >= 5)
            return "Đậu";
        else if (avgScore < 5 && gender.equalsIgnoreCase("Nam"))
            return "Trượt";
        else if (avgScore < 5 && gender.equalsIgnoreCase("Nữ"))
            return "Đậu";
        else
            return "Không xác định";
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %-10.2f %-10.2f %-10.2f %-10s", studentID, fullName, gender, pythonScore, javaScore, avgScore, result);
    }
}