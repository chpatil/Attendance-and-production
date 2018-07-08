package com.sourcey.materiallogindemo.context;

import android.app.Application;

import com.sourcey.materiallogindemo.bean.AttendanceBean;
import com.sourcey.materiallogindemo.bean.AttendanceSessionBean;
import com.sourcey.materiallogindemo.bean.StudentBean;
import com.sourcey.materiallogindemo.bean.SupervisorBean;

import java.util.ArrayList;

public class ApplicationContext extends Application {
    private SupervisorBean supervisorBean;
    private AttendanceSessionBean attendanceSessionBean;
    private ArrayList<StudentBean> studentBeanList;
    private ArrayList<AttendanceBean> attendanceBeanList;

    public SupervisorBean getSupervisorBean() {
        return supervisorBean;
    }

    public void setSupervisorBean(SupervisorBean supervisorBean) {
        this.supervisorBean = supervisorBean;
    }

    public AttendanceSessionBean getAttendanceSessionBean() {
        return attendanceSessionBean;
    }

    public void setAttendanceSessionBean(AttendanceSessionBean attendanceSessionBean) {
        this.attendanceSessionBean = attendanceSessionBean;
    }

    public ArrayList<StudentBean> getStudentBeanList() {
        return studentBeanList;
    }

    public void setStudentBeanList(ArrayList<StudentBean> studentBeanList) {
        this.studentBeanList = studentBeanList;
    }

    public ArrayList<AttendanceBean> getAttendanceBeanList() {
        return attendanceBeanList;
    }

    public void setAttendanceBeanList(ArrayList<AttendanceBean> attendanceBeanList) {
        this.attendanceBeanList = attendanceBeanList;
    }


}
