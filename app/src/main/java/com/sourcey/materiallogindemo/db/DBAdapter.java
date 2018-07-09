package com.sourcey.materiallogindemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sourcey.materiallogindemo.bean.AttendanceBean;
import com.sourcey.materiallogindemo.bean.AttendanceSessionBean;
import com.sourcey.materiallogindemo.bean.WorkerBean;

import java.util.ArrayList;

public class DBAdapter extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Attendance";

    // Contacts table name
    private static final String WORKER_INFO_TABLE = "worker";
    private static final String ATTENDANCE_SESSION_TABLE = "attendance_session_table";
    private static final String ATTENDANCE_TABLE = "attendance_table";


    // Contacts Table Columns names
    private static final String KEY_WORKER_ID = "worker_id";
    private static final String KEY_WORKER_NAME = "worker_name";
    private static final String KEY_WORKER_ADDRESS = "worker_address";
    private static final String KEY_WORKER_DEPARTMENT = "worker_department";
    private static final String KEY_WORKER_GENDER = "worker_gender";
    private static final String KEY_WORKER_AADHAR = "worker_aadhar";
    private static final String KEY_WORKER_BANKNAME = "worker_bankname";
    private static final String KEY_WORKER_IFSC = "worker_ifsc";
    private static final String KEY_WORKER_ACCOUNTNUMBER = "worker_accountnumber";


    private static final String KEY_ATTENDANCE_SESSION_ID = "attendance_session_id";
    private static final String KEY_ATTENDANCE_SESSION_FACULTY_ID = "attendance_session_faculty_id";
    private static final String KEY_ATTENDANCE_SESSION_DEPARTMENT = "attendance_session_department";
    private static final String KEY_ATTENDANCE_SESSION_CLASS = "attendance_session_class";
    private static final String KEY_ATTENDANCE_SESSION_DATE = "attendance_session_date";
    private static final String KEY_ATTENDANCE_SESSION_SUBJECT = "attendance_session_subject";

    private static final String KEY_SESSION_ID = "attendance_session_id";
    private static final String KEY_ATTENDANCE_STUDENT_ID = "attendance_student_id";
    private static final String KEY_ATTENDANCE_STATUS = "attendance_status";


    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override

    public void onCreate(SQLiteDatabase db) {


        String queryWorker = "CREATE TABLE " + WORKER_INFO_TABLE + " (" +
                KEY_WORKER_NAME + " TEXT, " +
                KEY_WORKER_GENDER + " TEXT, " +
                KEY_WORKER_ADDRESS + " TEXT, " +
                KEY_WORKER_ID + " INTEGER, " +
                KEY_WORKER_DEPARTMENT + " TEXT," +
                KEY_WORKER_AADHAR + " TEXT," +
                KEY_WORKER_BANKNAME + " TEXT" +
                KEY_WORKER_IFSC + "TEXT" +
                KEY_WORKER_ACCOUNTNUMBER + "TEXT" + ")";
        Log.d("queryWorker", queryWorker);


        String queryAttendanceSession = "CREATE TABLE " + ATTENDANCE_SESSION_TABLE + " (" +
                KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " +
                KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
                KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
                KEY_ATTENDANCE_SESSION_DATE + " DATE," +
                KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" + ")";
        Log.d("queryAttendanceSession", queryAttendanceSession);


        String queryAttendance = "CREATE TABLE " + ATTENDANCE_TABLE + " (" +
                KEY_SESSION_ID + " INTEGER, " +
                KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
                KEY_ATTENDANCE_STATUS + " TEXT " + ")";
        Log.d("queryAttendance", queryAttendance);


        try {
            db.execSQL(queryWorker);
            db.execSQL(queryAttendanceSession);
            db.execSQL(queryAttendance);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {


        String queryWorker = "CREATE TABLE " + WORKER_INFO_TABLE + " (" +
                KEY_WORKER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_WORKER_GENDER + " TEXT, " +
                KEY_WORKER_ADDRESS + " TEXT, " +
                KEY_WORKER_ID + " TEXT, " +
                KEY_WORKER_DEPARTMENT + " TEXT," +
                KEY_WORKER_AADHAR + " TEXT," +
                KEY_WORKER_BANKNAME + " TEXT" +
                KEY_WORKER_IFSC + "TEXT" +
                KEY_WORKER_ACCOUNTNUMBER + "TEXT" + ")";
        Log.d("queryWorker", queryWorker);


        String queryAttendanceSession = "CREATE TABLE " + ATTENDANCE_SESSION_TABLE + " (" +
                KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " +
                KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
                KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
                KEY_ATTENDANCE_SESSION_DATE + " TEXT," +
                KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" + ")";
        Log.d("queryAttendanceSession", queryAttendanceSession);


        String queryAttendance = "CREATE TABLE " + ATTENDANCE_TABLE + " (" +
                KEY_SESSION_ID + " INTEGER, " +
                KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
                KEY_ATTENDANCE_STATUS + " TEXT " + ")";
        Log.d("queryAttendance", queryAttendance);

        try {
            db.execSQL(queryWorker);
            db.execSQL(queryAttendanceSession);
            db.execSQL(queryAttendance);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }
    }

    /*//facult crud
    public void addFaculty(SupervisorBean supervisorBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO faculty_table (faculty_firstname,faculty_Lastname,faculty_mobilenumber,faculty_address,faculty_username,faculty_password) values ('" +
                supervisorBean.getFaculty_firstname() + "', '" +
                supervisorBean.getFaculty_lastname() + "', '" +
                supervisorBean.getFaculty_mobilenumber() + "', '" +
                supervisorBean.getFaculty_address() + "', '" +
                supervisorBean.getFaculty_username() + "', '" +
                supervisorBean.getFaculty_password() + "')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public SupervisorBean validateFaculty(String userName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM faculty_table where faculty_username='" + userName + "' and faculty_password='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {

            SupervisorBean supervisorBean = new SupervisorBean();
            supervisorBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
            supervisorBean.setFaculty_firstname(cursor.getString(1));
            supervisorBean.setFaculty_lastname(cursor.getString(2));
            supervisorBean.setFaculty_mobilenumber(cursor.getString(3));
            supervisorBean.setFaculty_address(cursor.getString(4));
            supervisorBean.setFaculty_username(cursor.getString(5));
            supervisorBean.setFaculty_password(cursor.getString(6));
            return supervisorBean;
        }
        return null;
    }

    public ArrayList<SupervisorBean> getAllFaculty() {
        Log.d("in get all", "in get all");
        ArrayList<SupervisorBean> list = new ArrayList<SupervisorBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM faculty_table";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                SupervisorBean supervisorBean = new SupervisorBean();
                supervisorBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
                supervisorBean.setFaculty_firstname(cursor.getString(1));
                supervisorBean.setFaculty_lastname(cursor.getString(2));
                supervisorBean.setFaculty_mobilenumber(cursor.getString(3));
                supervisorBean.setFaculty_address(cursor.getString(4));
                supervisorBean.setFaculty_username(cursor.getString(5));
                supervisorBean.setFaculty_password(cursor.getString(6));
                list.add(supervisorBean);

            } while (cursor.moveToNext());
        }
        return list;
    }

    public void deleteFaculty(int facultyId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM faculty_table WHERE faculty_id=" + facultyId;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }*/

    //student crud
    public void addStudent(com.sourcey.materiallogindemo.bean.WorkerBean workerBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO `worker`(`name`, `gender`, `address`, `id_no`, `department`, `aadhar`, `bank_name`, `ifsc_code`, `account_no`) VALUES ('" +
                workerBean.getWorker_name() + "', '" +
                workerBean.getWorker_gender() + "','" +
                workerBean.getWorker_address() + "', '" +
                workerBean.getWorker_id() + "', '" +
                workerBean.getWorker_aadhar() + "', '" +
                workerBean.getWorker_bankname() + "', '" +
                workerBean.getWorker__ifsc() + "', '" +
                workerBean.getWorker_accountnumber() + "')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public ArrayList<WorkerBean> getAllStudent() {
        ArrayList<WorkerBean> list = new ArrayList<WorkerBean>();


        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM student_table";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                WorkerBean workerBean = new WorkerBean();
                workerBean.setWorker_name((cursor.getString(0)));
                workerBean.setWorker_gender(cursor.getString(1));
                workerBean.setWorker_address(cursor.getString(2));
                workerBean.setWorker_id(cursor.getInt(3));
                workerBean.setWorker_department(cursor.getString(4));
                workerBean.setWorker_aadhar(cursor.getString(5));
                workerBean.setWorker_bankname(cursor.getString(6));
                workerBean.setWorker__ifsc(cursor.getString(7));
                workerBean.setWorker_accountnumber(cursor.getString(8));
                list.add(workerBean);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<WorkerBean> getAllWorkerByDepartment(String department) {
        ArrayList<WorkerBean> list = new ArrayList<WorkerBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM worker where department='" + department + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                WorkerBean workerBean = new WorkerBean();
                workerBean.setWorker_name((cursor.getString(0)));
                workerBean.setWorker_gender(cursor.getString(1));
                workerBean.setWorker_address(cursor.getString(2));
                workerBean.setWorker_id(cursor.getInt(3));
                workerBean.setWorker_department(cursor.getString(4));
                workerBean.setWorker_aadhar(cursor.getString(5));
                workerBean.setWorker_bankname(cursor.getString(6));
                workerBean.setWorker__ifsc(cursor.getString(7));
                workerBean.setWorker_accountnumber(cursor.getString(8));
                list.add(workerBean);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<WorkerBean> getAllWorkerByid(int workerId) {
        ArrayList<WorkerBean> list = new ArrayList<WorkerBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM worker where id_no=" + workerId;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                WorkerBean workerBean1 = new WorkerBean();
                workerBean1.setWorker_name((cursor.getString(0)));
                workerBean1.setWorker_gender(cursor.getString(1));
                workerBean1.setWorker_address(cursor.getString(2));
                workerBean1.setWorker_id(cursor.getInt(3));
                workerBean1.setWorker_department(cursor.getString(4));
                workerBean1.setWorker_aadhar(cursor.getString(5));
                workerBean1.setWorker_bankname(cursor.getString(6));
                workerBean1.setWorker__ifsc(cursor.getString(7));
                workerBean1.setWorker_accountnumber(cursor.getString(8));
                list.add(workerBean1);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void deleteWorker(int worker_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM worker WHERE id_no=" + worker_id;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    //attendance session Table crud
    public int addAttendanceSession(AttendanceSessionBean attendanceSessionBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO attendance_session_table (attendance_session_faculty_id,attendance_session_department,attendance_session_class,attendance_session_date,attendance_session_subject) values ('" +
                attendanceSessionBean.getAttendance_session_faculty_id() + "', '" +
                attendanceSessionBean.getAttendance_session_department() + "','" +
                attendanceSessionBean.getAttendance_session_class() + "', '" +
                attendanceSessionBean.getAttendance_session_date() + "', '" +
                attendanceSessionBean.getAttendance_session_subject() + "')";
        Log.d("query", query);
        db.execSQL(query);

        String query1 = "select max(attendance_session_id) from attendance_session_table";
        Cursor cursor = db.rawQuery(query1, null);

        if (cursor.moveToFirst()) {
            int sessionId = Integer.parseInt(cursor.getString(0));

            return sessionId;
        }


        db.close();
        return 0;
    }

    public ArrayList<AttendanceSessionBean> getAllAttendanceSession() {
        ArrayList<AttendanceSessionBean> list = new ArrayList<AttendanceSessionBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM attendance_session_table";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                AttendanceSessionBean attendanceSessionBean = new AttendanceSessionBean();
                attendanceSessionBean.setAttendance_session_id(Integer.parseInt(cursor.getString(0)));
                attendanceSessionBean.setAttendance_session_faculty_id(Integer.parseInt(cursor.getString(1)));
                attendanceSessionBean.setAttendance_session_department(cursor.getString(2));
                attendanceSessionBean.setAttendance_session_class(cursor.getString(3));
                attendanceSessionBean.setAttendance_session_date(cursor.getString(4));
                attendanceSessionBean.setAttendance_session_subject(cursor.getString(5));
                list.add(attendanceSessionBean);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void deleteAttendanceSession(int attendanceSessionId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM attendance_session_table WHERE attendance_session_id=" + attendanceSessionId;

        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    //attendance crud
    public void addNewAttendance(AttendanceBean attendanceBean) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO attendance_table values (" +
                attendanceBean.getAttendance_session_id() + ", " +
                attendanceBean.getAttendance_student_id() + ", '" +
                attendanceBean.getAttendance_status() + "')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }


    public ArrayList<AttendanceBean> getAttendanceBySessionID(AttendanceSessionBean attendanceSessionBean) {
        int attendanceSessionId = 0;
        ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM attendance_session_table where attendance_session_faculty_id=" + attendanceSessionBean.getAttendance_session_faculty_id() + ""
                + " AND attendance_session_department='" + attendanceSessionBean.getAttendance_session_department() + "' AND attendance_session_class='" + attendanceSessionBean.getAttendance_session_class() + "'" +
                " AND attendance_session_date='" + attendanceSessionBean.getAttendance_session_date() + "' AND attendance_session_subject='" + attendanceSessionBean.getAttendance_session_subject() + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                attendanceSessionId = (Integer.parseInt(cursor.getString(0)));
            } while (cursor.moveToNext());
        }

        String query1 = "SELECT * FROM attendance_table where attendance_session_id=" + attendanceSessionId + " order by attendance_student_id";
        Cursor cursor1 = db.rawQuery(query1, null);
        if (cursor1.moveToFirst()) {
            do {
                AttendanceBean attendanceBean = new AttendanceBean();
                attendanceBean.setAttendance_session_id(Integer.parseInt(cursor1.getString(0)));
                attendanceBean.setAttendance_student_id(Integer.parseInt(cursor1.getString(1)));
                attendanceBean.setAttendance_status(cursor1.getString(2));
                list.add(attendanceBean);

            } while (cursor1.moveToNext());
        }
        return list;
    }

    public ArrayList<AttendanceBean> getTotalAttendanceBySessionID(AttendanceSessionBean attendanceSessionBean) {
        int attendanceSessionId = 0;
        ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM attendance_session_table where attendance_session_faculty_id=" + attendanceSessionBean.getAttendance_session_faculty_id() + ""
                + " AND attendance_session_department='" + attendanceSessionBean.getAttendance_session_department() + "' AND attendance_session_class='" + attendanceSessionBean.getAttendance_session_class() + "'" +
                " AND attendance_session_subject='" + attendanceSessionBean.getAttendance_session_subject() + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                attendanceSessionId = (Integer.parseInt(cursor.getString(0)));

                String query1 = "SELECT * FROM attendance_table where attendance_session_id=" + attendanceSessionId + " order by attendance_student_id";
                Cursor cursor1 = db.rawQuery(query1, null);
                if (cursor1.moveToFirst()) {
                    do {
                        AttendanceBean attendanceBean = new AttendanceBean();
                        attendanceBean.setAttendance_session_id(Integer.parseInt(cursor1.getString(0)));
                        attendanceBean.setAttendance_student_id(Integer.parseInt(cursor1.getString(1)));
                        attendanceBean.setAttendance_status(cursor1.getString(2));
                        list.add(attendanceBean);

                    } while (cursor1.moveToNext());
                }

                AttendanceBean attendanceBean = new AttendanceBean();
                attendanceBean.setAttendance_session_id(0);
                attendanceBean.setAttendance_status("Date : " + cursor.getString(4));
                list.add(attendanceBean);

            } while (cursor.moveToNext());
        }


        return list;
    }

    public ArrayList<AttendanceBean> getAllAttendanceByStudent() {
        ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT attendance_student_id,count(*) FROM attendance_table where attendance_status='P' group by attendance_student_id";

        Log.d("query", query);

        Cursor cursor = db.rawQuery(query, null);


        if (cursor.moveToFirst()) {
            do {
                Log.d("studentId", "studentId:" + cursor.getString(0) + ", Count:" + cursor.getString(1));
                AttendanceBean attendanceBean = new AttendanceBean();
                attendanceBean.setAttendance_student_id(Integer.parseInt(cursor.getString(0)));
                attendanceBean.setAttendance_session_id(Integer.parseInt(cursor.getString(1)));
                list.add(attendanceBean);

            } while (cursor.moveToNext());
        }
        return list;
    }
	/*public ArrayList<AttendanceBean> getAllAttendanceBySessionID(int sessionId)
	{
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM attendance_table where attendance_session_id=" + sessionId;
		Cursor cursor = db.rawQuery(query, null);

		if(!cursor.moveToFirst()) 
		{
			do{
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setAttendance_session_id(Integer.parseInt(cursor.getString(0)));
				attendanceBean.setAttendance_student_id(Integer.parseInt(cursor.getString(1)));
				attendanceBean.setAttendance_status(cursor.getString(2));
				list.add(attendanceBean);

			}while(cursor.moveToNext());
		}
		return list;
	}*/


    // Creating Tables
	/*@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_User_Info_TABLE = "CREATE TABLE " + TABLE_INFO_USER + "("
				+ KEY_ID + " INTEGER PRIMARY KEY, " + KEY_FIRSTNAME + " TEXT, "+ KEY_LASTNAME + " TEXT, " +KEY_MO_NO +" TEXT, "
				+KEY_EMAIL +" TEXT, " +KEY_USERNAME +" TEXT, " + KEY_PASSWORD +" TEXT " + ")";

		Log.d("rupali",CREATE_User_Info_TABLE );
		db.execSQL(CREATE_User_Info_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO_USER);

		// Create tables again
		onCreate(db);
	}

	 *//**
     * All CRUD(Create, Read, Update, Delete) Operations
     *//*



	void addUserInfo(UserInfo userinfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_FIRSTNAME, userinfo.getUser_Firstname()); //  Name
		values.put(KEY_LASTNAME, userinfo.getUser_Lastname()); //  Name
		values.put(KEY_MO_NO, userinfo.getUser_MobileNo()); // Contact Phone
		values.put(KEY_EMAIL, userinfo.getUser_EmailId());
		values.put(KEY_USERNAME, userinfo.getUser_Username());
		values.put(KEY_PASSWORD, userinfo.getUser_Password());

		// Inserting Row
		db.insert(TABLE_INFO_USER, null, values);
		//2nd argument is String containing nullColumnHack
		db.close(); // Closing database connection
	}


	// Getting single contact
	UserInfo getUserInfo(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_INFO_USER, new String[] { KEY_ID,
				KEY_FIRSTNAME, KEY_LASTNAME,KEY_MO_NO,  KEY_EMAIL, KEY_USERNAME, KEY_PASSWORD }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		UserInfo userinfo = new UserInfo(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6));
		// return contact
				return userinfo;
	}

	public UserInfo validateUser(String username, String password)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "Select * from User_Info_Table WHERE User_Username='"+ username +"' AND User_Password='"+password+"'";
		Log.d("Rupali", "Login QUERY:" + query);

		Cursor cursor = db.rawQuery(query, null);


		if(!cursor.moveToFirst()) 
		{
			Log.d("Rupali", "cursor is null.. returing NULL");
			return null;
		}
		Log.d("Rupali", "cursor is NOT null.. we got user data...");


		UserInfo userinfo = new UserInfo(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6));

		return userinfo;
	}

	// Updating single contact
	public int updateUserPassword(UserInfo userinfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_PASSWORD, userinfo.getUser_Password());


		// updating row
		return db.update(TABLE_INFO_USER, values, KEY_ID + " = ?",
				new String[] { String.valueOf(userinfo.getUser_id()) });
	}

	public int updateUserContact(UserInfo userinfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_MO_NO, userinfo.getUser_MobileNo());
		values.put(KEY_EMAIL, userinfo.getUser_EmailId());


		// updating row
		return db.update(TABLE_INFO_USER, values, KEY_ID + " = ?",
				new String[] { String.valueOf(userinfo.getUser_id()) });
	}


	//veiw details

	public UserInfo viewUserInfo(String id) {
		SQLiteDatabase db = this.getReadableDatabase();

		String query = "Select * from User_Info_Table WHERE id='"+id+"'";
		Cursor cursor = db.rawQuery(query, null);
		if(!cursor.moveToFirst()) 
		{
			Log.d("Rupali", "cursor is null.. returing NULL");
			return null;
		}
		Log.d("Rupali", "cursor is NOT null.. we got user data...");

		UserInfo userinfo = new UserInfo(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6));
		// return contact
		return userinfo;
	}



	 // Getting All users
    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> userinfolist = new ArrayList<UserInfo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_INFO_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                UserInfo userinfo=new UserInfo();

                userinfo.setUser_id(Integer.parseInt(cursor.getString(0)));
                userinfo.setUser_Lastname(cursor.getString(2));
                userinfo.setUser_Username(cursor.getString(5));
                userinfo.setUser_Firstname(cursor.getString(1));



                // Adding contact to list
                userinfolist.add(userinfo);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userinfolist;
    }

    // Deleting single contact
    public void deleteUser(UserInfo userinfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INFO_USER, KEY_ID + " = ?",
                new String[] { String.valueOf(userinfo.getUser_id()) });
        db.close();
    }
	  */
}