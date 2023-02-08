package com.swordHostDemo.utls;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @date: 2022/12/30 18:12
 * @description:
 */
public class SQLiteUtls {

    //初始化
    public static void init() {
        sqlTable(initTable());
    }

    public static String initTable() {
        String sql = "";
        if (!checkDbFile()) {
            createSQLiteDB();
            String customTable = "CREATE TABLE IF NOT EXISTS `custom` (" +
                    "`name` VARCHAR(40) NOT NULL," +
                    "`namevalue` VARCHAR(40) NOT NULL" +
                    ");";


            String custom1Table =
                    "CREATE TABLE IF NOT EXISTS `menu` ( `id` INT PRIMARY KEY NOT NULL," +
                    "`Lhost` VARCHAR(255) NOT NULL, `Lport` VARCHAR(255) NOT NULL ," +
                    "`DnsLog` VARCHAR(255) NOT NULL,`FileName` VARCHAR(255) NOT NULL," +
                    "`Rhost` VARCHAR(255) NOT NULL,`Rport` VARCHAR(255) NOT NULL," +
                    "`Command` VARCHAR(255) NOT NULL,`remark` VARCHAR(255) NOT NULL);";

            String insertCustomInit = "INSERT INTO custom (name,namevalue) VALUES ('customValue','');";

            String insertCustom1Init = "INSERT INTO menu (id,Lhost,Lport,Dnslog,FileName,Rhost,Rport,Command,remark) VALUES ('1','','','','','','','','');";

            sql =  customTable + insertCustomInit + custom1Table + insertCustom1Init;
        }
        return sql;

    }

    //创建数据库
    public static void createSQLiteDB() {
        {
            Connection c = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:data.db");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
    }

    public static boolean checkDbFile() {
        return (new File("data.db")).exists();
    }

    //执行sql语句
    public static void sqlTable(String sql) {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:data.db");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                stmt.executeUpdate(sql);
                stmt.setQueryTimeout(60);
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table created successfully");
        }
    }

}