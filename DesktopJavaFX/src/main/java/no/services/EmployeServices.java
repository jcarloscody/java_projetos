package no.services;

import no.database.repository.EmployeeReposit;
import no.entities.Employee;

import java.sql.SQLException;

public class EmployeServices {

    public static void Insert(Employee e) throws SQLException {
        EmployeeReposit.insertEmployee(e);
    }
}
