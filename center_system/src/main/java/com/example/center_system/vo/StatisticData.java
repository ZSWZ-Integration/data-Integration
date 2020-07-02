package com.example.center_system.vo;

public class StatisticData {
    StatisticCourseListVO statisticCourseData;
    StatisticStudentListVO statisticStudentData;

    public StatisticData(StatisticCourseListVO statisticCourseData, StatisticStudentListVO statisticStudentData) {
        this.statisticCourseData = statisticCourseData;
        this.statisticStudentData = statisticStudentData;
    }

    public StatisticCourseListVO getStatisticCourseData() {
        return statisticCourseData;
    }

    public void setStatisticCourseData(StatisticCourseListVO statisticCourseData) {
        this.statisticCourseData = statisticCourseData;
    }

    public StatisticStudentListVO getStatisticStudentData() {
        return statisticStudentData;
    }

    public void setStatisticStudentData(StatisticStudentListVO statisticStudentData) {
        this.statisticStudentData = statisticStudentData;
    }
}
